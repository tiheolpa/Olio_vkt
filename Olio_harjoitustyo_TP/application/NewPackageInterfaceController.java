package application;


import java.net.URL;
import java.util.ResourceBundle;

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

    @FXML
    Button CreatePackageButton;
    @FXML
    Button CancelButton;
    @FXML
    RadioButton FirstClassButton;
    @FXML
    RadioButton SecondClassButton;
    @FXML
    RadioButton ThirdClassButton;
    @FXML
    CheckBox IsBreakableCheckbox;
    @FXML
    TextField NameField;
    @FXML
    TextField SizeFieldX;
    @FXML
    TextField SizeFieldY;
    @FXML
    TextField SizeFieldZ;
    @FXML
    TextField MassField;
    @FXML
    ChoiceBox SenderCitySelector;
    @FXML
    ChoiceBox RecieverCitySelector;
    @FXML
    ChoiceBox SenderAutomateSelector;
    @FXML
    ChoiceBox RecieverAutomateSelector;
    @FXML
    ChoiceBox<Item> ItemChoiceBox;

    ObservableList<Item> ItemList;
    Storage stor = new Storage(null);

    @FXML
    private void CreatePackageButtonPress() {
		int priority;
		Item content;
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
        }
        else if (SecondClassButton.isSelected() == true) {
        	priority = 2;
        }
        else if (FirstClassButton.isSelected() == true) {
        	priority = 1;
        }

        Package box = new Package(content, priority, senderCit, dest);
        stor.addPackage(box);
        Stage stage = (Stage) CreatePackageButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void CancelButtonPress() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	ItemList.add(new Item(false, "Korttipakka", 50, 20, 30, 50));
		ItemChoiceBox.setItems(ItemList);

    }

}
