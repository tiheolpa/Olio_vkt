package application;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TheatreHandler {
	Document doc;
	ArrayList <Theatre> Theatres = new ArrayList <Theatre>();
	public TheatreHandler() {
		try { //xml:n lukumenetelmä, löydetty osoitteesta https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
			File fXmlFile = new File("TheatreAreas.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
		} catch (Exception e) {

		}

		NodeList nList = doc.getElementsByTagName("staff");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			Element eElement = (Element) nNode;
			int AdderID = Integer.parseInt(eElement.getAttribute("ID"));
			String AdderLocation = eElement.getAttribute("Name");
			AddTheatre(AdderLocation, AdderID);
		}
	}

	public void AddTheatre(String location, int ID) {
		Theatres.add(new Theatre(location, ID));
	}
}