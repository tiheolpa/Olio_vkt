package application;

public class Theatre {
	private String theatreLocation;
	private int theatreID;
	public Theatre (String location, int idnumber) {
		theatreLocation = location;
		theatreID = idnumber;
	}

	public int GetID() {
		return theatreID;
	}

	public String GetLocation() {
		return theatreLocation;
	}
}
