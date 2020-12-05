package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.RectanglePainter;

import java.awt.*;
import java.awt.geom.Point2D;

public class RectangleDevice extends SlotDevice{


    public RectangleDevice(Dimension size, Point2D position) {
        super(size, position);
        devicePainter = new RectanglePainter(this);
    }
    public static SlotDevice createDefault(Point2D pos){
        Point2D position = (Point2D) pos.clone();

        RectangleDevice rectangleElement=new RectangleDevice(
                new Dimension(80,40),position);
        rectangleElement.setName("Rectangle");
        return rectangleElement;
    }

}
