package dsw.rudok.app.repository;

import dsw.rudok.app.repository.element.Slot;

import java.awt.geom.Point2D;

public interface SlotInt {
    public abstract void transform(Slot slot, String s, Point2D position);
}
