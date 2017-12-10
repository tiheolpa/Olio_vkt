package application;

public class SmartPost {
	public int postalcode;
	public String cit;
	public String adr;
	public String avalibility;
	public String postoffice;
	public double latitude;
	public double longitude;

	public SmartPost(int code, String city, String adress, String aval, String po, double lat, double lon) {
		postalcode = code;
		cit = city;
		adr = adress;
		avalibility = aval;
		postoffice = po;
		latitude = lat;
		longitude = lon;
	}
}
