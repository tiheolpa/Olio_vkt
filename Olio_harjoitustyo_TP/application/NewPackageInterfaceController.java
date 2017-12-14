package application;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class NewPackageInterfaceController implements Initializable {

	@FXML Label errorLabel;
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
    @FXML ChoiceBox<String> ItemChoiceBox;
    @FXML WebView web;

    ArrayList<Item> ItemList = new ArrayList<Item>();
    Storage storage = Storage.getInstance();
    SmartPostHandler handler = SmartPostHandler.getInstance();
    ArrayList<SmartPost> SenderCityPosts = new ArrayList<SmartPost>();
    ArrayList<SmartPost> RecieverCityPosts = new ArrayList<SmartPost>();

    @FXML
    private void CreatePackageButtonPress() {
        Stage stage = (Stage) CreatePackageButton.getScene().getWindow();

    	int StartSelection = SenderPostSelector.getSelectionModel().getSelectedIndex();
    	int EndSelection = RecieverPostSelector.getSelectionModel().getSelectedIndex();
    	System.out.println(StartSelection + EndSelection);

		int priority;
		Item content;
		String senderCit = SenderCityPosts.get(StartSelection).cit;
		String dest = RecieverCityPosts.get(EndSelection).cit;

		ArrayList<Double> cr = new ArrayList<Double>();
		cr.add(SenderCityPosts.get(StartSelection).latitude);
		cr.add(SenderCityPosts.get(StartSelection).longitude);
		cr.add(RecieverCityPosts.get(EndSelection).latitude);
		cr.add(RecieverCityPosts.get(EndSelection).longitude);
		String cl = "red";
		int pr = 1;
		double distance = 100;
		//double distance = (double)web.getEngine().executeScript("document.createPath(" + cr + ", '" + cl + "', " + pr + ")");

    	if(ItemChoiceBox.getSelectionModel().isEmpty() == true) {
    		String name = NameField.getText();
    		double sizex = Double.parseDouble(SizeFieldX.getText());
    		double sizey = Double.parseDouble(SizeFieldY.getText());
    		double sizez = Double.parseDouble(SizeFieldZ.getText());
    		double mass = Double.parseDouble(MassField.getText());
    		content = new Item(IsBreakableCheckbox.isSelected(), name, sizex, sizey, sizez, mass);
    	} else {
    		int selection = ItemChoiceBox.getSelectionModel().getSelectedIndex();
    		content = ItemList.get(selection);
    	}

    	double size = content.getVolume();

        if(ThirdClassButton.isSelected() == true) {
        	if(size < 800){
        		priority = 3;
        		Package box = new PackageC3(content, senderCit, dest, cr.get(0), cr.get(1), cr.get(2), cr.get(3));
        		storage.addPackage(box);
        		stage.close();
        	} else {
        		errorLabel.setText("Liian suuri paketti");
        	}
        }
        else if (SecondClassButton.isSelected() == true) {
        	if(size < 800) {
        		priority = 2;
        		Package box = new PackageC2(content, senderCit, dest, cr.get(0), cr.get(1), cr.get(2), cr.get(3));
        		storage.addPackage(box);
        		stage.close();
        	} else {
        		errorLabel.setText("Liian suuri paketti");
        	}
        }
        else if (FirstClassButton.isSelected() == true) {
        	priority = 1;
        	if(distance < 150 && size < 800) {
            	Package box = new PackageC1(content, senderCit, dest, cr.get(0), cr.get(1), cr.get(2), cr.get(3));
            	storage.addPackage(box);
            	stage.close();
        	} else {
        		errorLabel.setText("Liian suuri paketti tai liian pitkä kuljetusmatka");
        	}
        }

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
    	ItemList.add(new Item(true, "Lasipulloja", 1000, 500, 500, 5000));
    	ItemList.add(new Item(false, "Aikakausilehtisarja", 200, 500, 500, 1000));
    	ItemList.add(new Item(false, "Tulostin", 300, 300, 400, 2000));

    	ArrayList<String> ItemNameList = new ArrayList<String>();
    	for(int i = 0; i < ItemList.size(); i++) {
        	ItemNameList.add(ItemList.get(i).getName());
    	}

		ItemChoiceBox.setItems(FXCollections.observableArrayList(ItemNameList));
		SenderCitySelector.setItems(FXCollections.observableArrayList(handler.getCities()));
		RecieverCitySelector.setItems(FXCollections.observableArrayList(handler.getCities()));

    }

}
