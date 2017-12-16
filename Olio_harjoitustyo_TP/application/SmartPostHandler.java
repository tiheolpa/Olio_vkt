package application;
//Singleton class to handle smartposts

import java.util.ArrayList;

import javafx.scene.web.WebView;

public final class SmartPostHandler {
    private static final SmartPostHandler INSTANCE = new SmartPostHandler();

	public ArrayList<SmartPost> smartPosts = new ArrayList<SmartPost>();

	ArrayList<String> Cities = new ArrayList<String>();

    private SmartPostHandler() {
		SmartPostCreator creator = new SmartPostCreator("smartpostdata.xml"); //Create smartposts from xml file using the creator class
		smartPosts.addAll(creator.createObjects());

		for(int i = 0; i < smartPosts.size(); i++) { //create list of cities
			if(Cities.contains(smartPosts.get(i).cit) == false) {
				Cities.add(smartPosts.get(i).cit);
			}
		}
    }
    public static SmartPostHandler getInstance() {
        return INSTANCE;
    }


	public ArrayList<SmartPost> getSmartPosts() {
		return smartPosts;
	}

	public ArrayList<SmartPost> SearchPostsFromCity(String city) { //Returns a list of smartposts in a city
		ArrayList<SmartPost> CityPostList = new ArrayList<SmartPost>();
		for (int i = 0; i < smartPosts.size() - 1; i++) {
			if(smartPosts.get(i).cit.equals(city)) {
				CityPostList.add(smartPosts.get(i));
			}
		}
		return CityPostList;
	}

	public ArrayList<String> getCities() {
		return Cities;
	}

	public double getDistance(SmartPost Start, SmartPost End, WebView web) { //Calculates the distance between two smartposts

		ArrayList<Double> cr = new ArrayList<Double>();
		cr.add(Start.latitude);
		cr.add(Start.longitude);
		cr.add(End.latitude);
		cr.add(End.longitude);
		String cl = "red";
		int pr = 1;

		double distance = (double)web.getEngine().executeScript("document.createPath(" + cr + ", '" + cl + "', " + pr + ")");

		return distance;
	}
}
