package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class MainWindowController implements Initializable{
	@FXML TextField addressBar;
	@FXML Button refreshButton;
	@FXML Button nextButton;
	@FXML Button previousButton;
	@FXML private WebView webWindow;

	private int current = 1;
	private ArrayList<String> addressHistory = new ArrayList<String>();

	@FXML
	public void loadButtonPress() {
		addressHistory.add(addressBar.getText());
		if(addressHistory.size() > 10) {
			addressHistory.remove(0);
		}
		webWindow.getEngine().load(addressBar.getText());
		current = addressHistory.size();
	}

	@FXML
	public void refreshButtonPress() {
		webWindow.getEngine().load(addressBar.getText());
	}

	@FXML
	public void nextButtonPress() {
		if(current != addressHistory.size()) {
			addressBar.setText(addressHistory.get(current + 1));
			webWindow.getEngine().load(addressHistory.get(current + 1));
		}
	}

	@FXML
	public void previousButtonPress() {
		if(addressHistory.isEmpty() != true) {
			addressBar.setText(addressHistory.get(current - 1));
			webWindow.getEngine().load(addressHistory.get(current - 1));

		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		webWindow.getEngine().load("index2.html");



	}
}
