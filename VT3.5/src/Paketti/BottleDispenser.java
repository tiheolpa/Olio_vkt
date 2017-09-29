package Paketti;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BottleDispenser {
	private int numBottles;
	private float money;
	ArrayList<Bottle> pullot = new ArrayList<Bottle>();

	public BottleDispenser() {
		numBottles = 5;
		money = 0;
		Bottle pepsipullo = new Bottle("Pepsi Max", "Pepsi", 0.5f, 1.80f);
		pullot.add(pepsipullo);
		pullot.add(new Bottle("Pepsi Max", "Pepsi", 1.5f, 2.2f));
		pullot.add(new Bottle("Coca-Cola Zero", "Pepsi", 0.5f, 2.0f));
		pullot.add(new Bottle("Coca-Cola Zero", "Pepsi", 1.5f, 2.50f));
		pullot.add(new Bottle("Fanta Zero", "Pepsi", 0.5f, 1.95f));
		pullot.add(new Bottle("Fanta Zero", "Pepsi", 0.5f, 1.95f));

	}
	public void moneyIntake(float Raha) {
		System.out.println("Klink! Lisää rahaa laitteeseen!");
		money = money + Raha;

	}
	public void ostaPullo(int id) {
		id--;
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
		System.out.println("Klink klink. Sinne menivät rahat! Rahaa tuli ulos " + String.format("%.2f", money).replace(".", ",") + "€");

	}

	public void listaaPullot() {
		for (int i = 0; i < pullot.size(); i++) {
			System.out.println((i + 1) + ". Nimi: " + pullot.get(i).merkki);
			System.out.println("\tKoko: " + pullot.get(i).koko + "\tHinta: " + pullot.get(i).hinta);
		}
	}
}
