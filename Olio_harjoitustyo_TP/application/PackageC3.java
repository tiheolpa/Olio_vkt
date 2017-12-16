package application;

public class PackageC3 extends Package { //Third class package

	public PackageC3(Item cont, SmartPost senderCit, SmartPost dest) {
		priority = 3;
		content.add(cont);
		senderPost = senderCit;
		destination = dest;
		maxDistance = 200;
		maxSize = 100*100*100;
		breaksItems = true;
	}
}