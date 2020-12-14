package dsw.rudok.app.repository.factory;

import dsw.rudok.app.repository.element.CircleSlot;
import dsw.rudok.app.repository.element.Slot;

import java.awt.*;

public class CircleFactory extends SlotFactory{

    @Override
    public Slot create(Point position, int index) {

        Slot slot= CircleSlot.createDefault(position,index);
        return slot;
    }


}
