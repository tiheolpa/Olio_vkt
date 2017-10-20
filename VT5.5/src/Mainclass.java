import java.util.ArrayList;
import java.util.Scanner;

public class Mainclass {
	static ArrayList<String> CharClasses = new ArrayList<String>();
	static ArrayList<String> CharClassTypes = new ArrayList<String>();
	static ArrayList<Weapon> Weapons = new ArrayList<Weapon>();
	static Character Hahmo;

	public static void main(String[] args) {
		//Lisätään aseet, hahmot ja niiden englanninkieliset vastineet listoille.
		CharClasses.add("Kuningas");
		CharClasses.add("Ritari");
		CharClasses.add("Kuningatar");
		CharClasses.add("Peikko");
		CharClassTypes.add("King");
		CharClassTypes.add("Knight");
		CharClassTypes.add("Queen");
		CharClassTypes.add("Troll");
		Weapons.add(new Knife());
		Weapons.add(new Axe());
		Weapons.add(new Sword());
		Weapons.add(new Mace());
		boolean looping = true;
		Scanner skanneri = new Scanner(System.in);

		//Silmukka valikon pyörittämiseen
		while (looping == true)
			while (looping) {
				printMenu();
				System.out.print("Valintasi: ");
				String valinta = skanneri.nextLine();
				int Cid;
				int Wid;

				switch(Integer.parseInt(valinta)) {
				case 1:
					listCharacters();
					System.out.print("Valintasi: ");
					Cid = Integer.parseInt(skanneri.nextLine());

					listWeapons();
					System.out.print("Valintasi: ");
					Wid = Integer.parseInt(skanneri.nextLine());
					Hahmo = new Character(CharClassTypes.get(Cid - 1), Weapons.get(Wid - 1)); //Luodaan hahmoolio valintojen pohjalta
					break;
				case 2:
					System.out.println(Hahmo.Luokka + " tappelee aseella " + Hahmo.ase.WType);
					break;
				case 0:
					looping = false;
					break;
				default:
					System.out.println("Epäkelvollinen syöte");
					break;
				}
				}
		skanneri.close();
	}
	private static void printMenu() {
		System.out.println("*** TAISTELUSIMULAATTORI ***");
		System.out.println("1) Luo hahmo");
		System.out.println("2) Taistele hahmolla");
		System.out.println("0) Lopeta");
	}

	public static void listCharacters() {
		System.out.println("Valitse hahmosi: ");
		for (int i = 0; i < CharClasses.size(); i++) {
			System.out.println((i + 1) + ") " + CharClasses.get(i));
		}
	}
	public static void listWeapons() {
		System.out.println("Valitse aseesi: ");
		for (int i = 0; i < Weapons.size(); i++) {
			System.out.println((i + 1) + ") " + ( Weapons.get(i)).Wfin);
		}
	}
}

//Aseluokat ja siitä perivät luokat
	class Weapon {
		public String WType;
		public String Wfin;
		public Weapon() {
		}
		public String GetWtype() {
			return WType;
		}
	}

	class Knife extends Weapon {

		public Knife() {
			WType = "Knife";
			Wfin = "Veitsi";

		}
	}

	class Axe extends Weapon {

		public Axe() {
			WType = "Axe";
			Wfin = "Kirves";

		}
	}

	class Sword extends Weapon {

		public Sword() {
			WType = "Sword";
			Wfin = "Miekka";

		}
	}

	class Mace extends Weapon {

		public Mace() {
			WType = "Mace";
			Wfin = "Nuija";

		}
	}
