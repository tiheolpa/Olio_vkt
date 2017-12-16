package application;
//This class creates smartposts from an xml file

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SmartPostCreator {
	ArrayList<SmartPost> SmartPostList = new ArrayList<SmartPost>();
	private Document doc;

	public SmartPostCreator(String filename) {

		try { //Open the xml file
			File xmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
		} catch (ParserConfigurationException | SAXException | IOException ex) {
			Logger.getLogger(SmartPostCreator.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public ArrayList<SmartPost> createObjects() {
		NodeList nodes = doc.getElementsByTagName("place"); //Get nodes with "place" tag
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			Element e = (Element) node;

			int ID = Integer.parseInt(getValue("code", e));
			String city = getValue("city", e);
			String address = getValue("address", e);
			String aval = getValue("availability", e);
			String po = getValue("postoffice", e);
			double lat = Double.parseDouble(getValue("lat", e));
			double lon = Double.parseDouble(getValue("lng", e));

			SmartPostList.add(new SmartPost(ID, city, address, aval, po, lat, lon));
		}
		return SmartPostList;
	}

	private String getValue(String tag, Element e) { //Gets the value of a node
		return ((Element)e.getElementsByTagName(tag).item(0)).getTextContent();
	}
}