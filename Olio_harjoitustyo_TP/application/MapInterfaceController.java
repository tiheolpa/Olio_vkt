package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MapInterfaceController implements Initializable {

	@FXML Button AddToMapButton;
	@FXML Button SendButton;
	@FXML Button NewPackageButton;
	@FXML Button UpdateButton;
	@FXML Button RemovePathsButton;
	@FXML ChoiceBox<String> PostChoiceBox;
	@FXML ChoiceBox<String> PackageSelectionBox;
	@FXML WebView web;

	Storage storage = Storage.getInstance();
	SmartPostHandler postHandler = new SmartPostHandler();

	@FXML
	private void AddToMapButtonPress() {
		int Selection = PostChoiceBox.getSelectionModel().getSelectedIndex();
		String address = SmartPostHandler.getSmartPosts().get(Selection).adr;
		String postalcode = Integer.toString(SmartPostHandler.getSmartPosts().get(Selection).postalcode);
		String postoffice = SmartPostHandler.getSmartPosts().get(Selection).postoffice;
		String arguments = "(" + address + ", " + postalcode + ", " + postoffice + ")";

		web.getEngine().executeScript("document.goToLocation" + arguments);
	}

	@FXML
	private void SendButtonPress() {
		int selection = PackageSelectionBox.getSelectionModel().getSelectedIndex();

		String slat = String.valueOf(storage.GetPackage(selection).sendLat);
		String slon = String.valueOf(storage.GetPackage(selection).sendLon);
		String elat = String.valueOf(storage.GetPackage(selection).endLat);
		String elon = String.valueOf(storage.GetPackage(selection).endLon);
		String color;
		String priority;

		String arguments = "([" + slat + "," + slon + "," + elat + "," + elon + "]," + color + "," + priority + ")";
		web.getEngine().executeScript("document.createPath" + arguments);
	}

	public void drawRoad() {

	}
	@FXML
	private void CreatePackageButtonPress() {
		try {
			Stage NewPackageView = new Stage();
			Parent page = FXMLLoader.load(getClass().getResource("NewPackageInterface.fxml"));
			Scene scene = new Scene(page);

			NewPackageView.setScene(scene);
			NewPackageView.setTitle("Luo uusi paketti");
			NewPackageView.show();

		} catch (IOException e) {
			//Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}

	}

	@FXML
	private void UpdateButtonPress() {

	}

	@FXML
	private void RemovePaths() {
		web.getEngine().executeScript("document.deletePaths()");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		web.getEngine().load(this.getClass().getResource("index2.html").toExternalForm());

		ArrayList<String> spLocationList = new ArrayList<String>();
		ArrayList<String> PackList = new ArrayList<String>();

		for (int i = 0; i < SmartPostHandler.getSmartPosts().size() - 1; i++) {
			spLocationList.add(SmartPostHandler.getSmartPosts().get(i).cit);
		}
		PostChoiceBox.setItems(FXCollections.observableArrayList(spLocationList));
		PackageSelectionBox.setItems(FXCollections.observableArrayList(storage.GetPackages().toString()));

	}

}
