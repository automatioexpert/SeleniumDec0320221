/**
 * 
 */
package com.xls.report.utility;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author - rahul.rathore
 * @date - 21-May-2015
 * @project - ExcelReportGenerator
 * @package - com.java.utility
 * @file name - DocumentBuilder.java
 */
public class DocBuilder {
	private static DocumentBuilderFactory fact;
	private static DocumentBuilder build;
	
	public static Document getDocument(String xmlFile) throws SAXException, IOException, ParserConfigurationException {
		fact = DocumentBuilderFactory.newInstance();
		build = fact.newDocumentBuilder();
		return build.parse(xmlFile);
	}
}
