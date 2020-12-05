package dsw.rudok.app.repository.element;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class DiagramDevice extends DiagramElement{
    public Dimension size;
    public Point2D position;

    public DiagramDevice(Dimension size, Point2D position,String name) {
        super(name);
        this.size = size;
        this.position = position;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
}
