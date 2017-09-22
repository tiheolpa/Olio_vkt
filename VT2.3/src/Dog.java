//Koiraluokka
public class Dog {
	private String name;
	Dog(String nimi) {
		name = nimi;
		System.out.println("Hei, nimeni on " + name + "!");
	}

	public void speak(String lausahdus) {
		System.out.println(name + ": " + lausahdus);
	}
}