package com.cloud.chang.util.http;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import okhttp3.Headers;

public class NeoCookieManager extends CookieManager {

	public NeoCookieManager() {
		super();
	}

	public void clear() {
		super.clear();
	}

	public void storeCookies(String _url, Headers headers) {

		URL url = null;
		try {
			url = new URL(_url);
		} catch (MalformedURLException e) {
		}
		if (url == null) {
			return;
		}
		String domain = url.getHost();
		Map<String, List<String>> headerMap = headers.toMultimap();

		headerMap.forEach((k, v) -> {
			putCookie(domain, k, v.get(0));
		});

	}

}
