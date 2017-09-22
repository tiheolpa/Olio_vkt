//Pääluokka
public class Mainclass {
	public static void main(String[] args) {
		String line1 = "Hau!";
		String line2 = "Vuh!"; //Puhuttavat asiat koirille.

		Dog koira1 = new Dog("Rekku"); //Koiraolioiden alustus
		Dog koira2 = new Dog("Musti");

		koira1.speak(line1); // Puhumismetodin käyttöä
		koira2.speak(line2);
	}
}