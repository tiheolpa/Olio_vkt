package application;

public class PackageC3 extends Package {

	public PackageC3(Item cont, String senderCit, String dest, double slat, double slon, double elat, double elon) {
		priority = 3;
		content.add(cont);
		senderCity = senderCit;
		destination = dest;
		sendLat = slat;
		sendLon = slon;
		endLat = elat;
		endLon = elon;
		maxDistance = 150;
		maxSize = 800;
		breaksItems = true;

		/*if(pr == 1) {
			maxDistance = 150;
		}*/
	}

}