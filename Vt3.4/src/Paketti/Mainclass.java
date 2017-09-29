package Paketti;
import java.util.Scanner;


public class Mainclass {
	public static void main(String[] args) {
		boolean looping = true;
		Scanner skanneri = new Scanner(System.in);
		BottleDispenser automaatti = new BottleDispenser();
		while (looping) {
			printMenu();
			System.out.print("Valintasi: ");
			String valinta = skanneri.nextLine();
			switch(Integer.parseInt(valinta)) {
			case 1:
				automaatti.moneyIntake(1);
				break;
			case 2:
				automaatti.ostaPullo();
				break;
			case 3:
				automaatti.rahanPalautus();
				break;
			case 4:
				automaatti.listaaPullot();
				break;
			case 0:
				looping = false;
				break;
			default:
				System.out.println("Epäkelvollinen syöte");
			}


		}
	}

	private static void printMenu() {
		System.out.println("");
		System.out.println("*** LIMSA-AUTOMAATTI ***");
		System.out.println("1) Lisää rahaa koneeseen");
		System.out.println("2) Osta pullo");
		System.out.println("3) Ota rahat ulos");
		System.out.println("4) Listaa koneessa olevat pullot");
		System.out.println("0) Lopeta");
	}
}