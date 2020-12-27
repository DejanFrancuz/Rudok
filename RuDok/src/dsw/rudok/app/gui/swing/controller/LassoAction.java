package dsw.rudok.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class LassoAction extends AbstractRudokAction {
    public LassoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/lasso1.png"));
        putValue(NAME, "Lasso");
        putValue(SHORT_DESCRIPTION, "Lasso");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
