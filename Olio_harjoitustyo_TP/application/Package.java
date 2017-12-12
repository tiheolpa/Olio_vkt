package application;

import java.util.ArrayList;

public abstract class Package {
	protected int priority;
	protected String senderCity;
	protected String destination;
	protected double maxDistance;
	protected double sendLat;
	protected double sendLon;
	protected double endLat;
	protected double endLon;
	protected boolean breaksItems;
	protected double maxSize;
	protected ArrayList<Item> content = new ArrayList<Item>();

	/*public Package(Item cont, String senderCit, String dest, double slat, double slon, double elat, double elon) {
		content.add(cont);
		senderCity = senderCit;
		destination = dest;
		sendLat = slat;
		sendLon = slon;
		endLat = elat;
		endLon = elon;

		/*if(pr == 1) {
			maxDistance = 150;
		}
	}*/

	public void addItem(Item it) {
		content.add(it);
	}

	public ArrayList<Item> getContent() {
		return content;
	}

}
