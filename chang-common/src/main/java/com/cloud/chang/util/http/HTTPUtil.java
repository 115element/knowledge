package com.cloud.chang.util.http;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.CharArrayBuffer;

public class HTTPUtil {

	public static int CONN_TIMEOUT = 30 * 1000;
	public static int SO_TIMEOUT = 30 * 1000;

	private static CookieManager cookieManager = new CookieManager();

	public static void clearCookie() {
		cookieManager.clear();
	}

	public static String getCookie(String url) {
		return cookieManager.getStoredCookies(url);
	}

	public static String httpGet(String url, Map<String, String> headerParams, String[] proxyParams) {

		Map<String, String> resultMap = httpGetWithResponseMap(url, headerParams, proxyParams, true);
		if (resultMap == null || !resultMap.containsKey("status")) {
			return null;
		}
		String status = resultMap.get("status");
		if (Integer.valueOf(status) < 400) {
			return resultMap.get("html");
		}
		return "";
	}

	public static String httpPost(String url, String params, Map<String, String> headerParams, String[] proxyParams) {

		try {
			Map<String, String> resultMap = httpPostWithResponseMap(url, params, headerParams, proxyParams, true);
			if (resultMap == null || !resultMap.containsKey("status")) {
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

	public static String httpGet(String url, Map<String, String> headerParams) {

		try {
			Map<String, String> resultMap = httpGetWithResponseMap(url, headerParams, null, true);
			if (resultMap == null || !resultMap.containsKey("status")) {
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

	public static String httpPost(String url, String params, Map<String, String> headerParams) {

		Map<String, String> resultMap = httpPostWithResponseMap(url, params, headerParams, null, true);
		if (resultMap == null || !resultMap.containsKey("status")) {
			return null;
		}
		String status = resultMap.get("status");
		if (Integer.valueOf(status) < 400) {
			return resultMap.get("html");
		}
		return "";
	}

	public static Map<String, String> httpGetWithResponseMap(String url, Map<String, String> headerParams,
			String[] proxyParams, boolean... allowRedirects) {

		HttpURLConnection conn = getHttpURLConnection(url, headerParams, proxyParams);
		try {
			if (allowRedirects.length > 0) {
				conn.setInstanceFollowRedirects(allowRedirects[0]);
			} else {
				conn.setInstanceFollowRedirects(false);
			}
			conn.setReadTimeout(SO_TIMEOUT);
			conn.setConnectTimeout(CONN_TIMEOUT);
			conn.setUseCaches(false); // 不允许使用缓存
			conn.setRequestMethod("GET");
			conn.connect();
			Map<String, String> resultMap = parseResponse(conn);
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return null;
	}

	public static Map<String, String> httpPostWithResponseMap(String url, String params,
			Map<String, String> headerParams, String[] proxyParams, boolean... allowRedirects) {
		HttpURLConnection conn = getHttpURLConnection(url, headerParams, proxyParams);
		try {
			if (allowRedirects.length > 0) {
				conn.setInstanceFollowRedirects(allowRedirects[0]);
			} else {
				conn.setInstanceFollowRedirects(false);
			}
			conn.setReadTimeout(SO_TIMEOUT);
			conn.setConnectTimeout(CONN_TIMEOUT);
			conn.setDoInput(true); // 允许输入流
			conn.setDoOutput(true); // 允许输出流
			conn.setUseCaches(false); // 不允许使用缓存
			conn.setRequestMethod("POST"); // 请求方式

			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
			writer.write(params);
			writer.flush();
			writer.close();

			conn.connect();
			Map<String, String> resultMap = parseResponse(conn);
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return null;
	}

	public static boolean downloadFile(String _url, Map<String, String> headerParams, String fileName,
			String... proxyParam) {
		HttpURLConnection conn = getHttpURLConnection(_url, headerParams, proxyParam);
		try {
			conn.setInstanceFollowRedirects(false);

			conn.setReadTimeout(SO_TIMEOUT);
			conn.setConnectTimeout(CONN_TIMEOUT);
			conn.setUseCaches(false); // 不允许使用缓存
			conn.setDoInput(true); // 允许输入流
			conn.setDoOutput(true); // 允许输出流
			conn.setRequestMethod("GET"); // 请求方式
			conn.connect();

			int statusCode = conn.getResponseCode();
			if (statusCode >= HttpURLConnection.HTTP_BAD_REQUEST) {
				return false;
			}

			if (statusCode == 302) {
				String location = conn.getHeaderField("Location");
				System.out.println(location);
			}

			InputStream is = conn.getInputStream();
			FileOutputStream fos = new FileOutputStream(fileName);
			byte buf[] = new byte[1024];
			do {
				int numread = is.read(buf);
				if (numread == -1) {
					break;
				}
				fos.write(buf, 0, numread);
			} while (true);

			fos.flush();
			fos.close();
			is.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.disconnect();
				}
			} catch (Exception e) {
			}
		}
		return false;
	}

	// --------------------------------------------------------
	private static HttpURLConnection getHttpURLConnection(String _url, Map<String, String> headerParams,
			String... proxyParams) {
		HttpURLConnection conn = null;
		try {
			URL url = new URL(_url);
			boolean ssl = false;
			if (_url.toLowerCase().startsWith("https")) {
				ssl = true;
			}

			if (!ssl) {
				if (proxyParams != null && proxyParams.length >= 2) {
					InetSocketAddress sa = new InetSocketAddress(proxyParams[0], Integer.valueOf(proxyParams[1]));
					Proxy proxy = null;
					if (proxyParams.length > 2) {
						proxy = new Proxy(Proxy.Type.valueOf(proxyParams[2]), sa);
					} else {
						proxy = new Proxy(Proxy.Type.HTTP, sa);
					}
					conn = (HttpURLConnection) url.openConnection(proxy);
				} else {
					conn = (HttpURLConnection) url.openConnection();
				}
			} else {
				HttpsURLConnection.setDefaultSSLSocketFactory(getSslSocketFactory());
				HostnameVerifier allHostsValid = new HostnameVerifier() {
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
				};
				HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

				if (proxyParams != null && proxyParams.length >= 2) {
					InetSocketAddress sa = new InetSocketAddress(proxyParams[0], Integer.valueOf(proxyParams[1]));
					Proxy proxy = null;
					if (proxyParams.length > 2) {
						proxy = new Proxy(Proxy.Type.valueOf(proxyParams[2]), sa);
					} else {
						proxy = new Proxy(Proxy.Type.HTTP, sa);
					}
					conn = (HttpsURLConnection) url.openConnection(proxy);
				} else {
					conn = (HttpsURLConnection) url.openConnection();
				}
			}

			if (headerParams != null) {
				Set<String> keys = headerParams.keySet();
				for (String key : keys) {
					conn.setRequestProperty(key, headerParams.get(key));
				}
			}
			conn.setRequestProperty("Accept-Encoding", "gzip");

			String cookies = cookieManager.getStoredCookies(_url);
			if (!StringUtils.isBlank(cookies)) {
				conn.setRequestProperty("Cookie", cookies);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	private static SSLSocketFactory getSslSocketFactory() {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			return sc.getSocketFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Map<String, String> parseResponse(HttpURLConnection conn) {
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			int statusCode = conn.getResponseCode();
			resultMap.put("status", statusCode + "");

			InputStream inputStream = null;
			if (statusCode < HttpURLConnection.HTTP_BAD_REQUEST) {
				inputStream = conn.getInputStream();
			} else {
				inputStream = conn.getErrorStream();
			}
			String charset = getContentType(conn.getContentType());
			int contentLength = conn.getContentLength();
			if (contentLength < 0) {
				contentLength = 4096;
			}
			String contentEncoding = conn.getContentEncoding();

			Map<String, List<String>> headers = conn.getHeaderFields();
			Set<String> headerFieldKeys = headers.keySet();
			for (String key : headerFieldKeys) {
				List<String> headerValues = headers.get(key);
				for (String value : headerValues) {
					if (!"Set-Cookie".equalsIgnoreCase(key)) {
						resultMap.put(key, value);
					}
				}
			}
			cookieManager.storeCookies(conn.getURL(), headers);

			BufferedReader br = null;
			if (!StringUtils.isBlank(contentEncoding) && contentEncoding.indexOf("gzip") > -1) {
				br = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream), charset));
			} else {
				br = new BufferedReader(new InputStreamReader(inputStream, charset));
			}
			CharArrayBuffer buffer = new CharArrayBuffer(contentLength);
			char[] tmp = new char[1024];
			int l;
			while ((l = br.read(tmp)) != -1) {
				buffer.append(tmp, 0, l);
			}
			String html = buffer.toString();
			resultMap.put("html", html);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultMap;
	}

	private static String getContentType(String contentType) {
		try {
			if (!StringUtils.isBlank(contentType)) {
				contentType = contentType.toLowerCase();
				if (contentType.startsWith("text")) {
					String[] element = contentType.split(";");
					if (element.length == 2) {
						String charset = element[1].replace("charset=", "").trim();
						return charset;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UTF-8";
	}
}
