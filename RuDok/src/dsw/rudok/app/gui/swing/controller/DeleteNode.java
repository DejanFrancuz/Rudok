package dsw.rudok.app.gui.swing.controller;

import com.sun.glass.events.KeyEvent;
import com.sun.tools.javac.Main;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.Workspace;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;

public class DeleteNode extends AbstractRudokAction {

    public DeleteNode() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/delete_1.png"));
        putValue(NAME, "Delete Node");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    public void actionPerformed(ActionEvent e) {
        Object o = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();

        if (o instanceof Project) {
            Project project = (Project)o;
            Workspace ws =(Workspace) project.getParent();
            DefaultMutableTreeNode node;
            DefaultTreeModel model = (DefaultTreeModel) (MainFrame.getInstance().getWorkspaceTree().getModel());
            TreePath[] paths = MainFrame.getInstance().getWorkspaceTree().getSelectionPaths();
            for (int i = 0; i < paths.length; i++) {
                node = (DefaultMutableTreeNode) (paths[i].getLastPathComponent());
                model.removeNodeFromParent(node);
            }
            /*
            Project project = (Project)o;
           // Workspace ws =(Workspace) project.getParent();
            DefaultTreeModel model = (DefaultTreeModel)project.getParent();
        //    System.out.println(ws);
            model.removeNodeFromParent(project);

            MainFrame.getInstance().getWorkspaceTree().updateUI();
        }

             */
        }
    }
}