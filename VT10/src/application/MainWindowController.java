package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class MainWindowController implements Initializable{
	@FXML TextField addressBar;
	@FXML WebView webWindow;

	ArrayList<String> history = new ArrayList<String>();
	int currentID = 0; //id muuttuja m‰‰r‰‰, mill‰ sivuhistorian sivulla ollaan


	@FXML
	private void loadButtonPress() {
		webWindow.getEngine().load("http://" + addressBar.getText());

	}

	@FXML
	private void refreshButtonPress() {
		webWindow.getEngine().reload();
	}

	@FXML
	private void nextButtonPress() {

		if  (currentID < history.size()-1){
			currentID = currentID + 1;
			webWindow.getEngine().load(history.get(currentID));
			addressBar.setText(history.get(currentID));
		}
	}

	@FXML
	private void previousButtonPress() {
		if((history.size() > 1) && (currentID >= 1)) {
			System.out.println("Current ID " + currentID);
			System.out.println("Historian koko " +history.size());

			if(history.size() == currentID) {
				currentID--;
			}
			currentID = currentID - 1;
			webWindow.getEngine().load(history.get(currentID));
			System.out.println(history.get(currentID));
			addressBar.setText(history.get(currentID));
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		webWindow.getEngine().load(getClass().getResource("index2.html").toExternalForm());
		webWindow.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
		     @Override
		     public void changed(ObservableValue ov, State oldState, State newState) { //Menetelm‰ sivun vaihtumisen havaitsemiseen saatu osoitteesta https://stackoverflow.com/questions/32486758/detect-url-changes-in-javafx-webview

		           if (newState == Worker.State.SUCCEEDED) {
		        	   if(currentID == history.size()){

		        		   history.add(webWindow.getEngine().getLocation()); //NEW URL
		        		   currentID = history.size();
		        	   }
		                //
		         		if(history.size() > 10) {
		        			history.remove(0);
		        		}
		         		addressBar.setText(webWindow.getEngine().getLocation());
		         		//System.out.println(history.get(currentID));
		        		//currentID = history.size();
		           }

		     }
		});

	}
}
