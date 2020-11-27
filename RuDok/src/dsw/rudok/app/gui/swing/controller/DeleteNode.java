package dsw.rudok.app.gui.swing.controller;


import com.sun.tools.javac.Main;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.*;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteNode extends AbstractRudokAction {

    public DeleteNode() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/Delete.png"));
        putValue(NAME, "Delete Node");
        putValue(SHORT_DESCRIPTION, "Delete");
    }


    @Override
    public void actionPerformed(ActionEvent e){
        RuTreeItem item= (RuTreeItem)  MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        MainFrame.getInstance().getTree().removeNode(item);

    }

}