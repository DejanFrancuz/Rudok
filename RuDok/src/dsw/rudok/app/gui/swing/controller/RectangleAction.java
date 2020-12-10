package dsw.rudok.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RectangleAction extends AbstractRudokAction{

    public RectangleAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("images/shape_rectangle.png"));
        putValue(NAME, "Rectangle");
        putValue(SHORT_DESCRIPTION, "Rectangle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
