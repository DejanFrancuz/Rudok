package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.CirclePainter;
import dsw.rudok.app.gui.swing.view.painters.RectanglePainter;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class CircleSlot extends Slot{
    public CircleSlot( Dimension size, Point2D position,String name) {
        super(size,position,name);
        slotPainter = new CirclePainter(this);
    }
    public static Slot createDefault(Point position, int index){
        CircleSlot circle= new CircleSlot(new Dimension(50,50),position,
                "Circle " + index);
        return circle;
    }
}