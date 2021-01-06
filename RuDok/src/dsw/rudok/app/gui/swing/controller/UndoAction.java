package dsw.rudok.app.gui.swing.controller;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;

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
       PageTab view=(PageTab) MainFrame.getInstance().getjPanel();
        view.getPage().getCommandManager().undoCommand();

    }
}
