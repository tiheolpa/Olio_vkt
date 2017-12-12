package application;

import java.util.ArrayList;

public final class SmartPostHandler {
    private static final SmartPostHandler INSTANCE = new SmartPostHandler();

	public ArrayList<SmartPost> smartPosts = new ArrayList<SmartPost>();


	/*static final ArrayList<SmartPost> smartPosts = new ArrayList<SmartPost>() {{
		for(int i = 0; i < temp.size(); i++) {
			add(temp.get(i));
		}
	}};*/

	ArrayList<String> Cities = new ArrayList<String>();

    private SmartPostHandler() {
		SmartPostCreator creator = new SmartPostCreator("smartpostdata.xml");
		smartPosts.addAll(creator.createObjects());
		for(int i = 0; i < smartPosts.size(); i++) {
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
