package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.controller.JTabbedPaneCloseButton;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.Slot;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SlotTab extends JPanel implements ISubscriber {

    private String slotName;
    private RuNode parent;
    private Slot slot;
    private  JPanel panCenter;



    public SlotTab(Slot slot){
        this.slot = slot;
        this.panCenter = new JPanel();

        this.setLayout(new BorderLayout());
        slot.addSubs(this);

        Border redline = BorderFactory.createLineBorder(Color.GRAY);
        TitledBorder title = BorderFactory.createTitledBorder(redline, slot.toString());
        title.setTitlePosition(4);
        title.setTitleJustification(2);
        setBorder(title);

        add(this.panCenter);



    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }


    @Override
    public void update(Object notif) {

    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
