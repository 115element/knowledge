package com.cloud.chang.ws;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * soap 1.2
 * 
 * @author bingyunxl
 *
 */
@XStreamAlias("Fault")
public class Soap12Fault {

	public String Code;
	public String Reason;

	@Override
	public String toString() {
		return "Soap12Fault [Code=" + Code + ", Reason=" + Reason + "]";
	}

}
