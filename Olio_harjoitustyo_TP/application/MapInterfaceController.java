package application;
//Map controller class. Has a role of main class.

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MapInterfaceController implements Initializable {

	@FXML TextArea InfoField;
	@FXML Button AddToMapButton;
	@FXML Button SendButton;
	@FXML Button NewPackageButton;
	@FXML Button RemovePathsButton;
	@FXML ChoiceBox<String> CityChoiceBox;
	@FXML ChoiceBox<String> PackageSelectionBox;
	@FXML WebView web;

	Storage storage = Storage.getInstance();
	SmartPostHandler postHandler = SmartPostHandler.getInstance();

	ArrayList<String> PackList = new ArrayList<String>();
	ArrayList<Package> BoxList = new ArrayList<Package>();

	@FXML
	private void AddToMapButtonPress() { //this method creates markers on the map to indicate the positions of smartposts
		ArrayList<SmartPost> CitySmartPosts = new ArrayList<SmartPost>();
		CitySmartPosts.addAll(postHandler.SearchPostsFromCity(CityChoiceBox.getSelectionModel().getSelectedItem()));
		for(SmartPost selectedPost: CitySmartPosts) {
			String address = selectedPost.adr;
			String postalcode = Integer.toString(selectedPost.postalcode);
			String postoffice = selectedPost.postoffice;
			String avalibility = selectedPost.avalibility;
			String city = selectedPost.cit;
			String fullAdress = "'" + address + ", " + postalcode + " " + city + "'";
			String arguments = fullAdress + ", '" + postoffice + ", Auki " + avalibility + "', '" + "blue" + "'";
			web.getEngine().executeScript("document.goToLocation" + "(" + arguments + ")");
		}

	}

	@FXML
	private void SendButtonPress() { //Sends package to destination
		if(!PackageSelectionBox.getSelectionModel().isEmpty()) {
			if(!storage.GetPackage(PackageSelectionBox.getSelectionModel().getSelectedIndex()).isInDestination) { //check if package is already in destination
				int selection = PackageSelectionBox.getSelectionModel().getSelectedIndex();
				Package currentPackage = storage.GetPackage(selection);

				ArrayList<Double> coords = new ArrayList<Double>(); //collect start and end coordinates for sending package
				coords.add(currentPackage.currentPost.latitude);
				coords.add(currentPackage.currentPost.longitude);
				coords.add(currentPackage.destination.latitude);
				coords.add(currentPackage.destination.longitude);

				String color = "red";
				int PackageClass = currentPackage.priority;

				web.getEngine().executeScript("document.createPath(" + coords + ", '" + color + "', " + PackageClass + ")");

				if(currentPackage.breaksItems == true) { //Break contents if package class is 1 or 3
					 int ItemsBroken = currentPackage.breakContents();
					 if(ItemsBroken > 0) {
						 InfoField.appendText("\nPaketin sis‰ll‰ hajosi jotain...");
					 }
				}
				InfoField.appendText("\nPaketti l‰hetetty: " + currentPackage.currentPost.postoffice + "->" + currentPackage.destination.postoffice);
				currentPackage.currentPost = currentPackage.destination;
				currentPackage.isInDestination = true;
				updatePackages();
			}
			else {
				InfoField.appendText("\nPaketti on jo p‰‰m‰‰r‰ss‰");
			}
		}
		else {
			InfoField.appendText("\nValitse ensin paketti");
		}
	}

	@FXML
	private void CreatePackageButtonPress() { //Opens a new window to create new package

		try {
			Stage NewPackageView = new Stage();
			Parent page = FXMLLoader.load(getClass().getResource("NewPackageInterface.fxml"));
			Scene scene = new Scene(page);

			NewPackageView.setScene(scene);
			NewPackageView.setResizable(false);
			NewPackageView.setTitle("Luo uusi paketti");
			NewPackageView.show();

			NewPackageView.setOnHidden(new EventHandler<WindowEvent>(){
				@Override
				public void handle(WindowEvent arg0) {
					// TODO Auto-generated method stub
					updatePackages();
				}
			    });

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void updatePackages() { //Updates the package choice box
		ArrayList<String> PackNameList = new ArrayList<String>();

		for (int i = 0; i < storage.GetPackages().size(); i++) {
			String boxDescription;
			String sendLoc = storage.GetPackages().get(i).senderPost.cit;
			String destLoc = storage.GetPackages().get(i).destination.cit;
			String cl = String.valueOf(storage.GetPackages().get(i).priority);
			String isSent;
			if(storage.GetPackages().get(i).isInDestination){
				isSent = "Kyll‰";
			} else {
				isSent = "Ei";
			}
			boxDescription = i + 1 + ". L‰hetyskaupunki: " + sendLoc + " P‰‰m‰‰r‰: " + destLoc + " Luokka: " + cl + " L‰hetetty? " + isSent;
			PackNameList.add(boxDescription);
		}

		PackageSelectionBox.setItems(FXCollections.observableArrayList(PackNameList));
		InfoField.appendText("\nPakettilista p‰ivitetty");
	}

	@FXML
	private void RemovePaths() { //removes paths from the map
		web.getEngine().executeScript("document.deletePaths()");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		web.getEngine().load(this.getClass().getResource("index.html").toExternalForm());

		ArrayList<String> CityList = new ArrayList<String>();

		for (int i = 0; i < postHandler.getCities().size(); i++) {
			CityList.add(postHandler.getCities().get(i));
		}

		CityChoiceBox.setItems(FXCollections.observableArrayList(CityList));
		updatePackages();

	}

}
