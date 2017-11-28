package application;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainFXMLController {
	private String tiedostonimi;
	@FXML TextField InputField;
	@FXML Button SaveButton;
	@FXML Button LoadButton;

	@FXML
	private void SaveButtonPress() throws IOException {
		Scanner input = new Scanner(System.in); //Käytetään scanneria tiedostonmien valitsemiseen
		System.out.println("Syötö tiedoston nimi:");
		tiedostonimi = input.next();
		BufferedWriter writer = new BufferedWriter(new FileWriter(tiedostonimi));
		writer.write(InputField.getText());
		input.close();
		writer.close();
	}

	@FXML
	private void LoadButtonPress() {
		Scanner input = new Scanner(System.in);
		String tiedostonimi = input.next();
		Scanner fileScanner = new Scanner(tiedostonimi);
		InputField.setText(fileScanner.nextLine());

		input.close();
		fileScanner.close();


	}

}
