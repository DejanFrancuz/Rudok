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

    public RectangleSlot(String name, RuNode parent) {
        super(name, parent);
    }

    public static Slot createDefault(Point position, int index){
        Paint fill = Color.BLACK;
        RectangleSlot rectangle= new RectangleSlot(new Dimension(100,50),position,
                "Rectangle " + index);
        return rectangle;
    }


    public static void changeSlotSelected(Slot novi,Slot stari){

        if(!novi.equals(stari)) {
            novi.getSlotPainter().setPaint(Color.CYAN);

            if (stari != null)
                stari.getSlotPainter().setPaint(Color.BLACK);
        }
    }

    public double calculateDistanceBetweenPointsWithPoint2D(double x1,double y1, double x2, double y2){
        return Point2D.distance(x1, y1, x2, y2);

    }

}
