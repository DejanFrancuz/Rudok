package dsw.rudok.app.gui.swing.tree.view;

import dsw.rudok.app.gui.swing.tree.RuTree;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.Workspace;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class RuTreeImplementation implements RuTree {

    private RuTreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public JTree generateTree(Workspace workspace){
        RuTreeItem root=new RuTreeItem(workspace);
        treeModel = new DefaultTreeModel(root);
        treeView = new RuTreeView(treeModel);
        return treeView;
    }
    @Override
    public void addProject(Project project){
        RuNode nodeModel = ((RuTreeItem)treeModel.getRoot()).getNodeModel();
        ((RuTreeItem)treeModel.getRoot()).add(new RuTreeItem(project));
        ((Workspace)nodeModel).addChild(project);
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}
