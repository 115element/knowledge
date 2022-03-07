package com.cloud.chang.util.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * update HttpClient to 4.3.5, use new api to fix ssl bug
 * 
 */
public class HTTPClientHelper {

  private static Logger log = LoggerFactory.getLogger(HTTPClientHelper.class);

  private static int CONN_TIMEOUT = 30 * 1000;
  private static int SO_TIMEOUT = 45 * 1000;

  private CookieManager cookieManager = new CookieManager();

  public void clearCookie() {
    cookieManager.clear();
  }

  public String getCookie(String url) {
    return cookieManager.getStoredCookies(url);
  }

  public String httpGet(String url, Map<String, String> headerParams, String[] proxyParams) {

    Map<String, String> resultMap = httpGetWithResponseMap(url, headerParams, proxyParams, true);
    if (!resultMap.containsKey("status")) {
      return null;
    }
    String status = resultMap.get("status");
    if (Integer.valueOf(status) < 400) {
      return resultMap.get("html");
    }
    return "";
  }

  public String httpPost(String url, String params, Map<String, String> headerParams,
      String[] proxyParams) {

    Map<String, String> resultMap =
        httpPostWithResponseMap(url, params, headerParams, proxyParams, true);
    if (!resultMap.containsKey("status")) {
      return null;
    }
    String status = resultMap.get("status");
    if (Integer.valueOf(status) < 400) {
      return resultMap.get("html");
    }
    return "";
  }

  public Map<String, String> httpGetWithResponseMap(String url, Map<String, String> headerParams,
      String[] proxyParams, boolean... allowRedirects) {
    log.debug("Get Thread=" + Thread.currentThread().getName() + ", url=" + url);
    Map<String, String> resultMap = new HashMap<String, String>();
    CloseableHttpClient client = null;
    RequestConfig requestConfig = null;
    if (allowRedirects != null && allowRedirects.length > 0) {
      client = getHttpClient();
      requestConfig = buildRequestConfig(allowRedirects[0], proxyParams);
    } else {
      client = getHttpClient();
      requestConfig = buildRequestConfig(false, proxyParams);
    }
    HttpGet httpGet = new HttpGet(url);
    httpGet.setConfig(requestConfig);
    if (headerParams == null || !headerParams.containsKey("Accept-Encoding")) {
      httpGet.addHeader("Accept-Encoding", "gzip");
    }
    if (headerParams == null || !headerParams.containsKey("Cookie")) {
      String cookie = cookieManager.getStoredCookies(url);
      if (!StringUtils.isBlank(cookie)) {
        httpGet.addHeader("Cookie", cookie);
      }
    }

    if (headerParams != null) {
      Set<String> keys = headerParams.keySet();
      for (String key : keys) {
        httpGet.addHeader(key, headerParams.get(key));
      }
    }

    try {
      HttpResponse response = client.execute(httpGet);
      int statusCode = response.getStatusLine().getStatusCode();
      resultMap.put("status", statusCode + "");
      Header[] headers = response.getAllHeaders();
      cookieManager.storeCookies(url, headers);
      for (Header header : headers) {
        if (!"Set-Cookie".equals(header.getName())) {
          resultMap.put(header.getName(), header.getValue());
        }
      }

      HttpEntity httpEntity = response.getEntity();
      String contentEncoding = getContentEncoding(httpEntity);
      if (contentEncoding.indexOf("gzip") > -1) {
        response.setEntity(new GzipEntity(httpEntity));
      }
      String html = EntityUtils.toString(response.getEntity());
      log.debug("Get Thread=" + Thread.currentThread().getName() + ", html=" + html);
      resultMap.put("html", html);

    } catch (Exception e) {
      log.error("error occured", e);
    } finally {
      try {
        client.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return resultMap;
  }

  public Map<String, String> httpPostWithResponseMap(String url, String params,
      Map<String, String> headerParams, String[] proxyParams, boolean... allowRedirects) {
    log.debug("httpPost Thread=" + Thread.currentThread().getName() + ", url=" + url);
    Map<String, String> resultMap = new HashMap<String, String>();

    CloseableHttpClient client = null;
    RequestConfig requestConfig = null;
    if (allowRedirects != null && allowRedirects.length > 0) {
      client = getHttpClient();
      requestConfig = buildRequestConfig(allowRedirects[0], proxyParams);
    } else {
      client = getHttpClient();
      requestConfig = buildRequestConfig(false, proxyParams);
    }
    List<BasicNameValuePair> paramPair = getParamPair(params);
    HttpPost httpPost = new HttpPost(url);
    httpPost.setConfig(requestConfig);
    if (headerParams == null || !headerParams.containsKey("Accept-Encoding")) {
      httpPost.addHeader("Accept-Encoding", "gzip");
    }
    if (headerParams == null || !headerParams.containsKey("Cookie")) {
      String cookie = cookieManager.getStoredCookies(url);
      if (!StringUtils.isBlank(cookie)) {
        httpPost.addHeader("Cookie", cookie);
      }
    }

    if (headerParams != null) {
      Set<String> keys = headerParams.keySet();
      for (String key : keys) {
        httpPost.addHeader(key, headerParams.get(key));
      }
    }

    try {
      HttpEntity entity = null;
      if (paramPair != null) {
        entity = new UrlEncodedFormEntity(paramPair, "UTF-8");
      } else {
        entity = new ByteArrayEntity(params.getBytes());
      }
      httpPost.setEntity(entity);
      HttpResponse response = client.execute(httpPost);
      int statusCode = response.getStatusLine().getStatusCode();
      resultMap.put("status", statusCode + "");
      Header[] headers = response.getAllHeaders();
      cookieManager.storeCookies(url, headers);
      for (Header header : headers) {
        if (!"Set-Cookie".equals(header.getName())) {
          resultMap.put(header.getName(), header.getValue());
        }
      }

      HttpEntity httpEntity = response.getEntity();
      String contentEncoding = getContentEncoding(httpEntity);
      if (contentEncoding.indexOf("gzip") > -1) {
        response.setEntity(new GzipEntity(httpEntity));
      }
      String html = EntityUtils.toString(response.getEntity());
      log.debug("Post Thread=" + Thread.currentThread().getName() + ", html=" + html);
      resultMap.put("html", html);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        client.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return resultMap;
  }

  // ----------------------------------------------------------
  private CloseableHttpClient getHttpClient() {
    SSLConnectionSocketFactory socketFactory = buildSSLSocketFactory();
    CloseableHttpClient client =
        HttpClientBuilder.create().setSSLSocketFactory(socketFactory).build();
    return client;
  }

  private SSLConnectionSocketFactory buildSSLSocketFactory() {
    try {
      SSLContext sslContext = SSLContext.getInstance("SSL");
      sslContext.init(null, new TrustManager[] {new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() {
          return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {}

        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
      }}, new SecureRandom());
      SSLConnectionSocketFactory socketFactory =
          new SSLConnectionSocketFactory(sslContext,
              SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      return socketFactory;
    } catch (Exception e) {
    }
    return null;
  }

  private RequestConfig buildRequestConfig(boolean followRedirects, String... proxy) {

    RequestConfig.Builder builder = RequestConfig.custom();
    builder.setRedirectsEnabled(followRedirects);
    if (proxy != null && proxy.length == 2) {
      HttpHost httpHost =
          new HttpHost(proxy[0], Integer.valueOf(proxy[1]), HttpHost.DEFAULT_SCHEME_NAME);
      builder.setProxy(httpHost);
    }
    builder.setConnectTimeout(CONN_TIMEOUT).setSocketTimeout(SO_TIMEOUT);
    return builder.build();
  }

  private List<BasicNameValuePair> getParamPair(String params) {
    List<BasicNameValuePair> paramPair = new ArrayList<BasicNameValuePair>();
    String[] elments = params.split("&");
    for (String param : elments) {
      String[] str = param.split("=");
      if (str.length == 2) {
        try {
          paramPair.add(new BasicNameValuePair(str[0], URLDecoder.decode(str[1], "UTF-8")));
        } catch (UnsupportedEncodingException e) {
        }
      }
    }
    return paramPair;
  }

  private String getContentEncoding(HttpEntity entity) {
    String contentEncoding = "";
    Header header = entity.getContentEncoding();
    if (header != null) {
      HeaderElement values[] = header.getElements();
      if (values.length > 0) {
        contentEncoding = values[0].getName();
      }
    }
    return contentEncoding;
  }

  static class GzipEntity extends HttpEntityWrapper {
    private HttpEntity wrappedEntity;

    public GzipEntity(HttpEntity wrapped) {
      super(wrapped);
      this.wrappedEntity = wrapped;
    }

    @Override
    public InputStream getContent() throws IOException {
      return new GZIPInputStream(wrappedEntity.getContent());
    }
  }
}
