package application;

import java.util.ArrayList;

public class Package {
	public int priority;
	public String senderCity;
	public String destination;
	public double maxDistance;
	public double sendLat;
	public double sendLon;
	public double endLat;
	public double endLon;
	private ArrayList<Item> content = new ArrayList<Item>();

	public Package(Item cont, int pr, String senderCit, String dest, double slat, double slon, double elat, double elon) {
		priority = pr;
		content.add(cont);
		senderCity = senderCit;
		destination = dest;
		priority = pr;
		sendLat = slat;
		sendLon = slon;
		endLat = elat;
		endLon = elon;

		if(pr == 1) {
			maxDistance = 150;
		}
	}

	public void addItem(Item it) {
		content.add(it);
	}

	public ArrayList<Item> getContent() {
		return content;
	}

}
