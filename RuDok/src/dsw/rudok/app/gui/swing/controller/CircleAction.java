package dsw.rudok.app.gui.swing.controller;

import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;



public class CircleAction extends AbstractRudokAction{


    public CircleAction() {
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.SHIFT_MASK));
            putValue(SMALL_ICON, loadIcon("images/shape_circle.png"));
            putValue(NAME, "Circle");
            putValue(SHORT_DESCRIPTION, "Circle");
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PageTab) MainFrame.getInstance().getjPanel()).getPage().startCircleState();
    }
}
