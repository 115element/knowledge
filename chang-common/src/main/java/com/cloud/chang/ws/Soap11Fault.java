package com.cloud.chang.ws;

/**
 * soap 1.1
 * 
 * @author bingyunxl
 *
 */
public class Soap11Fault {

	public String faultcode;
	public String faultstring;

	@Override
	public String toString() {
		return "SoapFault [faultcode=" + faultcode + ", faultstring=" + faultstring + "]";
	}
}
