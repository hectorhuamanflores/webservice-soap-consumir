package com.hector.demo;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class testXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		String file = "<menu_almuerzo><comida><nombre>Waffles 1</nombre><precio>$2.00</precio></comida></menu_almuerzo>";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse(new InputSource(new StringReader(file)));
	    //Document doc = db.parse(file);
	    doc.getDocumentElement().normalize();
	    System.out.println("Root element " + doc.getDocumentElement().getNodeName());

	    NodeList nodeList=doc.getElementsByTagName("*");
	    for (int i=0; i<nodeList.getLength(); i++) 
	    {
	        // Get element
	        Element element = (Element)nodeList.item(i);
	        System.out.println(element.getNodeName());
	    }

	}

}
