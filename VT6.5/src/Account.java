//Tililuokka. Lisätty nyt myös luottotili joka perii perustilin ominaisuudet

public class Account {
	String accNum;
	int monIn;
	public Account(String number, int mon) {
		accNum = number;
		monIn = mon;
	}
}

class basicAccount extends Account {
	public basicAccount (String number, int mon) {
		super(number, mon);
	}
}

class creditAccount extends Account {
	int maxCredit;
	public creditAccount(String number, int mon, int credit) {
		super(number, mon);
		maxCredit = credit;
	}

	public int getCredit() {
		return maxCredit;
	}
}