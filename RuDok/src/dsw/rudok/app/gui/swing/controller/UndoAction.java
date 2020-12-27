package dsw.rudok.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractRudokAction{
    public UndoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("images/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
