package application;

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

import javafx.collections.ObservableList;

public class TheatreHandler {

	Document doc;
	ArrayList <Theatre> Theatres = new ArrayList <Theatre>();
	public TheatreHandler() {
		try {
			try {
				File xmlFile = new File("TheatreAreas.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				doc = dBuilder.parse(xmlFile);
				doc.getDocumentElement().normalize();
			} catch (ParserConfigurationException | SAXException | IOException ex) {
				Logger.getLogger(TheatreHandler.class.getName()).log(Level.SEVERE, null, ex);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Theatres.addAll(this.createObjects());
	}

	public void AddTheatre(String location, int ID) {
		Theatres.add(new Theatre(location, ID));
	}

	@SuppressWarnings("unchecked")
	public ObservableList<Theatre> GetTheatres() {
		return (ObservableList<Theatre>) Theatres;
	}


	public ArrayList<Theatre> createObjects() {
		ArrayList<Theatre> temp = new ArrayList<Theatre>();
		NodeList nodes = doc.getElementsByTagName("TheatreArea");
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			Element e = (Element) node;

			int ID = Integer.parseInt(getValue("ID", e));
			String location = getValue("Name", e);

			temp.add(new Theatre(location, ID));
		}
		return temp;

	}

	private String getValue(String tag, Element e) {
		return ((Element)e.getElementsByTagName(tag).item(0)).getTextContent();
	}
}