package application;

import java.util.ArrayList;

public final class Storage { //Storage singleton class
    private static final Storage INSTANCE = new Storage();

    private Storage() {}

    private ArrayList<Package> packs = new ArrayList<Package>();

    public static Storage getInstance() {
        return INSTANCE;
    }

	public void addPackage(Package box) {
		packs.add(box);
	}

	public ArrayList<Package> GetPackages() {
		return packs;
	}

	public Package GetPackage(int id) {
		return packs.get(id);
	}
}