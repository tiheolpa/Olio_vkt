package Paketti;

public class Bottle {
	public String merkki;
	public String limsa;
	public float koko;
	public float hinta;
	public Bottle(String name, String drink, float size, float prize) {
		if (name != "") {
			merkki = "Pepsi Max";
		}
		if (drink != "") {
			limsa = "Pepsi";
		}
		if (size < 0) {
			koko = 0.3f;
		}
		if (prize < 0) {
			hinta = 1.80f;
		}
	}
}
