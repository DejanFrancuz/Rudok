package dsw.rudok.app.gui.swing.controller;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MoveAction extends AbstractRudokAction{
    public MoveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("images/move.png"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if((MainFrame.getInstance().getjPanel()) == null){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.NOT_SELECTED_JPANEL);
        }
        else{
            ((PageTab)MainFrame.getInstance().getjPanel()).getPage().startMoveState();
        }
    }
}
