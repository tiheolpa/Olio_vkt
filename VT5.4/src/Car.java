import java.util.ArrayList;
import java.util.Arrays;

public class Car {

	public ArrayList<Object> lista = new ArrayList<Object>();
	public Car() {

		Kori Body = new Kori();
		Alusta Chassis = new Alusta();
		Moottori Engine = new Moottori();
		Rengas Wheel = new Rengas();
		Rengas Wheel2 = new Rengas();
		Rengas Wheel3 = new Rengas();
		Rengas Wheel4 = new Rengas();

		lista.add(Body);
		lista.add(Chassis);
		lista.add(Engine);
		lista.add(Wheel);
		lista.add(Wheel2);
		lista.add(Wheel3);
		lista.add(Wheel4);


	}
	public void print() {
		int Chassiscount = 0;
		int Bodycount = 0;
		int Enginecount = 0;
		int Wheelcount = 0;
		ArrayList<String> printList = new ArrayList <String>(){{add("1");add("1");add("1");add("1");}};

		for (int i = 0; i<lista.size(); i++) {
			if (lista.get(i) instanceof Kori ) {
				Chassiscount++;
				if (Chassiscount <= 1) {
					printList.set(0, "");
				} else {
					printList.set(0, Integer.toString(Chassiscount) + " ");
				}
			}
			if (lista.get(i) instanceof Alusta ) {
				Bodycount++;
				if (Bodycount <= 1) {
					printList.set(1, "");
				} else {
					printList.set(1, Integer.toString(Bodycount) + " ");
				}
			}
			if (lista.get(i) instanceof Moottori ) {
				Enginecount++;
				if (Enginecount <= 1) {
					printList.set(2, "");
				} else {
					printList.set(2, Integer.toString(Enginecount) + " ");
				}
			}
			if (lista.get(i) instanceof Rengas ) {
				Wheelcount++;
				if (Wheelcount <= 1) {
					printList.set(3, "");
				} else {
					printList.set(3, Integer.toString(Wheelcount) + " ");
				}
			}
		}
		System.out.println("Autoon kuuluu:");
		System.out.println("\t" + printList.get(0) + "Body");
		System.out.println("\t" + printList.get(1) + "Chassis");
		System.out.println("\t" + printList.get(2) + "Engine");
		System.out.println("\t" + printList.get(3) + "Wheel");
	}
}

class Kori {
	public Kori() {
		System.out.println("Valmistetaan: Body");
	}
}

class Alusta {
	public Alusta() {
		System.out.println("Valmistetaan: Chassis");
	}
}

class Moottori {
	public Moottori() {
		System.out.println("Valmistetaan: Engine");
	}
}

class Rengas {
	public Rengas() {
		System.out.println("Valmistetaan: Wheel");
	}
}