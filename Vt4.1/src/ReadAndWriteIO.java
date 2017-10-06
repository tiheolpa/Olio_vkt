import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndWriteIO {
	public ReadAndWriteIO() {
	}
	public void readFile(String path) {
		try {
			FileReader polku = new FileReader(path);
			BufferedReader in = new BufferedReader(polku); //Käytetään BufferedReaderia rivien lukuun.
			String inputline;
			while ((inputline = in.readLine()) != null) {
				System.out.println(inputline);
			}
			in.close();
		} catch (IOException e){
			System.out.println("Virhe tiedostoa luettaessa"); //Jos tiedostoa ei löydy, annetaan virheilmoitus.
		}
	}
}
