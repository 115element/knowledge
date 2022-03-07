package com.cloud.chang.util.sql;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SQLParser {

	private static String ROOT_NODE = "//all-sql/*";

	public HashMap<String, String> getSQLs() {

		HashMap<String, String> sqlContainer = new HashMap<String, String>();
		try {
			load("sql.xml", sqlContainer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlContainer;
	}

	private HashMap<String, String> load(String fileName, HashMap<String, String> sqlContainer) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(inputStream);

		XPathFactory xFactory = XPathFactory.newInstance();
		XPath xpath = xFactory.newXPath();
		XPathExpression expr = xpath.compile(ROOT_NODE);
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if ("sql".equals(node.getNodeName())) {
				String sqlName = node.getAttributes().getNamedItem("name").getNodeValue();
				String sql = node.getTextContent().trim();
				sqlContainer.put(sqlName, sql);
			} else if ("include".equals(nodes.item(i).getNodeName())) {
				String chiledFileName = node.getAttributes().getNamedItem("src").getNodeValue();
				load(chiledFileName, sqlContainer);
			}
		}
		return sqlContainer;
	}
}
