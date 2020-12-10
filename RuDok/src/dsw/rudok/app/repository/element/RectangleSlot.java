package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.RectanglePainter;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class RectangleSlot extends Slot{



    public RectangleSlot( Dimension size, Point2D position,Stroke stroke, Paint paint,String name) {
        super(size,position,stroke,paint,name);
        slotPainter = new RectanglePainter(this);
    }

    public RectangleSlot(String name, RuNode parent) {
        super(name, parent);
    }
}
