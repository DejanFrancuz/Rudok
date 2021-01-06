package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.Slot;

import javax.swing.*;

public abstract class SlotView extends JDialog implements ISubscriber {
    private Slot slot;


    public SlotView(Slot slot){
        this.slot = slot;
        this.slot.addSubs(this);

    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
