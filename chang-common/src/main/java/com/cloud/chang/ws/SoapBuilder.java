package com.cloud.chang.ws;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axiom.soap.SOAPHeader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoapBuilder extends SoapBase {
    private static final Logger log = LoggerFactory.getLogger(SoapBuilder.class);

    public <H, B> String buildSoapReq(SoapReq<H, B> entity) {
        SOAPFactory fac = null;
        if (entity.version == SoapConstants.SOAP_VERSION_11_CODE) {
            fac = OMAbstractFactory.getSOAP11Factory();
        } else {
            fac = OMAbstractFactory.getSOAP12Factory();
        }
        SOAPEnvelope env = fac.createSOAPEnvelope();
        env.declareNamespace("http://www.w3.org/2001/XMLSchema", "xsd");
        env.declareNamespace("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        if (entity.header != null) {
            SOAPHeader soapHeader = fac.createSOAPHeader(env);
            String headerXml = object2Xml(entity.header);
            try {
                OMElement omElement = AXIOMUtil.stringToOM(headerXml);
                soapHeader.addChild(omElement);
            } catch (XMLStreamException e) {
                log.error(e.toString(), e);
            }
        }
        SOAPBody soapBody = fac.createSOAPBody(env);
        String bodyXml = object2Xml(entity.body);
        try {
            OMElement omElement = AXIOMUtil.stringToOM(bodyXml);
            soapBody.addChild(omElement);
        } catch (XMLStreamException e) {
            log.error(e.toString(), e);
        }
        try {
            return env.toStringWithConsume();
        } catch (XMLStreamException e) {
            log.error(e.toString(), e);
        }
        return "";
    }

    public String buildSoapReq(String headerXml, String bodyXml, int version) {
        SOAPFactory fac = null;
        if (version == SoapConstants.SOAP_VERSION_11_CODE) {
            fac = OMAbstractFactory.getSOAP11Factory();
        } else {
            fac = OMAbstractFactory.getSOAP12Factory();
        }
        SOAPEnvelope env = fac.createSOAPEnvelope();
        env.declareNamespace("http://www.w3.org/2001/XMLSchema", "xsd");
        env.declareNamespace("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        if (!StringUtils.isBlank(headerXml)) {
            SOAPHeader soapHeader = fac.createSOAPHeader(env);
            try {
                OMElement omElement = AXIOMUtil.stringToOM(headerXml);
                soapHeader.addChild(omElement);
            } catch (XMLStreamException e) {
                log.error(e.toString(), e);
            }
        }
        SOAPBody soapBody = fac.createSOAPBody(env);
        try {
            OMElement omElement = AXIOMUtil.stringToOM(bodyXml);
            soapBody.addChild(omElement);
        } catch (XMLStreamException e) {
            log.error(e.toString(), e);
        }
        try {
            return env.toStringWithConsume();
        } catch (XMLStreamException e) {
            log.error(e.toString(), e);
        }
        return "";
    }

    public String buildSoapReq(String bodyXml, int version, String username, String password) {
        SOAPFactory fac = null;
        if (version == SoapConstants.SOAP_VERSION_11_CODE) {
            fac = OMAbstractFactory.getSOAP11Factory();
        } else {
            fac = OMAbstractFactory.getSOAP12Factory();
        }
        SOAPEnvelope env = fac.createSOAPEnvelope();
        env.declareNamespace("http://www.w3.org/2001/XMLSchema", "xsd");
        env.declareNamespace("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        SOAPHeader soapHeader = fac.createSOAPHeader(env);
        addSecurityToHeader(soapHeader, username, password);
        SOAPBody soapBody = fac.createSOAPBody(env);
        try {
            OMElement omElement = AXIOMUtil.stringToOM(bodyXml);
            soapBody.addChild(omElement);
        } catch (XMLStreamException e) {
            log.error(e.toString(), e);
        }
        try {
            return env.toStringWithConsume();
        } catch (XMLStreamException e) {
            log.error(e.toString(), e);
        }
        return "";
    }

    public <B, F> String buildSoapResp(SoapResp<B, F> entity) {
        SOAPFactory fac = null;
        if (entity.version == SoapConstants.SOAP_VERSION_11_CODE) {
            fac = OMAbstractFactory.getSOAP11Factory();
        } else {
            fac = OMAbstractFactory.getSOAP12Factory();
        }
        SOAPEnvelope env = fac.createSOAPEnvelope();
        env.declareNamespace("http://www.w3.org/2001/XMLSchema", "xsd");
        env.declareNamespace("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        SOAPBody soapBody = fac.createSOAPBody(env);
        String bodyXml = "";
        if (entity.body != null) {
            bodyXml = object2Xml(entity.body);
        } else {
            bodyXml = object2Xml(entity.fault);
        }
        try {
            OMElement omElement = AXIOMUtil.stringToOM(bodyXml);
            soapBody.addChild(omElement);
        } catch (XMLStreamException e) {
            log.error(e.toString(), e);
        }
        try {
            return env.toStringWithConsume();
        } catch (XMLStreamException e) {
            log.error(e.toString(), e);
        }
        return "";
    }

    public static void addSecurityToHeader(SOAPHeader header, String username, String password) {
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace namespaceWSSE = factory.createOMNamespace(
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
                "wsse");
        OMElement element = factory.createOMElement("Security", namespaceWSSE);
        OMAttribute attribute = factory.createOMAttribute("mustUnderstand", null, "1");
        element.addAttribute(attribute);
        header.addChild(element);
        OMElement element2 = factory.createOMElement("UsernameToken", namespaceWSSE);
        OMNamespace namespaceWSU = factory.createOMNamespace(
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd",
                "wsu");
        attribute = factory.createOMAttribute("Id", namespaceWSU, "UsernameToken-1");
        element2.addAttribute(attribute);
        element.addChild(element2);
        OMElement element3 = factory.createOMElement("Username", namespaceWSSE);
        element3.setText(username);
        OMElement element4 = factory.createOMElement("Password", namespaceWSSE);
        attribute = factory.createOMAttribute("Type", null,
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
        element4.setText(password);
        element2.addChild(element3);
        element2.addChild(element4);
    }
}
