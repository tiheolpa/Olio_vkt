package Paketti;

public class Mainclass {
	public static void main(String[] args) {
		int omatRahat;
		BottleDispenser automaatti = new BottleDispenser();
		automaatti.moneyIntake(1);
		automaatti.ostaPullo();
		automaatti.ostaPullo();
		automaatti.moneyIntake(1);
		automaatti.moneyIntake(1);
		automaatti.ostaPullo();
		automaatti.rahanPalautus();

	}
}