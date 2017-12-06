package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MapInterfaceController implements Initializable {

	@FXML
	Button AddToMapButton;
	@FXML
	Button SendButton;
	@FXML
	Button NewPackageButton;
	@FXML
	Button UpdateButton;
	@FXML
	WebView web;

	@FXML
	private void AddToMapButtonPress() {

	}

	@FXML
	private void SendButtonPress() {

	}

	@FXML
	private void NewPackageButtonPress() {
		Stage packageWindow = new Stage();
		try {
			Parent page = FXMLLoader.load(getClass().getResource("NewPackageInterface.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	private void UpdateButtonPress() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		web.getEngine().load("index.html");

	}

}
