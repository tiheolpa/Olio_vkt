//Pankkiluokka, sisältää metodit tilin lisäämiseen, postamiseen, tallettamiseen, nostoon ja etsintään.

public class Bank {
	public Bank() {
	}
	public void addAccount(String number, int mon, int credit) {
		System.out.println("Pankkiin lisätään: " + number + "," + mon + "," + credit);
	}
	public void addAccount(String number, int mon) {
		System.out.println("Pankkiin lisätään: " + number + "," + mon);
	}

	public void depositInto(String number, int mon) {
		System.out.println("Talletetaan tilille: " + number + " rahaa " + mon);
	}

	public void withdrawFrom(String number, int mon) {
		System.out.println("Nostetaan tililtä: " + number + " rahaa " + mon);
	}

	public void removeAccount(String number){
		System.out.println("Tili poistettu.");
	}

	public void searchAccount(String number) {
		System.out.println("Etsitään tiliä: " + number);
	}
}