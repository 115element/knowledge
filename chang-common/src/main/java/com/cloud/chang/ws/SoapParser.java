package com.cloud.chang.ws;

import java.io.StringReader;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFault;
import org.apache.axiom.soap.SOAPHeader;
import org.apache.axiom.soap.SOAPModelBuilder;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoapParser extends SoapBase {

	private static final Logger log = LoggerFactory.getLogger(SoapParser.class);

	public <H, B> SoapReq<H, B> parseSoapReq(String soap, Class<H> headerClazz, Class<B> bodyClazz) {
		try {
			XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance()
					.createXMLStreamReader(new StringReader(soap));
			SOAPModelBuilder smb = OMXMLBuilderFactory.createStAXSOAPModelBuilder(xmlStreamReader);
			SOAPEnvelope senv = smb.getSOAPEnvelope();
			SOAPHeader soapHeader = senv.getHeader();
			H header = null;
			if (soapHeader != null) {
				OMElement headerOMElement = soapHeader.getFirstElement();
				String headerXml = headerOMElement.toStringWithConsume();
				header = xml2Object(headerXml, headerClazz);
			}
			SOAPBody soapBody = senv.getBody();
			B body = null;
			if (soapBody != null) {
				OMElement bodyOMElement = soapBody.getFirstElement();
				String bodyXml = bodyOMElement.toStringWithConsume();
				body = xml2Object(bodyXml, bodyClazz);
			}
			SoapReq<H, B> entity = new SoapReq<H, B>();
			entity.header = header;
			entity.body = body;
			smb.close();
			xmlStreamReader.close();
			return entity;
		} catch (XMLStreamException | FactoryConfigurationError e) {
			log.error(e.toString(), e);
		}
		return null;
	}

	public <B, F> SoapResp<B, F> parseSoapResp(String soap, Class<B> bodyClazz, Class<F> faultClazz,
			boolean... unescape) {
		try {
			XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance()
					.createXMLStreamReader(new StringReader(soap));
			SOAPModelBuilder smb = OMXMLBuilderFactory.createStAXSOAPModelBuilder(xmlStreamReader);
			SOAPEnvelope senv = smb.getSOAPEnvelope();
			int version = getSoapVersion(senv);
			SoapResp<B, F> soapResp = new SoapResp<B, F>();
			soapResp.version = version;
			if (senv.hasFault()) {
				SOAPFault soapFault = senv.getBody().getFault();
				String faultXml = soapFault.toStringWithConsume();
				F fault = xml2Object(faultXml, faultClazz);
				soapResp.fault = fault;
			} else {
				SOAPBody soapBody = senv.getBody();
				OMElement bodyOMElement = soapBody.getFirstElement();
				String bodyXml = bodyOMElement.toStringWithConsume();
				if (unescape.length > 0 && !unescape[0]) {
					log.info("body xml maybe has inner xml, not unescape");
				} else {
					bodyXml = StringEscapeUtils.unescapeXml(bodyXml);
				}
				log.debug("bodyXml=" + bodyXml);
				B body = xml2Object(bodyXml, bodyClazz);
				soapResp.body = body;
			}
			smb.close();
			xmlStreamReader.close();
			return soapResp;
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		return null;
	}
}
