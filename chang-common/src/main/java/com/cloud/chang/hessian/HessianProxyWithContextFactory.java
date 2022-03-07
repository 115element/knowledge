package com.cloud.chang.hessian;

import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

//import com.caucho.hessian.client.HessianProxyFactory;
//import com.caucho.hessian.io.HessianRemoteObject;

//public class HessianProxyWithContextFactory extends HessianProxyFactory implements HeaderContext {
//
//	private Map<String, String> headers = new HashMap<>();
//
//	public void setHeaders(Map<String, String> headers) {
//		this.headers = headers;
//	}
//
//	@Override
//	public Object create(Class api, String urlName) throws MalformedURLException {
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//		URL url = new URL(urlName);
//		HessianProxyWithContext handler = new HessianProxyWithContext(url, this, api);
//		return Proxy.newProxyInstance(loader, new Class[] { api, HessianRemoteObject.class }, handler);
//	}
//
//	@Override
//	public Map<String, String> getHeaders() {
//		return headers;
//	}
//}
