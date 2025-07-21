package com.selenium.setup;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtils {      //Do not change the class name
    
    static String[] xmlData;
    
	public static String[] readFile(String fileName) throws Exception { // Do not change the method signature
	
		//Using the file name passed to this method, parse the XML file, read the XML data and store it in a string array.
		//Store XML values in the string array. 
		//xmlData[0]  is 'NickName' read from xml file
		//xmlData[1]  is 'ContactName' read from xml file  
		//xmlData[2]  is 'Company' read from xml file
		//xmlData[3]  is 'City' read from xml file
		//xmlData[4]  is 'Country' read from xml file
		//xmlData[5]  is 'Type' read from xml file  		
		//Return the array.   
		Document doc;
		xmlData = new String[6];
		XMLUtils obj = new XMLUtils();
		try {
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			if (doc.hasChildNodes()) {
				xmlData = obj.printNodeList(doc.getChildNodes());
			}
		} catch (Exception e) {
		}
		return xmlData;

	}
	public String[] printNodeList(NodeList nodeList) {
		int col = 0;
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node elemNode = nodeList.item(count);
			if (elemNode.getNodeType() == Node.ELEMENT_NODE) {
				xmlData[col] = elemNode.getTextContent();
				col++;
				if (elemNode.hasChildNodes()) {
					printNodeList(elemNode.getChildNodes());
				}
			}
		}
		return xmlData;
	}

	
}
	
