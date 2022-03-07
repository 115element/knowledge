package com.example.logmonitor.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

@Component
public class LogApi {
    private static final Logger logger = LoggerFactory.getLogger(LogApi.class);
    @Autowired
    HttpUtils httpUtils;


    public BigDecimal queryLog(String domain, String accessKey, String secretKey) throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("domain", domain);
        jsonObject.put("startTime", "2021-09-07 00:00");
        jsonObject.put("endTime", "2021-09-07 23:55");
        String result = jsonObject.toString();
        String timestamp = System.currentTimeMillis() + "";

        String url = "https://api.asia-isp.com/openapi/v3/stat?action=cdnLogDownload";
        URI uri = new URI(url);
        String query = uri.getQuery();
        String nonce = UUID.randomUUID().toString().substring(0, 8);
        String post = Signature.getOrignal(query, result, nonce, secretKey, timestamp, uri.getPath(), "post");

        String generate = Signature.generate(post, secretKey);

        String response = httpUtils.postRequest(url, result, accessKey, nonce, timestamp, generate);
        JSONObject body = JSONObject.parseObject(response);
        System.out.println(JSONObject.parseObject(JSONObject.parseObject(body.getString("data")).getString(domain)));
        if (JSONObject.parseObject(JSONObject.parseObject(body.getString("data")).getString(domain)) != null) {

            JSONArray urlArray = JSONArray.parseArray(JSONObject.parseObject(JSONObject.parseObject(JSONObject.parseObject(body.getString("data")).getString(domain)).toString()).getString("2021-09-07").toString());

            List<String> urlList = new ArrayList<>();

            final BigDecimal[] flowSum = {BigDecimal.ZERO};

            for (Object i : urlArray) {
                urlList.add(JSONObject.parseObject(i.toString()).getString("url"));
            }


            /**
             * InputStream is;
             * 注意这个方法只能正确读取本地文件的流is.available()就是全部的字节数。
             * 如果是网络过来的流的话is.available()可就不是全部字节数了，而只是当前可读的字节数
             */

            urlList.forEach(i -> {
                try {
                    System.out.println("资源包:" + i);
                    InputStream inputStream1 = urlDownload(i);

                    //因为网络通讯往往是间断性的，一串字节往往分几批进行发送。例如对方发来字节长度100的数据，
                    //本地程序调用available()方法有时得到0，有时得到50，有时能得到100，大多数情况下是100。
                    //这可能是对方还没有响应，也可能是对方已经响应了，但是数据还没有送达本地。也许分3批到达，也许分两批，也许一次性到达。
                    //对方发送的数据是会自动分包的，这个过程不受你控制。
                    System.out.println("当前流可用长度，不是流的总长度:" + inputStream1.available());

                    //TODO ①如果不拷贝流，那么会导致数据读取不完整,很奇怪
                    //ByteArrayOutputStream byteArrayOutputStream = this.copyStream(inputStream1);
                    //InputStream inputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

                    //TODO ②休眠大于等于10毫秒也能解决流读取不完整问题，很奇怪
                    //Thread.sleep(10);

                    GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream1);
                    InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream);
                    BufferedReader br = new BufferedReader(inputStreamReader, 819200000); //TODO ③指定默认字符缓冲区大小,也能解决该问题
                    String line = null;
                    BigDecimal lineline = BigDecimal.ZERO;

                    //ready()方法用于检查此BufferedReader流是否准备就绪或无法读取。
//                    while (br.ready()) {
//                        line = br.readLine();
//                        System.out.println(line);
//                        lineline = lineline.add(new BigDecimal(line.split(" ")[8]));
//                    }

                    //考虑网络数据是分批次到达，是否下一批次数据还未到达，这里读取没有，或者没来得及复制到缓冲区，直接返回了，这也解释了，上边方法，使用ready()方法，每次读取到的都一样
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                        lineline = lineline.add(new BigDecimal(line.split(" ")[8]));
                    }

                    flowSum[0] = flowSum[0].add(lineline);
                    System.out.println(lineline);
                    close(inputStream1, gzipInputStream, inputStreamReader, br);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            /**
             * 除以1000000
             * 并且保留两位小数
             */
            System.out.println("总计:" + flowSum[0]);
            BigDecimal flow = flowSum[0].divide(BigDecimal.valueOf(1000000)).setScale(2, BigDecimal.ROUND_HALF_UP);
            return flow;
        } else {
            return BigDecimal.valueOf(0);
        }
    }


    public void close(InputStream stream1, GZIPInputStream gzipInputStream, InputStreamReader inputStreamReader, BufferedReader br) {
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            logger.error("br关闭失败,", e);
        }
        try {
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (IOException e) {
            logger.error("inputStreamReader关闭失败,", e);
        }
        try {
            if (gzipInputStream != null) {
                gzipInputStream.close();
            }
        } catch (IOException e) {
            logger.error("gzipInputStream关闭失败,", e);
        }
        try {
            if (stream1 != null) {
                stream1.close();
            }
        } catch (IOException e) {
            logger.error("stream2关闭失败,", e);
        }
        logger.debug(Thread.currentThread().getName() + " 关闭流成功");
    }

    public InputStream urlDownload(String downloadUrl) throws Exception {
        InputStream inStream = null;
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(60000);
            conn.setReadTimeout(60000);
            /**
             * HTTP Header中Accept-Encoding 是浏览器发给服务器,声明浏览器支持的编码类型的。
             *      常见的有
             *        Accept-Encoding: compress, gzip　　　　　　　　　　　　  //支持compress 和gzip类型
             *        Accept-Encoding:　　　　　　　　　　　　　　　　　　　      //默认是identity
             *        Accept-Encoding: *　　　　　　　　　　　　　　　　　　      //支持所有类型
             *        Accept-Encoding: compress;q=0.5, gzip;q=1.0　　　　　　 //按顺序支持 gzip , compress
             *        Accept-Encoding: gzip;q=1.0, identity; q=0.5, *;q=0   // 按顺序支持 gzip , identity
             */
            conn.setRequestProperty("Accept-Encoding", "identity");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode == 200 || responseCode == 201) {
                int contentLength = conn.getContentLength();
                System.out.println("网络包数据总大小：" + contentLength);
                inStream = conn.getInputStream();
            } else {
                throw new Exception("下载失败，code：" + responseCode);
            }
        } catch (Exception e) {
            logger.error("下载失败，", e);
            throw new Exception(e.getMessage());
        }
        return inStream;
    }

    /**
     * 复制流
     *
     * @param input
     * @return
     */
    private ByteArrayOutputStream copyStream(InputStream input) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[10240];
            int len;
            while ((len = input.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baos;
    }


}
