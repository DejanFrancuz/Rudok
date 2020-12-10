package dsw.rudok.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SelectAction extends AbstractRudokAction{
    public SelectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("images/mouse_pointer.png"));
        putValue(NAME, "Select");
        putValue(SHORT_DESCRIPTION, "Select");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
