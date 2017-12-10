package application;

import java.util.ArrayList;

public class SmartPostHandler {
	static ArrayList<SmartPost> smartPosts = new ArrayList<SmartPost>();
	ArrayList<String> Cities = new ArrayList<String>();
	
	public SmartPostHandler() {
		SmartPostCreator creator = new SmartPostCreator("smartpostdata.xml");
		smartPosts.addAll(creator.createObjects());
		for(int i = 0; i < smartPosts.size(); i++) {
			if(Cities.contains(smartPosts.get(i).cit) == false) {
				Cities.add(smartPosts.get(i).cit);
			}
		}
	}

	public static ArrayList<SmartPost> getSmartPosts() {
		return smartPosts;
	}

	public ArrayList<SmartPost> SearchPostsFromCity(String city) {
		ArrayList<SmartPost> CityPostList = new ArrayList<SmartPost>();
		for (int i = 0; i < smartPosts.size() - 1; i++) {
			if(smartPosts.get(i).cit == city) {
				CityPostList.add(smartPosts.get(i));
			}
		}
		return CityPostList;
	}

	public ArrayList<String> getCities() {
		return Cities;
	}
}
