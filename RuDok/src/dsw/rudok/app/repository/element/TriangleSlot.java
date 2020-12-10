package dsw.rudok.app.repository.element;

import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class TriangleSlot extends Slot{

    public TriangleSlot(String name, RuNode parent) {
        super(name, parent);
    }

    public TriangleSlot(Dimension size, Point2D position, Stroke stroke, Paint paint, String name) {
        super(size, position, stroke, paint, name);
    }
    public static Slot createDefault(Point position,int index){

        return null;
    }
}
