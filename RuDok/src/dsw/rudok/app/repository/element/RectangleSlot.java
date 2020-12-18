package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.RectanglePainter;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class RectangleSlot extends Slot{



    public RectangleSlot( Dimension size, Point2D position,String name) {
        super(size,position,name);
        slotPainter = new RectanglePainter(this);
    }


    public static Slot createDefault(Point position, int index){
        RectangleSlot rectangle= new RectangleSlot(new Dimension(100,50),position,
                "Rectangle " + index);
        return rectangle;
    }


}
