package application;

import java.util.ArrayList;

import javafx.scene.shape.Line;

public final class ShapeHandler {
    private static final ShapeHandler INSTANCE = new ShapeHandler();
    private ArrayList<Point> PointList = new ArrayList<Point>();
    private ArrayList<Line> LineList = new ArrayList<Line>();

    public void AddPntToList(Point pnt) {
    	PointList.add(pnt);
    }

    public void AddLnToList(Line ln) {
    	LineList.add(ln);
    }

    private ShapeHandler() {}

    public static ShapeHandler getInstance() {
        return INSTANCE;
    }
}
