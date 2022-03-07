package com.cloud.chang.hessian;

import java.net.URL;
import java.util.Map;

//import com.caucho.hessian.client.HessianConnection;
//import com.caucho.hessian.client.HessianProxy;
//import com.caucho.hessian.client.HessianProxyFactory;

//public class HessianProxyWithContext extends HessianProxy {
//
//	private static final long serialVersionUID = 1L;

//	public HessianProxyWithContext(URL url, HessianProxyFactory factory, Class<?> type) {
//		//super(url, factory, type);
//	}

//	@Override
//	protected void addRequestHeaders(HessianConnection conn) {
//		super.addRequestHeaders(conn);
//		if (_factory instanceof HeaderContext) {
//			Map<String, String> context = ((HeaderContext) _factory).getHeaders();
//			context.forEach((k, v) -> {
//				conn.addHeader(k, v);
//			});
//		}
//	}
//}