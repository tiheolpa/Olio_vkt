package application;

public class PackageC2 extends Package {

	public PackageC2(Item cont, String senderCit, String dest, double slat, double slon, double elat, double elon) {
		priority = 2;
		content.add(cont);
		senderCity = senderCit;
		destination = dest;
		sendLat = slat;
		sendLon = slon;
		endLat = elat;
		endLon = elon;
		breaksItems = false;
		maxSize = 300;

		/*if(pr == 1) {
			maxDistance = 150;
		}*/
	}

}