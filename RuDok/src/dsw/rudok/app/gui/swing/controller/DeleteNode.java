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
        putValue(SMALL_ICON, loadIcon("images/delete_1.png"));
        putValue(NAME, "Delete Node");
        putValue(SHORT_DESCRIPTION, "Delete");
    }
   /* @Override

    public void actionPerformed(ActionEvent e){
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) MainFrame.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
        if(parent!=null){
            int insIndex = parent.getIndex(node.getPreviousSibling());
            MainFrame.getInstance().getWorkspace().setSelectionPath(null);
            MainFrame.getInstance().getTreeModel().removeNodeFromParent(node);
            MainFrame.getInstance().getTreeModel().insertNodeInto(node,(MutableTreeNode)parent,insIndex);
            MainFrame.getInstance().getTreeModel().reload();
          //  MainFrame.getInstance().getWorkspaceTree().updateUI();

        }
    }
    */

@Override
    public void actionPerformed(ActionEvent e){
    RuTreeItem item =(RuTreeItem)  MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
    MainFrame.getInstance().getTree().removeNode(item);
    MainFrame.getInstance().getWorkspace().updateUI();
}


/*
    @Override
    public void actionPerformed(ActionEvent e){
        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) MainFrame.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent();
        if(childNode !=null || !childNode.isRoot()){
            DefaultTreeModel model=(DefaultTreeModel) MainFrame.getInstance().getWorkspaceTree().getModel();
            // ((RuTreeItem)treeView.getLastSelectedPathComponent()).removeFromParent();
            //MainFrame.getInstance().getTreeModel().removeNodeFromParent(dtm);

            model.removeNodeFromParent(childNode);



            MainFrame.getInstance().getWorkspaceTree().updateUI();
        }else{
            return;
        }
        //MainFrame.getInstance().getTree().removeNode(childNode);
        //MainFrame.getInstance().getWorkspaceTree().updateUI();
    }
*/
    /*
    @Override
    public void actionPerformed(ActionEvent e){
        DefaultTreeModel model = MainFrame.getInstance().getTreeModel();

        TreePath[] paths = MainFrame.getInstance().getWorkspaceTree().getSelectionPaths();
        if (paths != null) {
            for (TreePath path : paths) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        path.getLastPathComponent();
                if (node.getParent() != null && !(node.isRoot())) {
                    model.removeNodeFromParent(node);
                    MainFrame.getInstance().getWorkspaceTree().updateUI();
                }
            }
        }
    }
*/
/*
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        if(childNodeView == null){
            return;
        }
        //DefaultMutableTreeNode childNodeModel = (DefaultMutableTreeNode) childNodeView.getUserObject();
        if(childNodeView.isRoot()){
            return;
        }
        childNodeView.removeFromParent();
        MainFrame.getInstance().getTreeModel().removeNodeFromParent(childNodeView);
        MainFrame.getInstance().getWorkspaceTree().updateUI();

    }

*/
}