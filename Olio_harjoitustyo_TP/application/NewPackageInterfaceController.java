package application;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPackageInterfaceController implements Initializable {

    @FXML Button CreatePackageButton;
    @FXML Button CancelButton;
    @FXML RadioButton FirstClassButton;
    @FXML RadioButton SecondClassButton;
    @FXML RadioButton ThirdClassButton;
    @FXML CheckBox IsBreakableCheckbox;
    @FXML TextField NameField;
    @FXML TextField SizeFieldX;
    @FXML TextField SizeFieldY;
    @FXML TextField SizeFieldZ;
    @FXML TextField MassField;
    @FXML ChoiceBox<String> SenderCitySelector;
    @FXML ChoiceBox<String> RecieverCitySelector;
    @FXML ChoiceBox<String> SenderPostSelector;
    @FXML ChoiceBox<String> RecieverPostSelector;
    @FXML ChoiceBox<Item> ItemChoiceBox;

    ObservableList<Item> ItemList;
    Storage storage = Storage.getInstance();
    SmartPostHandler handler = SmartPostHandler.getInstance();
    ArrayList<SmartPost> SenderCityPosts = new ArrayList<SmartPost>();
    ArrayList<SmartPost> RecieverCityPosts = new ArrayList<SmartPost>();

    @FXML
    private void CreatePackageButtonPress() {

    	int StartSelection = SenderPostSelector.getSelectionModel().getSelectedIndex();
    	int EndSelection = RecieverPostSelector.getSelectionModel().getSelectedIndex();

		int priority;
		Item content;
		String senderCit = SenderCitySelector.getSelectionModel().getSelectedItem();
		String dest = RecieverCitySelector.getSelectionModel().getSelectedItem();
		double slat = SenderCityPosts.get(StartSelection).latitude;
		double slon = SenderCityPosts.get(StartSelection).longitude;
		double elat = RecieverCityPosts.get(EndSelection).latitude;
		double elon = RecieverCityPosts.get(EndSelection).longitude;

    	if(ItemChoiceBox.getSelectionModel().isEmpty() == true) {
    		String name = NameField.getText();
    		double sizex = Double.parseDouble(SizeFieldX.getText());
    		double sizey = Double.parseDouble(SizeFieldY.getText());
    		double sizez = Double.parseDouble(SizeFieldZ.getText());
    		double mass = Double.parseDouble(MassField.getText());
    		content = new Item(IsBreakableCheckbox.isSelected(), name, sizex, sizey, sizez, mass);
    	} else {
    		content = ItemChoiceBox.getSelectionModel().getSelectedItem();
    	}

        if(ThirdClassButton.isSelected() == true) {
        	priority = 3;
        	Package box = new PackageC3(content, senderCit, dest, slat, slon, elat, elon);
        	storage.addPackage(box);
        }
        else if (SecondClassButton.isSelected() == true) {
        	priority = 2;
        	Package box = new PackageC2(content, senderCit, dest, slat, slon, elat, elon);
        	storage.addPackage(box);
        }
        else if (FirstClassButton.isSelected() == true) {
        	priority = 1;
        	Package box = new PackageC1(content, senderCit, dest, slat, slon, elat, elon);
        	storage.addPackage(box);
        }

        Stage stage = (Stage) CreatePackageButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void CancelButtonPress() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void UpdateStartList() {
    	SenderCityPosts.clear();
    	SenderCityPosts.addAll(handler.SearchPostsFromCity(SenderCitySelector.getSelectionModel().getSelectedItem()));
    	ArrayList<String> PostNames = new ArrayList<String>();
    	for (int i = 0; i < SenderCityPosts.size(); i++) {
    		PostNames.add(SenderCityPosts.get(i).postoffice);
    	}
    	SenderPostSelector.setItems(FXCollections.observableArrayList(PostNames));
    }

    @FXML
    private void UpdateDestList() {
    	RecieverCityPosts.clear();
    	RecieverCityPosts.addAll(handler.SearchPostsFromCity(RecieverCitySelector.getSelectionModel().getSelectedItem()));
    	ArrayList<String> PostNames = new ArrayList<String>();
    	for (int i = 0; i < RecieverCityPosts.size(); i++) {
    		PostNames.add(RecieverCityPosts.get(i).postoffice);
    	}
    	RecieverPostSelector.setItems(FXCollections.observableArrayList(PostNames));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	ItemList.add(new Item(false, "Korttipakka", 50, 20, 30, 50));
		ItemChoiceBox.setItems(ItemList);

		SenderCitySelector.setItems(FXCollections.observableArrayList(handler.getCities()));
		RecieverCitySelector.setItems(FXCollections.observableArrayList(handler.getCities()));
    }

}
