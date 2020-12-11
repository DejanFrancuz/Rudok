package dsw.rudok.app.repository.slotFactory;

import dsw.rudok.app.repository.element.CircleSlot;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.TriangleSlot;

import java.awt.*;

public class CircleFactory extends SlotFactory{

    @Override
    public Slot create(Point position, int index) {
        Slot slot= CircleSlot.createDefault(position,index);
        return slot;
    }
}
