package Paketti;
import java.util.ArrayList;

public class BottleDispenser {
	private int numBottles;
	private int money;
	ArrayList<Bottle> pullot = new ArrayList<Bottle>();

	public BottleDispenser() {
		numBottles = 5;
		money = 0;
		Bottle pepsipullo = new Bottle("Pepsi Max", "Pepsi", 0.3f);
		pullot.add(pepsipullo);

	}
	public void moneyIntake(int Raha) {
		System.out.println("Klink! Lisää rahaa laitteeseen!");
		money = money + Raha;

	}
	public void ostaPullo() {
		if (money <= 0) {
			System.out.println("Syätä rahaa ensin!");
		}
		else {
			System.out.println("KACHUNK! " + pullot.get(0).merkki + " tipahti masiinasta!");
			money--;
		}
	}
	public void rahanPalautus() {
		System.out.println("Klink klink. Sinne menivät rahat!");
	}
}
