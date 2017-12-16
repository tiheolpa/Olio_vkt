package application;

public class PackageC2 extends Package { //Second class package.

	public PackageC2(Item cont, SmartPost senderCit, SmartPost dest) {
		priority = 2;
		content.add(cont);
		senderPost = senderCit;
		destination = dest;
		breaksItems = false;
		maxDistance = 1100;
		maxSize = 50*50*50;
	}

}