package com.cloud.chang.ws;

public class SoapReq<H, B> {

	public int version = 11;// default soap 1.1 protocol
	public H header;
	public B body;

	@Override
	public String toString() {
		return "SoapReq [version=" + version + ", header=" + header + ", body=" + body + "]";
	}

}
