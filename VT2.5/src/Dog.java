import java.util.Scanner;

//Koiraluokka
public class Dog {
	private String name;
	Dog(String nimi) {
		if (nimi.isEmpty() == true) { // Tarkistetaan if-lauseella onko syöte tyhjä string
			name = "Doge";
		}
		else {
			name = nimi;
		}
		System.out.println("Hei, nimeni on " + name);
	}

	public void speak(String lausahdus) {
		if (lausahdus.isEmpty() == true) {
			System.out.println(name + ": Much wow!");
		}
		else {
			//String vali = " ";
			//String sanajono[] = lausahdus.split(vali);
			Scanner newScanner = new Scanner(lausahdus);
			while(newScanner.hasNext()) {
				if (newScanner.hasNextBoolean()) { //tutkitaan scannerin metodien avulla onko teksti tyypiltään boolean vai int
					System.out.println("Such boolean: " + newScanner.next());
				}
				else if (newScanner.hasNextInt()) {
					System.out.println("Such integer: " + newScanner.next());
				}
				else {
					System.out.println(newScanner.next());
				}
			}
		}
	}
}