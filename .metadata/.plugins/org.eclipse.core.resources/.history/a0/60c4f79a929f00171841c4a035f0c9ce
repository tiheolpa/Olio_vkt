import java.util.Scanner;

//Pääluokka
public class Mainclass {
	public static void main(String[] args) {

		System.out.print("Anna koiralle nimi: "); //alustetaan skanneri, jolla otetaan syöte käyttäjältä
		Scanner skanneri = new Scanner(System.in);
		String nimi = skanneri.nextLine();

		Dog koira1 = new Dog(nimi);

		System.out.print("Mitä koira sanoo: ");
		String puhe = "";
		puhe = skanneri.nextLine();
		koira1.speak(puhe);
		if (puhe.isEmpty() == true) {
			boolean looping = true;
			while (looping == true) { // jos syöte on tyhjä, mennään silmukkaan kunnes saadaan ei-tyhjä syöte
				System.out.print("Mitä koira sanoo: ");
				puhe = skanneri.nextLine();
				if (puhe.isEmpty() == false) {
					looping = false;
				}
				koira1.speak(puhe);
			}
		}

	}
}