package application;

import java.util.ArrayList;

public class Storage {
	private ArrayList<Package> packs = new ArrayList<Package>();
	public Storage(String args[]) {

	}
	public void addPackage(Package box) {
		packs.add(box);
	}
}