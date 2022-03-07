package com.example.logmonitor.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.net.URI;

import java.util.UUID;

@Component
public class CdnFlow {
    private static final Logger logger = LoggerFactory.getLogger(CdnFlow.class);
    @Autowired
    HttpUtils httpUtils;


    public BigDecimal queryFlow(String domain ,String accessKey,String secretKey) throws Exception {

        /**
         * 根据传递进来的域名以及AK,SK查询流量
         * 并且求和
         */
        BigDecimal sum = new BigDecimal(0);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("domains", domain);
            jsonObject.put("startTime", "2021-09-07 00:00");
            jsonObject.put("endTime", "2021-09-07 23:55");
            jsonObject.put("grad", "minute5");
            String result = jsonObject.toString();

            String timestamp = System.currentTimeMillis() + "";
            String url = "https://api.asia-isp.com/openapi/v3/stat?action=cdnFlow";
            URI uri = new URI(url);
            String query = uri.getQuery();
            String nonce = UUID.randomUUID().toString().substring(0, 8);
            String post = Signature.getOrignal(query, result, nonce, secretKey, timestamp, uri.getPath(), "post");

            String generate = Signature.generate(post, secretKey);


            String response = httpUtils.postRequest(url, result, accessKey, nonce, timestamp, generate);

            JSONObject body = JSONObject.parseObject(response);

            JSONArray flowArray = JSONArray.parseArray(JSONObject.parseObject(body.getString("data")).getString(domain));

            if (flowArray!=null) {
                for (Object i : flowArray) {
                    sum = sum.add((BigDecimal) JSONObject.parseObject(i.toString()).get("flow"));
                }

            }else {

                logger.error("{},该域名没有流量,{}", domain);

            }

        } catch (Exception e) {
            logger.error("{},通过API获取流量失败,{}", domain, e);
        }
        return sum;
    }


}
