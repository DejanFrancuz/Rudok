package dsw.rudok.app.gui.swing.controller;

import com.sun.tools.javac.Main;
import dsw.rudok.app.AppCore;
import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.repository.Page;

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

        if(((PageTab)MainFrame.getInstance().getjPanel()) == null){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.NOT_SELECTED_JPANEL);
        }
        else{
            ((PageTab)MainFrame.getInstance().getjPanel()).getPage().startRectangleState();
        }


    }
}
