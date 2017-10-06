import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipInputStream;


public class ReadAndWriteIO {
	public ReadAndWriteIO() {
	}
	public void readFile(String path) {
		try {
			FileInputStream polku = new FileInputStream(path); //Käytetään zipinputstreamia zip-tiedostoista lukemiseen
			ZipInputStream zipLukija = new ZipInputStream(polku);
			zipLukija.getNextEntry();
			Scanner skanneri = new Scanner(zipLukija); //skanneri lukee zipinputstreamia

			while (skanneri.hasNext()) {
				System.out.println(skanneri.nextLine());
			}
			zipLukija.close();
			skanneri.close();
		} catch (IOException e){
			System.out.println("Virhe tiedostoa luettaessa");
		}
	}

	//Vastaavanlainen metodi kirjoittamiseen kuin edellisessä kohdassa, nyt vain zip-tiedostoille
	public void readAndWrite(String path, String outputFile) {
		try {
			FileInputStream polku = new FileInputStream(path);
			ZipInputStream zipLukija = new ZipInputStream(polku);
			Scanner skanneri = new Scanner(zipLukija);

			FileWriter tulostuspolku = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(tulostuspolku);
			String inputline;
			while (skanneri.hasNextLine()) {
				inputline = skanneri.nextLine();
				out.write(inputline + "\n");
			}
			zipLukija.close();
			out.close();
			skanneri.close();
		} catch (IOException e){
			System.out.println("Virhe tiedostoa luettaessa");
		}
	}
}
