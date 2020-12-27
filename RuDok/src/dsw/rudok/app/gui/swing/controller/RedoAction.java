package dsw.rudok.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractRudokAction{
    public RedoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("images/redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
