package application;

public class PackageC1 extends Package {

	public PackageC1(Item cont, String senderCit, String dest, double slat, double slon, double elat, double elon) {
		priority = 1;
		content.add(cont);
		senderCity = senderCit;
		destination = dest;
		sendLat = slat;
		sendLon = slon;
		endLat = elat;
		endLon = elon;
		maxDistance = 150;
		breaksItems = true;
		maxSize = 800;

		/*if(pr == 1) {
			maxDistance = 150;
		}*/
	}

}
