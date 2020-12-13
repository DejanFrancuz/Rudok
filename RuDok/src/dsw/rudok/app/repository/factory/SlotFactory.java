package dsw.rudok.app.repository.factory;

import dsw.rudok.app.repository.element.Slot;

import java.awt.*;

public abstract class SlotFactory {
    public Slot makeSlot(Point position, int index){
        Slot slot= create(position,index);
        return slot;
    }

    public void changeSlot(Slot novi,Slot stari){
        change(novi,stari);
    }

    public abstract Slot create(Point position,int index);
    public abstract void change(Slot novi,Slot stari);
}
