package application;

public class PackageC1 extends Package { //Inherited first class package

	public PackageC1(Item cont, SmartPost senderCit, SmartPost dest) {
		priority = 1;
		content.add(cont);
		senderPost = senderCit;
		destination = dest;
		maxDistance = 150;
		breaksItems = true;
		maxSize = 100*100*100;

	}
}
