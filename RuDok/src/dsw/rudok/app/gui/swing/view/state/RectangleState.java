package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.RectangleSlot;
import dsw.rudok.app.repository.element.SlotDevice;

import java.awt.*;
import java.awt.event.MouseEvent;

public class RectangleState extends State{
    private Page page;
    public RectangleState(Page page) {
        this.page = page;
    }

   /* public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){
            if (med.getSlotModel().getDeviceAtPosition(position)==-1){
                SlotDevice device = RectangleSlot.createDefault(position);
                med.getSlotModel().addSlodDevices(device);
            }
        }
    }*/
}
