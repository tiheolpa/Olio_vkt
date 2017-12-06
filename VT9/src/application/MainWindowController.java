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

public class MainWindowController implements Initializable {
	@FXML TextField nameSearchField;
	@FXML TextField endTimeInput;
	@FXML TextField startTimeInput;
	@FXML TextField dateInput;
	@FXML ListView ListViewer;
	@FXML ChoiceBox<String> theaterChoiceBox;

	ObservableList<String> TheatreNames = FXCollections.observableArrayList();
	TheatreHandler handler = new TheatreHandler();

	@FXML
	public void listerButtonPress() {
		int SelectionID = theaterChoiceBox.getSelectionModel().getSelectedIndex();
		String TheatreID = Integer.toString(handler.GetTheatres().get(SelectionID).GetID());
		String date = dateInput.getText();
		String url = ("http://www.finnkino.fi/xml/Schedule/?area=" + TheatreID + "&dt=" + date); // p‰iv‰m‰‰r‰ muodossa pp.kk.vvvv
	}

	@FXML
	public void nameSearchPress() {

	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		for(int i = 1; i < handler.GetTheatres().size(); i++) {
			TheatreNames.add(handler.GetTheatres().get(i - 1).GetLocation());
		}
		theaterChoiceBox.setItems(TheatreNames);



	}
}