package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.CirclePainter;

import java.awt.*;
import java.awt.geom.Point2D;

public class CircleSlot extends SlotDevice{
    public CircleSlot(Dimension size, Point2D position) {
        super(size, position);
        devicePainter = new CirclePainter(this);
    }

    public static SlotDevice createDefault(Point2D pos){
        Point2D position = (Point2D) pos.clone();

        CircleSlot or=new CircleSlot(
                new Dimension(50,50),position);
        or.setName("Circle ");
        return or;
    }

}
