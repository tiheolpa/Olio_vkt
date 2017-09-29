
public class BottleDispenser {
	private int numBottles;
	private int money;
	public void BottleDispenser() {
		numBottles = 5;
		money = 0;
	}
	public void moneyIntake(int Raha) {
		System.out.println("Klink! Lisää rahaa laitteeseen!");
		money = money + Raha;

	}
	public void ostaPullo() {
		if (money <= 0) {
			System.out.println("Syötä rahaa ensin!");
		}
		else {
			System.out.println("KACHUNK! Pullo tipahti masiinasta!");
			money--;
		}
	}
	public void rahanPalautus() {
		System.out.println("Klink klink. Sinne menivät rahat!");
	}
}
