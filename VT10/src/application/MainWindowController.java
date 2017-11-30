package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class MainWindowController implements Initializable{
	@FXML TextField nameSearchField;
	@FXML TextField endTimeInput;
	@FXML TextField startTimeInput;
	@FXML TextField dateInput;
	@FXML private WebView webWindow;


	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		webWindow.getEngine().load("TheatreAreas.xml");



	}
}
