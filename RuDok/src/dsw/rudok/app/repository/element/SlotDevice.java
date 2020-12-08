package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.ElementPainter;
import dsw.rudok.app.gui.swing.view.painters.SlotDevicePainter;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class SlotDevice{
    public Stroke stroke;
    public Paint paint;
    public Dimension size;
    public Point2D position;
    public String name;

    public ElementPainter elementPainter;

    public SlotDevice(Dimension size, Point2D position,String name, Stroke stroke, Paint paint) {
        this.name=name;
        this.size = size;
        this.position = position;
        this.stroke = stroke;
        this.paint = paint;
    }
    protected SlotDevicePainter devicePainter;

    public SlotDevice(Dimension size, Point2D position) {
        this.size = size;
        this.position = position;
    }

    public SlotDevicePainter getDevicePainter() {
        return devicePainter;
    }

    public void setDevicePainter(SlotDevicePainter devicePainter) {
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

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
