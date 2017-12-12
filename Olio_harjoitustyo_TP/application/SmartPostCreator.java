package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
	private HashMap<String, String> map;

	public SmartPostCreator(String filename) {

		try {
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
		NodeList nodes = doc.getElementsByTagName("place");
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			Element e = (Element) node;
			/* map.put("code", getValue("code", e));
			map.put("city", getValue("city", e));
			map.put("adress", getValue("adress", e));
			map.put("avalibility", getValue("avalibility", e));
			map.put("postoffice", getValue("postoffice", e));
			map.put("lat", getValue("lat", e));
			map.put("lng", getValue("lng", e)); */

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

	private String getValue(String tag, Element e) {
		return ((Element)e.getElementsByTagName(tag).item(0)).getTextContent();
	}
}