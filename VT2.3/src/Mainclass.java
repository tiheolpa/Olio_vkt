import java.util.Scanner;

//Pääluokka
public class Mainclass {
	public static void main(String[] args) {
		String line1 = "Hau!";
		String line2 = "Vuh!"; //Puhuttavat asiat koirille.

		System.out.print("Anna koiralle nimi: "); //alustetaan skanneri, jolla otetaan syöte käyttäjältä
		Scanner skanneri = new Scanner(System.in);
		String nimi = skanneri.nextLine();

		Dog koira1 = new Dog(nimi);

		System.out.print("Mitä koira sanoo: ");
		String puhe = skanneri.nextLine();
		koira1.speak(puhe);
	}
}