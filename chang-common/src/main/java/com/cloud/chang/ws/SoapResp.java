package com.cloud.chang.ws;

public class SoapResp<B, F> {

	public int version = 11;// default soap 1.1 protocol
	public B body;
	public F fault;

	@Override
	public String toString() {
		return "SoapResp [body=" + body + ", fault=" + fault + "]";
	}

}
