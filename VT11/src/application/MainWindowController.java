package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class MainWindowController implements Initializable{
@FXML BorderPane MainBorder;

ShapeHandler handler = ShapeHandler.getInstance();
static Double sx;
static Double sy;
static Double ex;
static Double ey;
ArrayList<Line> lines = new ArrayList<Line>();


	@FXML
	public void WindowClicked(MouseEvent event) {
		Point circle = new Point(event.getSceneX(), event.getSceneY(), this);
		MainBorder.getChildren().add(circle.getCircle());
		handler.AddPntToList(circle);

	}
	public void PointClicked(Double x, Double y) {
		if (sx == null) {
			sx = x;
			sy = y;
		} else if (ex == null) {
			ex = x;
			ey = y;
			/*if(lines.isEmpty() != true) { //Tehtävän 11.4 viivanpoistokoodi. Kommentin poisto ottaa toimintaan.
				MainBorder.getChildren().removeAll((lines.get(0)));
				lines.remove(0);
			}*/

			Line newLine = new Line(sx, sy, ex, ey);
			MainBorder.getChildren().add(newLine);
			lines.add(newLine);
			handler.AddLnToList(newLine);
			sx = null;
			sy = null;
			ex = null;
			ey = null;
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
