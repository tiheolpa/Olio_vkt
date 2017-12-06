package application;

import java.util.ArrayList;

public class Package {
	private int priority;
	private String senderCity;
	private String destination;
	private double maxDistance;
	private ArrayList<Item> content = new ArrayList<Item>();

	public Package(Item cont, int pr, String senderCit, String dest) {
		priority = pr;
		content.add(cont);
		senderCity = senderCit;
		destination = dest;
		priority = pr;
		if(pr == 1) {
			maxDistance = 150;
		}
	}

	public void addItem(Item it) {
		content.add(it);
	}

}
