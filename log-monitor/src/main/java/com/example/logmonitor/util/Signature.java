package com.example.logmonitor.util;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;
public class Signature {


    private static final String CHARSET_UTF8 = "utf8";
    private static final String ALGORITHM = "UTF-8";
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    /**
     * 生成签名
     *
     * @param data
     * @param secretKey 用户秘钥
     * @return 返回签名
     * @throws Exception
     */
    public static String generate1(String data, String secretKey) throws Exception {
        if (StringUtils.isBlank(data)) {
            throw new Exception();
        }
        if (StringUtils.isBlank(secretKey)) {
            throw new Exception();
        }
        byte[] signBytes = hmacSHA1Signature(secretKey, data);
        String encodeToString = Base64.getEncoder().encodeToString(signBytes);
        ;//qiutxkoGeygk8Tl_bjFb-zqWdqM=    url加密 安全的url:转换+为- /为_ 将多余的=去掉
//        String encodeToString = new String(signBytes);//qiutxkoGeygk8Tl_bjFb-zqWdqM=    url加密 安全的url:转换+为- /为_ 将多余的=去掉

        return encodeToString;
    }

    /**
     * 生成签名
     *
     * @param data
     * @param secretKey 用户秘钥
     * @return 返回签名
     * @throws Exception
     */
    public static String generate(String data, String secretKey) throws Exception {
        if (StringUtils.isBlank(data)) {
            throw new Exception();
        }
        if (StringUtils.isBlank(secretKey)) {
            throw new Exception();
        }
        byte[] signBytes = hmacSHA1Signature(secretKey, data);
        String encodeToString = Base64.getUrlEncoder().encodeToString(signBytes);
        ;//qiutxkoGeygk8Tl_bjFb-zqWdqM=    url加密 安全的url:转换+为- /为_ 将多余的=去掉
//        String encodeToString = new String(signBytes);//qiutxkoGeygk8Tl_bjFb-zqWdqM=    url加密 安全的url:转换+为- /为_ 将多余的=去掉

        return encodeToString;
    }

    public static byte[] hmacSHA1Signature(String secret, String baseString) throws Exception {
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(CHARSET_UTF8), HMAC_SHA1_ALGORITHM);
        mac.init(keySpec);
        return mac.doFinal(baseString.getBytes(CHARSET_UTF8));
    }

    /**
     * 生成Body 构造待签名的 Data
     *
     * @param params
     * @return
     */
    public static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        StringBuilder prestr = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr.append(key).append("=").append(value);
            } else {
                prestr.append(key).append("=").append(value).append("&");
            }
        }
        return prestr.toString();
    }

    /**
     * @param accessKeySecret 秘钥
     * @param nonce     随机数
     * @param timestamp 时间戳
     * @return 返回待签名的字符串
     */
    public static String getOrignal(String queryString, String body, String nonce, String accessKeySecret, String timestamp, String uri, String method) {
        Map<String, String> param = new HashMap<String, String>();
        try {
            if (StringUtils.isNotBlank(body)) {
                param.put("body", body);
            }
            param.put("queryString", queryString);
            param.put("method", method.toUpperCase());
            param.put("nonce", nonce);
            param.put("accessKeySecret", accessKeySecret);
            param.put("timestamp", timestamp);
            param.put("uri", uri);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return createLinkString(param);
    }

    /**
     * @param accessKeySecret 秘钥
     * @param nonce     随机数
     * @param timestamp 时间戳
     * @return 返回待签名的字符串
     */
    public String getOrignal1(String queryString, String body, String nonce, String accessKeySecret, String timestamp, String uri, String method) {
        Map<String, String> param = new HashMap<String, String>();
        try {
            if (StringUtils.isNotBlank(body)) {
                param.put("body", body);
            }
            param.put("queryString", queryString);
            param.put("method", method.toUpperCase());
            param.put("nonce", nonce);
            param.put("accessKeySecret", accessKeySecret);
            param.put("timestamp", timestamp);
            param.put("uri", uri);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return createLinkString(param);
    }


}
