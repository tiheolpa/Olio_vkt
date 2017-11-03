//Pankkiluokka, sisältää metodit tilin lisäämiseen, postamiseen, tallettamiseen, nostoon ja etsintään.
//muutettu: lisätty luottotilin käyttö ja tilinpoistofunktion toiminnallisuus
import java.util.ArrayList;

public class Bank {
	public static ArrayList<Account> accounts = new ArrayList<Account>(); //luodaan arraylist tileille
	int j;
	creditAccount creditDummy = new creditAccount("1-2", 123, 123);
	public Bank() {
	}
	public void addAccount(String number, int mon, int credit) {
		Account newAccount = new creditAccount(number, mon, credit);
		accounts.add(newAccount);
		System.out.println("Tili luotu.");
	}
	public void addAccount(String number, int mon) {
		Account newAccount = new Account(number, mon);
		accounts.add(newAccount);
		System.out.println("Tili luotu.");
	}

	public void depositInto(String number, int mon) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).accNum.equals(number)) {
				accounts.get(i).monIn = accounts.get(i).monIn + mon;
				break;
			}
		}
	}

	public void withdrawFrom(String number, int mon) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).accNum.equals(number)) {
				accounts.get(i).monIn = accounts.get(i).monIn - mon;
				break;
			}
		}
	}

	public void removeAccount(String number){
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).accNum.equals(number)) {
				accounts.remove(i);
				break;
			}
		}
		System.out.println("Tili poistettu.");
	}

	public void searchAccount(String number) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).accNum.equals(number)) {
				j = i;
				break;
			}
		}
		if(accounts.get(j).getClass() == (creditDummy.getClass())) {
			creditAccount temp = (creditAccount) accounts.get(j);
			System.out.println("Tilinumero: " + accounts.get(j).accNum + " Tilillä rahaa: " + accounts.get(j).monIn + " Luottoraja: " + temp.getCredit());
		} else {
			System.out.println("Tilinumero: " + accounts.get(j).accNum + " Tilillä rahaa: " + accounts.get(j).monIn);
		}
	}
	public void printAllAcc() {
		System.out.println("Kaikki tilit:");
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getClass() == (creditDummy.getClass())) {
				creditAccount temp = (creditAccount) accounts.get(i);
				System.out.println("Tilinumero: " + accounts.get(i).accNum + " Tilillä rahaa: " + accounts.get(i).monIn + " Luottoraja: " + temp.getCredit());
			} else {
				System.out.println("Tilinumero: " + accounts.get(i).accNum + " Tilillä rahaa: " + accounts.get(i).monIn);
			}
		}
	}
}