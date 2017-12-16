package application;

import java.util.ArrayList;

public class Item { //Item class
	private Boolean isBreakable;
	private String itemName;
	private double itemSizex; //sizes are in centimeters
	private double itemSizey;
	private double itemSizez;
	private double itemMass;
	public Boolean isBroken = false;

	public Item(Boolean breakable, String name, double sizex, double sizey, double sizez, double mass) { //sizes in centimeters
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

	public boolean breakItem() { //this method breaks the item, if it is breakable.
		if (isBreakable == true) {
			isBroken = true;
			return true;
		}
		else {
			return false;
		}
	}

	public ArrayList<Double> getSize() { //returns the items dimensions in centimeters
		ArrayList<Double> SizeArray = new ArrayList<Double>();
		SizeArray.add(itemSizex);
		SizeArray.add(itemSizey);
		SizeArray.add(itemSizez);
		return SizeArray;
	}

	public double getVolume() { //returns volume in cubic centimeters
		double volume = (itemSizex * itemSizey * itemSizez);
		return volume;
	}

	public double getMass() {
		return itemMass;
	}
}
