package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
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
	SmartPostHandler postHandler = SmartPostHandler.getInstance();
	ArrayList<String> PackList = new ArrayList<String>();
	ArrayList<Package> BoxList = new ArrayList<Package>();

	@FXML
	private void AddToMapButtonPress() {
		int Selection = PostChoiceBox.getSelectionModel().getSelectedIndex();
		SmartPost selectedPost = postHandler.getSmartPosts().get(Selection);
		String address = selectedPost.adr;
		String postalcode = Integer.toString(selectedPost.postalcode);
		String postoffice = selectedPost.postoffice;
		String avalibility = selectedPost.avalibility;
		String city = selectedPost.cit;
		String fullAdress = "'" + address + ", " + postalcode + " " + city + "'";
		String arguments = fullAdress + ", '" + postoffice + "', '" + "blue" + "'";
		web.getEngine().executeScript("document.goToLocation" + "(" + arguments + ")");
	}

	@FXML
	private void SendButtonPress() {
		int selection = PackageSelectionBox.getSelectionModel().getSelectedIndex();
		Package currentPackage = storage.GetPackage(selection);

		ArrayList<Double> coords = new ArrayList<Double>();
		coords.add(currentPackage.sendLat);
		coords.add(currentPackage.sendLon);
		coords.add(currentPackage.endLat);
		coords.add(currentPackage.endLon);

		String color = "red";
		int priority = currentPackage.priority;

		web.getEngine().executeScript("document.createPath(" + coords + ", '" + color + "', " + priority + ")");
		if(priority == 1) {
			 PackageC1 c1pack = (PackageC1)currentPackage;
			 c1pack.breakContents();
		}

		currentPackage.isInDestination = true;

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

	private void updatePackages() {

		ArrayList<String> PackNameList = new ArrayList<String>();
		for (int i = 0; i < storage.GetPackages().size(); i++) {
			String boxDescription;
			String sendLoc = storage.GetPackages().get(i).senderCity;
			String destLoc = storage.GetPackages().get(i).senderCity;
			boxDescription = i + ". Lähetyskaupunki: " + sendLoc + " Päämäärä: " + destLoc;
			PackNameList.add(boxDescription);
		}

		PackageSelectionBox.setItems(FXCollections.observableArrayList(PackNameList));
	}

	@FXML
	private void UpdateButtonPress() {
		updatePackages();
	}

	@FXML
	private void RemovePaths() {
		web.getEngine().executeScript("document.deletePaths()");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		web.getEngine().load(this.getClass().getResource("index.html").toExternalForm());

		ArrayList<String> spLocationList = new ArrayList<String>();

		for (int i = 0; i < postHandler.getSmartPosts().size() - 1; i++) {
			spLocationList.add(postHandler.getSmartPosts().get(i).postoffice);
		}

		PostChoiceBox.setItems(FXCollections.observableArrayList(spLocationList));
		updatePackages();

	}

}
