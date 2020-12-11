package dsw.rudok.app.repository.slotFactory;

import dsw.rudok.app.repository.element.Slot;

import java.awt.*;

public abstract class SlotFactory {
    public Slot makeSlot(Point position, int index){
        Slot slot= create(position,index);
        return slot;
    }
    public abstract Slot create(Point position,int index);
}
