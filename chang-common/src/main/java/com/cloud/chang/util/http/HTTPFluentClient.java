package com.cloud.chang.util.http;

import java.io.IOException;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class HTTPFluentClient {

	private static int connTimeout = 10000;
	private static int soTimeout = 10000;

	public static String get(String url) {
		try {
			return Request.Get(url).connectTimeout(connTimeout).socketTimeout(soTimeout).execute().returnContent()
					.asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String post(String url, String params) {
		try {
			return Request.Post(url).bodyString(params, ContentType.APPLICATION_FORM_URLENCODED)
					.connectTimeout(connTimeout).socketTimeout(soTimeout).execute().returnContent().asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
