package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.TrianglePainter;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class TriangleSlot extends Slot{


    public TriangleSlot(Dimension size, Point2D position, String name) {
        super(size, position, name);
        slotPainter=new TrianglePainter(this);
    }
    public static Slot createDefault(Point position,int index){
        TriangleSlot triangle= new TriangleSlot(new Dimension(50,50),position,
                "Triangle " + index);

        return triangle;
    }
}
