package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.Slot;

public class GraphicSlotView extends SlotView implements ISubscriber {

    public GraphicSlotView(Slot slot) {
        super(slot);
    }

    @Override
    public void update(Object notif) {


    }
}
