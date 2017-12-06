package application;

public class Item {
	private Boolean isBreakable;
	private String itemName;
	private double itemSizex;
	private double itemSizey;
	private double itemSizez;
	private double itemMass;
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

	public double[] getSize() {
		double[] SizeArray = new double[3];
		SizeArray[0] = itemSizex;
		SizeArray[1] = itemSizey;
		SizeArray[2] = itemSizez;
		return SizeArray;
	}

	public double getMass() {
		return itemMass;
	}
}
