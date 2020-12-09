package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.CircleSlot;
import dsw.rudok.app.repository.element.SlotDevice;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CircleState extends State{
    private Slot med;
    public CircleState(Slot md) {
        med = md;
    }

    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){
            if (med.getSlotModel().getDeviceAtPosition(position)==-1){
                SlotDevice device = CircleSlot.createDefault(position);
                med.getSlotModel().addSlodDevices(device);
            }


        }
    }
}
