package application;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainFXMLController implements Initializable  {
	@FXML TextField InputField;
	@FXML Button MoneyAdder;
	@FXML Button ReturnButton;
	@FXML Button BuyButton;
	@FXML Label InfoLabel;
	@FXML Label MoneyLabel;

	BottleDispenser automaatti = BottleDispenser.getInstance();
	String lastDispensedBottle ="";

	@FXML ChoiceBox<String> BottleList;



	@FXML
	private void AddButtonPress() { //Lisää rahaa tekstikentän pohjalta.
		if (!InputField.getText().isEmpty()) {
			automaatti.moneyIntake(Float.parseFloat(InputField.getText()));
			InfoLabel.setText("Lisättiin rahaa " + InputField.getText() + "€" );
			MoneyLabel.setText(automaatti.getMoney() + "€");
		}
		else {
			InfoLabel.setText("Anna ensin syötettävä rahasumma!");
		}
	}

	@FXML
	private void ReturnButtonPress() {
		float returnedMoney = automaatti.rahanPalautus();
		InfoLabel.setText("Palautettiin " + Float.toString(returnedMoney) + "€");
	}

	@FXML
	private void BuyButtonPress() { //Pullon osto. Ei toistaiseksi tarkista, onko pulloa valittu
		int buyID = BottleList.getSelectionModel().getSelectedIndex();
		InfoLabel.setText("Ostettiin " + BottleList.getItems().get(buyID));
		lastDispensedBottle = BottleList.getItems().get(buyID);
		automaatti.ostaPullo(buyID);
		BottleList.setItems(FXCollections.observableArrayList(automaatti.getBottles()));
		MoneyLabel.setText(automaatti.getMoney() + "€");

	}

	@FXML
	private void printReceipt() throws IOException {
		if (!lastDispensedBottle.isEmpty()) {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Kuitti.txt"));
			writer.write("Kuitti limsaostoksesta\n" + lastDispensedBottle);
			writer.close();
			InfoLabel.setText("Kuitti tulostettu (Kuitti.txt)");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		BottleList.setItems(FXCollections.observableArrayList(automaatti.getBottles()));


	}

}
