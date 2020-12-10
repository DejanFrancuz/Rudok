package dsw.rudok.app.gui.swing.controller;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.Workspace;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public class ShareDocumentAction extends AbstractRudokAction{
    public ShareDocumentAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/shareDoc.png"));
        putValue(NAME, "Share document");
        putValue(SHORT_DESCRIPTION, "Share document");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getTree().shareDocument();


    }
}
