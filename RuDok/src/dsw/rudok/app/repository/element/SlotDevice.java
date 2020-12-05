package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.DevicePainter;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class SlotDevice{
    public Dimension size;
    public Point2D position;
    public String name;

    public SlotDevice(Dimension size, Point2D position,String name) {
        this.name=name;
        this.size = size;
        this.position = position;
    }
    protected DevicePainter devicePainter;

    public SlotDevice(Dimension size, Point2D position) {
        this.size = size;
        this.position = position;
    }

    public DevicePainter getDevicePainter() {
        return devicePainter;
    }

    public void setDevicePainter(DevicePainter devicePainter) {
        this.devicePainter = devicePainter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
