package dsw.rudok.app.repository.slotFactory;

import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.TriangleSlot;

import java.awt.*;

public class TriangleFactory extends SlotFactory{

    @Override
    public Slot create(Point position, int index) {
        Slot slot= TriangleSlot.createDefault(position,index);
        return slot;
    }
}
