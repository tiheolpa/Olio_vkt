import java.util.Scanner;
//Yksinkertainen ohjelma, sisältää vain valikontulostusfunktion ja yksinkertaisen valitsimen. Pohja saatu edellisistä tehtävistä

public class Mainclass {
	static String tilinro;
	static String rahamaara;
	static String luotto;
	public static void main(String[] args) {
		Scanner skanneri = new Scanner(System.in);
		boolean looping = true;

		while (looping == true) {
			printMenu();
			System.out.print("Valintasi: ");
			String valinta = skanneri.nextLine();
			switch(Integer.parseInt(valinta)) {
				case 1:
					System.out.print("Syötä tilinumero: ");
					tilinro = skanneri.nextLine();
					System.out.print("Syötä rahamäärä: ");
					rahamaara = (skanneri.nextLine());
					System.out.println("Tilinumero: " + tilinro);
					System.out.println("Rahamäärä: " + rahamaara);
					break;
				case 2:
					System.out.print("Syötä tilinumero: ");
					tilinro = skanneri.nextLine();
					System.out.print("Syötä rahamäärä: ");
					rahamaara = skanneri.nextLine();
					System.out.print("Syötä luottoraja: ");
					luotto = (skanneri.nextLine());
					System.out.println("Tilinumero: " + tilinro);
					System.out.println("Rahamäärä: " + rahamaara);
					System.out.println("Luotto: " + luotto);
					break;
				case 3:
					System.out.print("Syötä tilinumero: ");
					tilinro = skanneri.nextLine();
					System.out.print("Syötä rahamäärä: ");
					rahamaara = skanneri.nextLine();
					System.out.println("Tilinumero: " + tilinro);
					System.out.println("Rahamäärä: " + rahamaara);
					break;
				case 4:
					System.out.print("Syötä tilinumero: ");
					tilinro = skanneri.nextLine();
					System.out.print("Syötä rahamäärä: ");
					rahamaara = skanneri.nextLine();
					System.out.println("Tilinumero: " + tilinro);
					System.out.println("Rahamäärä: " + rahamaara);
					break;
				case 5:
					System.out.print("Syötä poistettava tilinumero: ");
					tilinro = skanneri.nextLine();
					System.out.println("Tilinumero: " + tilinro);
					break;
				case 6:
					System.out.print("Syötä tulostettava tilinumero: ");
					tilinro = skanneri.nextLine();
					System.out.println("Tilinumero: " + tilinro);
					break;
				case 7:
					System.out.println("Tulostaa kaiken");
					break;
				case 0:
					looping = false;
					break;
				default:
					System.out.println("Valinta ei kelpaa.");
					break;
			}
		}
	}
	private static void printMenu() {
		System.out.println("\n*** PANKKIJÄRJESTELMÄ ***");
		System.out.println("1) Lisää tavallinen tili");
		System.out.println("2) Lisää luotollinen tili");
		System.out.println("3) Tallenna tilille rahaa");
		System.out.println("4) Nosta tililtä");
		System.out.println("5) Poista tili");
		System.out.println("6) Tulosta tili");
		System.out.println("7) Tulosta kaikki tilit");
		System.out.println("0) Lopeta");
	}
}