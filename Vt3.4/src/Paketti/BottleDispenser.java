package Paketti;
import java.util.ArrayList;

public class BottleDispenser {
	private int numBottles;
	private float money;
	private int id = 0; //valintaindeksi on tulevaisuuden valintaominaisuutta varten
	ArrayList<Bottle> pullot = new ArrayList<Bottle>();

	public BottleDispenser() {
		numBottles = 5;
		money = 0;
		Bottle pepsipullo = new Bottle("Pepsi Max", "Pepsi", 0.5f, 1.80f);
		pullot.add(pepsipullo);
		pullot.add(pepsipullo);
		pullot.add(pepsipullo);
		pullot.add(pepsipullo);
		pullot.add(pepsipullo);
		pullot.add(pepsipullo);

	}
	public void moneyIntake(float Raha) {
		System.out.println("Klink! Lisää rahaa laitteeseen!");
		money = money + Raha;

	}
	public void ostaPullo() {
		if (money <= pullot.get(id).hinta) {
			System.out.println("Syötä rahaa ensin!");
		}
		else {
			System.out.println("KACHUNK! " + pullot.get(id).merkki + " tipahti masiinasta!");
			money = money - pullot.get(id).hinta;
			pullot.remove(id);
		}
	}
	public void rahanPalautus() {
		System.out.println("Klink klink. Sinne menivät rahat!");
	}

	public void listaaPullot() {
		for (int i = 0; i < pullot.size(); i++) {
			System.out.println((i + 1) + ". Nimi: " + pullot.get(i).merkki);
			System.out.println("\tKoko: " + pullot.get(i).koko + "\tHinta: " + pullot.get(i).hinta);
		}
	}
}
