package Paketti;

public class Bottle {
	public String merkki;
	public String limsa;
	public float koko;
	public float hinta;
	public Bottle(String name, String drink, float size, float prize) {
		if (name == "") {
			merkki = "Pepsi Max";
		}
		else {
			merkki = name;
		}
		if (drink == "") {
			limsa = "Pepsi";
		}
		else {
			limsa = drink;
		}
		if (size <= 0) {
			koko = 0.3f;
		}
		else {
			koko = size;
		}
		if (prize <= 0) {
			hinta = 1.80f;
		}
		else {
			hinta = prize;
		}
	}
}
