package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.TrianglePainter;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class TriangleSlot extends Slot{

    public TriangleSlot(String name, RuNode parent) {
        super(name, parent);
    }

    public TriangleSlot(Dimension size, Point2D position, String name) {
        super(size, position, name);
        slotPainter=new TrianglePainter(this);
    }
    public static Slot createDefault(Point position,int index){
        Paint fill = Color.BLACK;
        TriangleSlot triangle= new TriangleSlot(new Dimension(50,50),position,
                "Triangle " + index);

        return triangle;
    }

    public static void changeSlotSelected(Slot novi, Slot stari) {

        if(!novi.equals(stari)) {
            novi.getSlotPainter().setPaint(Color.CYAN);

            if (stari != null)
                stari.getSlotPainter().setPaint(Color.BLACK);
        }
    }
}
