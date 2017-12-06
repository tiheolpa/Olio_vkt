package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class MainWindowController implements Initializable {
	@FXML TextField nameSearchField;
	@FXML TextField endTimeInput;
	@FXML TextField startTimeInput;
	@FXML TextField dateInput;
	@FXML ListView ListViewer;
	@FXML ChoiceBox<String> theaterChoiceBox;
	@FXML WebView webWindow;

	ObservableList<Theatre> Theatres = FXCollections.observableArrayList();
	ObservableList<String> TheatreNames = FXCollections.observableArrayList();
	for(int i = 1; i < Theatres.size(); i++) {
		TheatreNames.add(Theatres.get(i - 1));
	}

	@FXML
	public void listerButtonPress() {
		int SelectionID = theaterChoiceBox.getSelectionModel().getSelectedIndex();
		String TheatreID = Integer.toString(Theatres.get(SelectionID).GetID());
		String date = dateInput.getText();
		String url = ("http://www.finnkino.fi/xml/Schedule/?area=" + TheatreID + "&dt=" + date); // päivämäärä muodossa pp.kk.vvvv
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		webWindow.getEngine().load("TheatreAreas.xml");
		theaterChoiceBox.setItems();



	}
}