package com.cloud.chang.ws;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAPEnvelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class SoapBase {
	private static final Logger log = LoggerFactory.getLogger(SoapBase.class);
	private static final ConcurrentHashMap<String, XStream> builderXStreamMap = new ConcurrentHashMap<>();
	private static final ConcurrentHashMap<String, XStream> parserXStreamMap = new ConcurrentHashMap<>();

	// -------------------------------------------------------
	@SuppressWarnings("unchecked")
	protected <T> T xml2Object(String xml, Class<T> clazz) {
		String className = clazz.getName();
		XStream xstream = null;
		if (builderXStreamMap.containsKey(className)) {
			xstream = builderXStreamMap.get(className);
		} else {
			XmlFriendlyNameCoder nameCoder = new XmlFriendlyNameCoder("_-", "_");
			StaxDriver drv = new StaxDriver(nameCoder);
			xstream = new XStream(drv) {
				@Override
				protected MapperWrapper wrapMapper(MapperWrapper next) {
					return new MapperWrapper(next) {
						@SuppressWarnings("rawtypes")
						@Override
						public boolean shouldSerializeMember(Class definedIn, String fieldName) {
							if (definedIn == Object.class) {
								try {
									return this.realClass(fieldName) != null;
								} catch (Exception e) {
									log.error(e.toString(), e);
									return false;
								}
							} else {
								return super.shouldSerializeMember(definedIn, fieldName);
							}
						}
					};
				}
			};
			xstream.processAnnotations(clazz);
			xstream.ignoreUnknownElements();
			builderXStreamMap.put(className, xstream);
		}
		return (T) xstream.fromXML(xml);
	}

	public String object2Xml(Object obj) {
		Class<?> clazz = obj.getClass();
		String className = clazz.getName();
		XStream xstream = null;
		if (parserXStreamMap.containsKey(className)) {
			xstream = parserXStreamMap.get(className);
		} else {
			QNameMap qmap = new QNameMap();
			XStreamQNames xstreamQNames = clazz.getAnnotation(XStreamQNames.class);
			if (xstreamQNames != null) {
				String defaultNamespace = xstreamQNames.defaultNamespace();
				if (!"".equals(defaultNamespace)) {
					qmap.setDefaultNamespace(defaultNamespace);
				}
				XStreamQName[] qnames = xstreamQNames.qnames();
				for (XStreamQName xStreamQName : qnames) {
					String namespaceURI = xStreamQName.namespaceURI();
					String localPart = xStreamQName.localPart();
					String prefix = xStreamQName.prefix();
					String classQName = xStreamQName.className();
					QName qname = new QName(namespaceURI, localPart, prefix);
					if ("".equals(classQName)) {
						qmap.registerMapping(qname, clazz);
					} else {
						qmap.registerMapping(qname, classQName);
					}
				}
			}

			XmlFriendlyNameCoder nameCoder = new XmlFriendlyNameCoder("_-", "_");
			StaxDriver drv = new StaxDriver(qmap, nameCoder);
			xstream = new XStream(drv);
			xstream.processAnnotations(clazz);
			parserXStreamMap.put(className, xstream);
		}
		return xstream.toXML(obj);
	}

	@SuppressWarnings("unchecked")
	protected int getSoapVersion(SOAPEnvelope senv) {
		Iterator<OMNamespace> namespaces = senv.getAllDeclaredNamespaces();
		for (Iterator<OMNamespace> iterator = namespaces; iterator.hasNext();) {
			OMNamespace omNamespace = iterator.next();
			if (omNamespace.getNamespaceURI().equalsIgnoreCase(SoapConstants.SOAP_11_NS)) {
				return SoapConstants.SOAP_VERSION_11_CODE;
			}
			if (omNamespace.getNamespaceURI().equalsIgnoreCase(SoapConstants.SOAP_12_NS)) {
				return SoapConstants.SOAP_VERSION_12_CODE;
			}
		}
		return -1;
	}

}
