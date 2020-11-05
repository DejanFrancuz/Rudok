package dsw.rudok.app.gui.swing.controller;


import com.sun.tools.javac.Main;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.*;
import dsw.rudok.app.repository.node.RuNode;

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
        putValue(SMALL_ICON, loadIcon("images/delete_1.png"));
        putValue(NAME, "Delete Node");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        if(childNodeView == null){
            return;
        }
        //RuNode childNodeModel = (RuNode) childNodeView.getUserObject();
        if(childNodeView.isRoot()){
            return;
        }
        childNodeView.removeFromParent();
        MainFrame.getInstance().getWorkspaceTree().updateUI();

    }
}