package dsw.rudok.app.gui.swing.tree.controller;

import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.tree.view.RuTreeView;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

public class RuTreeModelListener implements TreeModelListener {
    private RuTreeView tree;

    public RuTreeModelListener(RuTreeView tree) {
        super();
        this.tree = tree;
    }

    @Override
    public void treeNodesChanged(TreeModelEvent e) {
        this.tree.expandPath(e.getTreePath());
        this.tree.update();
    }

    @Override
    public void treeNodesInserted(TreeModelEvent e) {
        this.tree.update();
    }

    @Override
    public void treeNodesRemoved(TreeModelEvent e) {
        this.tree.update();
    }

    @Override
    public void treeStructureChanged(TreeModelEvent e) {
        this.tree.update();
    }
}
