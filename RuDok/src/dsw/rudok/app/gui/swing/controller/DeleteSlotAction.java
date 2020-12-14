package dsw.rudok.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteSlotAction extends AbstractRudokAction{
    public DeleteSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("images/deleteSlot.png"));
        putValue(NAME, "Delete Slot");
        putValue(SHORT_DESCRIPTION, "Delete slot");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
