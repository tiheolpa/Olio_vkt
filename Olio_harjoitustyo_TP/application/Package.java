package application;

import java.util.ArrayList;

public abstract class Package { //the parent class of packages
	protected boolean isInDestination = false;
	protected SmartPost currentPost;
	protected int priority; //Priority = class selected when creating package
	protected SmartPost senderPost;
	protected SmartPost destination;
	protected double sendLat;
	protected double sendLon;
	protected double endLat;
	protected double endLon;
	protected boolean breaksItems;
	protected double maxDistance;
	protected double maxSize;
	protected ArrayList<Item> content = new ArrayList<Item>();

	public void addItem(Item it) {
		content.add(it);
	}

	public ArrayList<Item> getContent() {
		return content;
	}

	public int breakContents() { //Breaks the contents of the package. Returns integer to state how many items were broken.
		int itemsBroken = 0;
		for(int c = 0; c < content.size(); c++) {
			content.get(c).breakItem();
			if(content.get(c).isBroken == true) {
				itemsBroken++;
			}
		}
		return itemsBroken;
	}
}
