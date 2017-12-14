package application;

import java.util.ArrayList;

public class Item {
	private Boolean isBreakable;
	private String itemName;
	private double itemSizex;
	private double itemSizey;
	private double itemSizez;
	private double itemMass;
	private Boolean isBroken = false;

	public Item(Boolean breakable, String name, double sizex, double sizey, double sizez, double mass) {
		isBreakable = breakable;
		itemName = name;
		itemSizex = sizex;
		itemSizey = sizey;
		itemSizez = sizez;
		itemMass = mass;

	}

	public Boolean getBreakable() {
		return isBreakable;
	}

	public String getName() {
		return itemName;
	}

	public void breakItem() {
		isBroken = true;
	}

	public ArrayList<Double> getSize() {
		ArrayList<Double> SizeArray = new ArrayList<Double>();
		SizeArray.add(itemSizex);
		SizeArray.add(itemSizey);
		SizeArray.add(itemSizez);
		return SizeArray;
	}

	public double getVolume() {
		double volume = itemSizex * itemSizey * itemSizez;
		return volume;
	}

	public double getMass() {
		return itemMass;
	}
}
