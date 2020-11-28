package dsw.rudok.app.gui.swing.tree;

import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.repository.*;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public interface RuTree {
    JTree generateTree(Workspace workspace);
    void addProject();
    void addDocument();
    void addPage();
    void addSlot();
    void removeNode();

}
