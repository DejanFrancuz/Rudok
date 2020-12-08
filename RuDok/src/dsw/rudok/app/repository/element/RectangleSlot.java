package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.RectanglePainter;

import java.awt.*;
import java.awt.geom.Point2D;

public class RectangleSlot extends SlotDevice{


    public RectangleSlot(Dimension size, Point2D position) {
        super(size, position);
        devicePainter = new RectanglePainter(this);
        setStroke(new BasicStroke());

    }
    public static SlotDevice createDefault(Point2D pos){
        Point2D position = (Point2D) pos.clone();

        RectangleSlot rectangleElement=new RectangleSlot(
                new Dimension(80,40),position);
        rectangleElement.setName("Rectangle");
        return rectangleElement;
    }

}
