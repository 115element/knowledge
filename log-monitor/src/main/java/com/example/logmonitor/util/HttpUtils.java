/**
 * Copyright (C), 2019-2020, 橙域
 * FileName: HttpUtils
 * Author:   admin
 * Date:     2020/3/3 14:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.logmonitor.util;


import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;

/**
 * @author longtw
 * @title: HttpUtils
 * @projectName chengyu
 * @description: TODO
 * @date 2020/3/314:48
 */
@Component
public class HttpUtils {
    private final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private static int timeout = 20000;

    /**
     * get方式的接口请求
     *
     * @param url
     * @return
     */
    public String getRequest(String url, String requestId, String account, String accessKey) throws HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        url = url.replaceAll(" ", "%20");// 替换url中的空格
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout)//一、连接超时：connectionTimeout-->指的是连接一个url的连接等待时间
                .setSocketTimeout(timeout * 2)
                .setConnectionRequestTimeout(timeout)
                .build();
        try {
            logger.info("{},{},URL：{}", requestId, "建联开始", url);
            HttpGet httpGet = new HttpGet(url);
            //设置超时时间
            httpGet.setConfig(requestConfig);
            //消息头
            httpGet.setHeader("Connection", "close");
            httpGet.setHeader("Content-Type", "application/json");
            httpGet.setHeader("Request-id", requestId);
            httpGet.setHeader("account", account);
            httpGet.setHeader("accessKey", accessKey);


            CloseableHttpResponse response = httpClient.execute(httpGet);

            StatusLine statusLine = response.getStatusLine();
            Header[] allHeaders = response.getAllHeaders();
            logger.debug("{},get head,{}", requestId, JsonUtils.toJSONString(allHeaders));
            logger.info("{}建联完毕,{},请求结果：{} {}", requestId, url, statusLine.getStatusCode(), statusLine.getReasonPhrase());
            logger.debug("{},{}请求结果：{} {}", requestId, url, statusLine.getStatusCode(), statusLine.getReasonPhrase());
            HttpEntity bodyEntity = response.getEntity();
            String bodyStr = EntityUtils.toString(bodyEntity, "UTF-8");
            logger.debug("{},返回数据结果：body={}", requestId, bodyStr);
            if (statusLine.getStatusCode() == 200) {
                return bodyStr;
            } else {
                logger.error("{},{}:{}请求失败,{},{}", requestId, statusLine.getStatusCode(), statusLine.getReasonPhrase(), url, bodyStr);
            }
        } catch (SSLHandshakeException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } catch (ConnectTimeoutException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } catch (ClientProtocolException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } catch (IOException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                logger.error("{},httpClient关闭失败", requestId);
                throw new HttpException(e.getMessage());
            }
        }
        return null;
    }

    /**
     * delete方式的接口请求
     *
     * @param url
     * @return
     */
    public String deleteRequest(String url, String requestId, String body, String authStr) throws HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        url = url.replaceAll(" ", "%20");// 替换url中的空格
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout)//一、连接超时：connectionTimeout-->指的是连接一个url的连接等待时间
                .setSocketTimeout(timeout * 2)
                .setConnectionRequestTimeout(timeout)
                .build();
        try {
            logger.info("{},{},URL：{}", requestId, "建联开始", url);
            overrideHttpDelete httpDelete = new overrideHttpDelete(url);
            //设置超时时间
            httpDelete.setConfig(requestConfig);
            //消息头
            httpDelete.setHeader("Connetion", "close");
            httpDelete.setHeader("Content-Type", "application/json");
            httpDelete.setHeader("Request-id", requestId);
            httpDelete.setHeader("Authorization", authStr);
            if (StringUtils.isNotBlank(body)) {
                StringEntity entity = new StringEntity(body, "utf-8");
                httpDelete.setEntity(entity);
            }
            CloseableHttpResponse response = httpClient.execute(httpDelete);

            StatusLine statusLine = response.getStatusLine();
            Header[] allHeaders = response.getAllHeaders();
            logger.debug("{},delete head,{}", requestId, JsonUtils.toJSONString(allHeaders));
            logger.info("{}建联完毕,{},请求结果：{} {}", requestId, url, statusLine.getStatusCode(), statusLine.getReasonPhrase());
            logger.debug("{},{}请求结果：{} {}", requestId, url, statusLine.getStatusCode(), statusLine.getReasonPhrase());
            HttpEntity bodyEntity = response.getEntity();
            String bodyStr = EntityUtils.toString(bodyEntity, "UTF-8");
            logger.debug("{},返回数据结果：body={}", requestId, bodyStr);
            if (statusLine.getStatusCode() == 200) {
                return bodyStr;
            } else {
                logger.error("{},{}:{}请求失败,{},{}", requestId, statusLine.getStatusCode(), statusLine.getReasonPhrase(), url, bodyStr);
            }
        } catch (SSLHandshakeException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } catch (ConnectTimeoutException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } catch (ClientProtocolException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } catch (IOException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                logger.error("{},httpClient关闭失败", requestId);
                throw new HttpException(e.getMessage());
            }
        }
        return null;
    }


    public String postRequest(String url, String body, String accessKey, String nonce, String timestamp, String signature) throws HttpException {
        String requestId = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        url = url.replaceAll(" ", "%20");// 替换url中的空格
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout)//一、连接超时：connectionTimeout-->指的是连接一个url的连接等待时间
                .setSocketTimeout(timeout * 2)
                .setConnectionRequestTimeout(timeout)
                .build();
        HttpPost httpPost = new HttpPost(url);
        // 设置超时时间
        httpPost.setConfig(requestConfig);
        // 消息头
        httpPost.setHeader("Connection", "close");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("accessKeyId", accessKey);
        httpPost.setHeader("nonce", nonce);
        httpPost.setHeader("timestamp", timestamp);
        httpPost.setHeader("signature", signature);
        try {
            // 消息体
            if (StringUtils.isNotBlank(body)) {
                logger.info("{},post请求body,{}", requestId, body);
                StringEntity entity = new StringEntity(body, Charset.forName("UTF-8"));
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            Header[] allHeaders = response.getAllHeaders();
            logger.debug("{},post head,{}", requestId, JsonUtils.toJSONString(allHeaders));
            logger.debug("{},请求结果：{} {},url={}", requestId, response.getStatusLine().getStatusCode(),
                    response.getStatusLine().getReasonPhrase(), url);

            HttpEntity bodyEntity = response.getEntity();
            String bodyStr = EntityUtils.toString(bodyEntity, "UTF-8");
            logger.debug("{},返回数据结果：body={},url={}", requestId, bodyStr, url);
            if (response.getStatusLine().getStatusCode() == 200) {
                return bodyStr;
            } else {
                logger.error("{},请求失败：{} {},url={}", requestId, response.getStatusLine().getStatusCode(),
                        response.getStatusLine().getReasonPhrase(), url);
            }
        } catch (ClientProtocolException e) {
            logger.error("postRequest error", e);
            throw new HttpException(e.getMessage());
        } catch (IOException e) {
            logger.error("postRequest error", e);
            throw new HttpException(e.getMessage());
        } catch (Exception e) {
            logger.error("postRequest error", e);
            throw new HttpException(e.getMessage());
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                logger.error("{},httpClient关闭失败", requestId);
                throw new HttpException(e.getMessage());
            }
        }
        return null;
    }


    public String putRequest(String url, String requestId, String body, String account, String accessKey) throws HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        url = url.replaceAll(" ", "%20");// 替换url中的空格
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout)// 一、连接超时：connectionTimeout-->指的是连接一个url的连接等待时间
                .setSocketTimeout(timeout * 2).setConnectionRequestTimeout(timeout).build();
        try {
            logger.info("{},请求url,{}", requestId, url);
            HttpPut httpPut = new HttpPut(url);
            // 消息头
            httpPut.setHeader("Connection", "close");
            httpPut.setHeader("Content-Type", "application/json");
            httpPut.setHeader("account", account);
            httpPut.setHeader("accessKey", accessKey);
            httpPut.setHeader("Request-id", requestId);

            httpPut.setConfig(requestConfig);
            StringEntity entity = new StringEntity(body.trim(), Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPut.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(httpPut);
            StatusLine statusLine = response.getStatusLine();
            logger.debug("{},{}请求结果：{} {}", requestId, url, statusLine.getStatusCode(), statusLine.getReasonPhrase());
            HttpEntity bodyEntity = response.getEntity();
            String bodyStr = EntityUtils.toString(bodyEntity, "UTF-8");
            logger.debug("{},返回结果,{}", requestId, bodyStr);
            if (response.getStatusLine().getStatusCode() == 200) {
                return bodyStr;
            } else {
                logger.error("{},请求失败：{} {},url={}", requestId, response.getStatusLine().getStatusCode(),
                        response.getStatusLine().getReasonPhrase(), url);
            }
        } catch (SSLHandshakeException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } catch (ConnectTimeoutException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } catch (ClientProtocolException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } catch (IOException e) {
            logger.error("http error", e);
            throw new HttpException(e.getMessage());
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                logger.error("{},httpClient关闭失败", requestId);
                throw new HttpException(e.getMessage());
            }
        }
        return null;
    }


    /**
     * HttpClient自带的HttpDelete方法是不支持上传body的，所以重写delete方法
     */
    class overrideHttpDelete extends HttpEntityEnclosingRequestBase {

        public static final String METHOD_NAME = "DELETE";

        @Override
        public String getMethod() {
            return METHOD_NAME;
        }

        public overrideHttpDelete(final String uri) {
            super();
            setURI(URI.create(uri));
        }

        public overrideHttpDelete(final URI uri) {
            super();
            setURI(uri);
        }

        public overrideHttpDelete() {
            super();
        }
    }


    @Value("${api.http.timeout}")
    public void setTimeout(int timeout) {
        HttpUtils.timeout = timeout > 1000 ? timeout : 20000;
    }
}
