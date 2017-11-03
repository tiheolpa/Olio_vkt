//Pankkiluokka, sisältää metodit tilin lisäämiseen, postamiseen, tallettamiseen, nostoon ja etsintään.
//muutettu: tililuokka on luotu ja otettu käyttöön
import java.util.ArrayList;

public class Bank {
	public static ArrayList<Account> accounts = new ArrayList<Account>(); //luodaan arraylist tileille
	int j;
	public Bank() {
	}
	public void addAccount(String number, int mon, int credit) { //luottotilin toimintaa ei ole vilä luotu ->toimii kuin normaali tili
		Account newAccount = new Account(number, mon);
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
		System.out.println("Talletetaan tilille: " + number + " rahaa " + mon);
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
		System.out.println("Tili poistettu.");
	}

	public void searchAccount(String number) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).accNum.equals(number)) {
				j = i;
				break;
			}
		}
		System.out.println("Tilinumero: " + accounts.get(j).accNum + " Tilillä rahaa: " + accounts.get(j).monIn);
	}
}