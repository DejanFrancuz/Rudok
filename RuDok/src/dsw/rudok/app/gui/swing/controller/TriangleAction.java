package dsw.rudok.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class TriangleAction extends AbstractRudokAction{
    public TriangleAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("images/triangle.png"));
        putValue(NAME, "Triangle");
        putValue(SHORT_DESCRIPTION, "Triangle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
