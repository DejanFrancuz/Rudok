package dsw.rudok.app.repository.factory;

import dsw.rudok.app.repository.element.RectangleSlot;
import dsw.rudok.app.repository.element.Slot;

import java.awt.*;

public class RectangleFactory extends SlotFactory{

    @Override
    public Slot create(Point position,int index) {

        Slot slot= RectangleSlot.createDefault(position,index);
        return slot;
    }

    @Override
    public void change(Slot novi,Slot stari) {
        RectangleSlot.changeSlotSelected(novi, stari);
    }


}
