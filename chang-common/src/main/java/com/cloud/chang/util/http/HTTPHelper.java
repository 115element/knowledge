package com.cloud.chang.util.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTTPHelper {

	private static Logger log = LoggerFactory.getLogger(HTTPHelper.class);

	private static int CONN_TIMEOUT = 15 * 1000;
	private static int SO_TIMEOUT = 30 * 1000;

	private CookieManager cookieManager = new CookieManager();

	public void clearCookie() {
		cookieManager.clear();
	}

	public String getCookie(String url) {
		return cookieManager.getStoredCookies(url);
	}

	public String httpGet(String url, Map<String, String> headerParams, String[] proxyParams) {

		try {
			Map<String, String> resultMap = httpGetWithResponseMap(url, headerParams, proxyParams, true);
			if (!resultMap.containsKey("status")) {
				return null;
			}
			String status = resultMap.get("status");
			if (Integer.valueOf(status) < 400) {
				return resultMap.get("html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String httpPost(String url, String params, Map<String, String> headerParams, String[] proxyParams) {

		try {
			Map<String, String> resultMap = httpPostWithResponseMap(url, params, headerParams, proxyParams, true);
			if (!resultMap.containsKey("status")) {
				return null;
			}
			String status = resultMap.get("status");
			if (Integer.valueOf(status) < 400) {
				return resultMap.get("html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@SuppressWarnings("deprecation")
	public Map<String, String> httpGetWithResponseMap(String url, Map<String, String> headerParams,
			String[] proxyParams, boolean... extraParams) {
		log.debug("Get Thread=" + Thread.currentThread().getName() + ", url=" + url);
		Map<String, String> resultMap = new HashMap<String, String>();
		boolean ssl = false;
		if (url.toLowerCase().startsWith("https")) {
			ssl = true;
		}
		DefaultHttpClient client = null;
		if (extraParams != null && extraParams.length > 0) {
			client = getHttpClient(extraParams[0], ssl, proxyParams);
		} else {
			client = getHttpClient(false, ssl, proxyParams);
		}

		HttpGet httpGet = new HttpGet(url);
		// 添加Accept-Encoding
		if (headerParams == null || !headerParams.containsKey("Accept-Encoding")) {
			httpGet.addHeader("Accept-Encoding", "gzip");
		}
		// 添加cookie
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
			client.getConnectionManager().closeExpiredConnections();
			client.getConnectionManager().shutdown();
		}
		return resultMap;
	}

	@SuppressWarnings("deprecation")
	public Map<String, String> httpPostWithResponseMap(String url, String params, Map<String, String> headerParams,
			String[] proxyParams, boolean... extraParams) {
		log.debug("httpPost Thread=" + Thread.currentThread().getName() + ", url=" + url);
		Map<String, String> resultMap = new HashMap<String, String>();

		boolean ssl = false;
		if (url.toLowerCase().startsWith("https")) {
			ssl = true;
		}

		DefaultHttpClient client = null;
		if (extraParams != null && extraParams.length > 0) {
			client = getHttpClient(extraParams[0], ssl, proxyParams);
		} else {
			client = getHttpClient(false, ssl, proxyParams);
		}

		List<BasicNameValuePair> paramPair = null;
		if (!StringUtils.isBlank(params) && params.contains("&")) {
			paramPair = getParamPair(params);
		}

		HttpPost httpPost = new HttpPost(url);
		// 添加Accept-Encoding
		if (headerParams == null || !headerParams.containsKey("Accept-Encoding")) {
			httpPost.addHeader("Accept-Encoding", "gzip");
		}
		// 添加cookie
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
			client.getConnectionManager().closeExpiredConnections();
			client.getConnectionManager().shutdown();
		}
		return resultMap;
	}

	// ----------------------------------------------------------
	@SuppressWarnings("deprecation")
	private static DefaultHttpClient getHttpClient(boolean followRedirects, boolean ssl, String... proxy) {
		HttpParams params = new BasicHttpParams();
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
		HttpConnectionParams.setConnectionTimeout(params, CONN_TIMEOUT);
		HttpConnectionParams.setSoTimeout(params, SO_TIMEOUT);
		HttpClientParams.setRedirecting(params, followRedirects);

		DefaultHttpClient client = new DefaultHttpClient(params);

		Scheme http = new Scheme("http", 80, PlainSocketFactory.getSocketFactory());
		Scheme https = new Scheme("https", 443, buildSSLSocketFactory());
		SchemeRegistry sr = client.getConnectionManager().getSchemeRegistry();
		sr.register(http);
		sr.register(https);

		if (proxy != null && proxy.length == 2) {
			HttpHost httpHost = new HttpHost(proxy[0], Integer.valueOf(proxy[1]), HttpHost.DEFAULT_SCHEME_NAME);
			client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, httpHost);
		} else {
			client.getParams().removeParameter(ConnRoutePNames.DEFAULT_PROXY);
			client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, null);
		}
		return client;
	}

	private static List<BasicNameValuePair> getParamPair(String params) {
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

	@SuppressWarnings("deprecation")
	private static SSLSocketFactory buildSSLSocketFactory() {
		TrustStrategy ts = new TrustStrategy() {
			@Override
			public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
				return true;
			}
		};
		SSLSocketFactory sf = null;
		try {
			sf = new SSLSocketFactory(ts, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		} catch (Exception e) {
		}
		return sf;
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
