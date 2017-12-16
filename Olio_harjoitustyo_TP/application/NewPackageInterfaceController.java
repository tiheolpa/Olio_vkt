package application;
//Package creation interface class

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class NewPackageInterfaceController implements Initializable {

    @FXML TextArea errorArea;
    @FXML Button CreatePackageButton;
    @FXML Button CancelButton;
    @FXML RadioButton FirstClassButton;
    @FXML RadioButton SecondClassButton;
    @FXML RadioButton ThirdClassButton;
    @FXML RadioButton PremadeRadioButton;
    @FXML RadioButton NewRadioButton;
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

    WebView web = new WebView();

    Storage storage = Storage.getInstance();
    SmartPostHandler handler = SmartPostHandler.getInstance();

    ArrayList<Item> ItemList = new ArrayList<Item>();
    ArrayList<SmartPost> SenderCityPosts = new ArrayList<SmartPost>();
    ArrayList<SmartPost> RecieverCityPosts = new ArrayList<SmartPost>();

    //Package object dummies for getting max sizes and distances
    Item dummyItem = new Item(false, "dummy", 0, 0, 0, 0);
    PackageC1 p1dummy = new PackageC1(dummyItem, handler.getSmartPosts().get(0), handler.getSmartPosts().get(1));
    PackageC2 p2dummy = new PackageC2(dummyItem, handler.getSmartPosts().get(0), handler.getSmartPosts().get(1));
    PackageC3 p3dummy = new PackageC3(dummyItem, handler.getSmartPosts().get(0), handler.getSmartPosts().get(1));

    @FXML
    private void CreatePackageButtonPress() {//This method creates the package, if the fields are filled.
        if (CheckFields() == true) {
            Stage stage = (Stage)CreatePackageButton.getScene().getWindow();

            int StartSelection = SenderPostSelector.getSelectionModel().getSelectedIndex();
            int EndSelection = RecieverPostSelector.getSelectionModel().getSelectedIndex();
            SmartPost senderCit = SenderCityPosts.get(StartSelection);
            SmartPost dest = RecieverCityPosts.get(EndSelection);

            int classSelection = -1;
            Package SelectedDummy = null;

            Item content = null;

            double distance = handler.getDistance(SenderCityPosts.get(StartSelection), RecieverCityPosts.get(EndSelection), web);

            Boolean fieldXempty = SizeFieldX.getText().isEmpty();
            Boolean fieldYempty = SizeFieldY.getText().isEmpty();
            Boolean fieldZempty = SizeFieldZ.getText().isEmpty();
            Boolean fieldMassempty = MassField.getText().isEmpty();

            if(NewRadioButton.isSelected() && !fieldXempty && !fieldYempty && !fieldZempty && !fieldMassempty) {
                String name = NameField.getText();
                double sizex = Double.parseDouble(SizeFieldX.getText());
                double sizey = Double.parseDouble(SizeFieldY.getText());
                double sizez = Double.parseDouble(SizeFieldZ.getText());
                double mass = Double.parseDouble(MassField.getText());
                content = new Item(IsBreakableCheckbox.isSelected(), name, sizex, sizey, sizez, mass);
            } else if(ItemChoiceBox.getSelectionModel().isEmpty() == false && PremadeRadioButton.isSelected()) {
                int selection = ItemChoiceBox.getSelectionModel().getSelectedIndex();
                content = ItemList.get(selection);
            } else {
                errorArea.setText("Kunnollinen esineen valinta puuttuu");
            }

            if(content != null) {
                double size = content.getVolume();
                if(ThirdClassButton.isSelected() == true) {
                    classSelection = 2;
                    SelectedDummy = p3dummy;
                }
                else if (SecondClassButton.isSelected() == true) {
                    classSelection = 1;
                    SelectedDummy = p2dummy;
                }
                else if (FirstClassButton.isSelected() == true) {
                    classSelection = 0;
                    SelectedDummy = p1dummy;
                } else {
                    errorArea.setText("Valitse luokka ensin");
                }

                if(SelectedDummy != null && classSelection != -1) { //Create package if item content has been created
                    if(distance <= SelectedDummy.maxDistance) {
                        if(size <= SelectedDummy.maxSize) {
                            ArrayList<Package> PackageClassArray = new ArrayList<Package>();
                            PackageClassArray.add(new PackageC1(content, senderCit, dest));
                            PackageClassArray.add(new PackageC2(content, senderCit, dest));
                            PackageClassArray.add(new PackageC3(content, senderCit, dest));

                            PackageClassArray.get(classSelection).currentPost = SenderCityPosts.get(StartSelection);
                            storage.addPackage(PackageClassArray.get(classSelection));
                            stage.close();
                        } else {
                            errorArea.setText("Liian suuri sisältö (nykyinen: " + size + "/" + p1dummy.maxSize + "cm^3)");
                        }
                    } else {
                        errorArea.setText("Liian pitkä kuljetusmatka (nykyinen: " + distance + "/" + p1dummy.maxDistance + "km)");
                    }
                }
            }
        }
    }

    private Boolean CheckFields() { //Checks if the proper fields have been selected to avoid errors.
        Boolean IsEmptyFields = true;
        if(SenderPostSelector.getSelectionModel().getSelectedIndex() == -1 || RecieverPostSelector.getSelectionModel().getSelectedIndex() == -1) {
            IsEmptyFields = false;
        }
        return IsEmptyFields;
    }

    @FXML
    private void CancelButtonPress() { //Cancel button
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void InfoButtonPress() { //Opens window which shows information about package classes
        try {
            Stage InfoView = new Stage();
            Parent page = FXMLLoader.load(getClass().getResource("InfoWindow.fxml"));
            Scene scene = new Scene(page);

            InfoView.setScene(scene);
            InfoView.setResizable(false);
            InfoView.setTitle("Tietoa pakettiluokista");
            InfoView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void UpdateStartList() { //updates sender smartpost selection box
        SenderCityPosts.clear();
        SenderCityPosts.addAll(handler.SearchPostsFromCity(SenderCitySelector.getSelectionModel().getSelectedItem()));
        ArrayList<String> PostNames = new ArrayList<String>();
        for (int i = 0; i < SenderCityPosts.size(); i++) {
            PostNames.add(SenderCityPosts.get(i).postoffice);
        }
        SenderPostSelector.setItems(FXCollections.observableArrayList(PostNames));
    }

    private void UpdateDestList() { //Updates destination smartpost selection box
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

        web.getEngine().load(this.getClass().getResource("index.html").toExternalForm());

        ItemList.add(new Item(false, "Korttipakka", 5, 2, 3, 50));
        ItemList.add(new Item(true, "Lasipulloja", 50, 50, 50, 5000));
        ItemList.add(new Item(false, "Aikakausilehtisarja", 20, 50, 50, 1000));
        ItemList.add(new Item(false, "Tulostin", 30, 30, 40, 2000));

        ArrayList<String> ItemNameList = new ArrayList<String>();
        for(int i = 0; i < ItemList.size(); i++) {
            ItemNameList.add(ItemList.get(i).getName()); //Fill item selection box with premade items.
        }

        ItemChoiceBox.setItems(FXCollections.observableArrayList(ItemNameList));
        SenderCitySelector.setItems(FXCollections.observableArrayList(handler.getCities()));
        RecieverCitySelector.setItems(FXCollections.observableArrayList(handler.getCities()));

        //Listeners to listen city selection box changes. Triggers the list update methods.
        SenderCitySelector.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value) {
                SenderCitySelector.getSelectionModel().select((int)new_value);
                UpdateStartList();
            }
        });

        RecieverCitySelector.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value) {
                RecieverCitySelector.getSelectionModel().select((int)new_value);
                UpdateDestList();
            }
        });

    }

}
