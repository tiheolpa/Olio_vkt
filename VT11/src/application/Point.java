package application;



import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class Point {

	public Circle pnt = new Circle();

	public Point(double x, double y, MainWindowController controller) {
		pnt = new Circle(x, y, 5);
		pnt.setOnMousePressed(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) { //handler hiiren klikkaukselle
		        System.out.println("Hei! Olen piste!");
		    	controller.PointClicked(pnt.getCenterX(), pnt.getCenterY());
		    }
		});
	}
	public Circle getCircle() {
		return pnt;
	}
}
