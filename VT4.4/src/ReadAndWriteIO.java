import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteIO {
	public ReadAndWriteIO() {
	}
	public void readFile(String path) {
		try {
			FileReader polku = new FileReader(path);
			BufferedReader in = new BufferedReader(polku);
			String inputline;
			while ((inputline = in.readLine()) != null) {
				System.out.print(inputline);
			}
			in.close();
		} catch (IOException e){
			System.out.println("Virhe tiedostoa luettaessa");
		}
	}


	public void readAndWrite(String path, String outputFile) {
		try {
			FileReader polku = new FileReader(path);
			FileWriter tulostuspolku = new FileWriter(outputFile);
			BufferedReader in = new BufferedReader(polku);
			BufferedWriter out = new BufferedWriter(tulostuspolku);
			String inputline;
			while ((inputline = in.readLine()) != null) {
				inputline = inputline.trim();
				if ((inputline.isEmpty() != true) && (inputline.length() < 30)) { // Samanlainen kirjoitusmenetelmä kuin edellisessä, nyt on vain ehto kirjoittamiselle
					inputline.contains("v");
					out.write(inputline + "\n");
				}
			}
			in.close();
			out.close();
		} catch (IOException e){
			System.out.println("Virhe tiedostoa luettaessa");
		}
	}
}
