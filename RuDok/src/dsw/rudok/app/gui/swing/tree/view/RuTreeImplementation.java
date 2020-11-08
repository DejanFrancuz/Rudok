package dsw.rudok.app.gui.swing.tree.view;

import com.sun.tools.javac.Main;
import dsw.rudok.app.gui.swing.controller.DeleteErrorAction;
import dsw.rudok.app.gui.swing.tree.RuTree;
import dsw.rudok.app.gui.swing.tree.controller.RuTreeSelectionListener;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.*;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;
import org.w3c.dom.Node;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import java.util.ArrayList;

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
        RuNode nodeModel =  ((RuTreeItem)treeModel.getRoot()).getNodeModel();
        ((RuTreeItem)treeModel.getRoot()).add(new RuTreeItem(project));
        ((Workspace)nodeModel).addChild(project);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void addDocument(Project project,Document document){
    	
    	((RuTreeItem)treeView.getLastSelectedPathComponent()).add(new RuTreeItem(document));
    	project.addChild(document);
    	//treeView.expandPath(null);
       
    }
    @Override
    public void addPage(Document document, Page page){
        ((RuTreeItem)treeView.getLastSelectedPathComponent()).add(new RuTreeItem(page));
        document.addChild(page);
    }
    @Override
    public void addSlot(Page page, Slot slot){
        ((RuTreeItem)treeView.getLastSelectedPathComponent()).add(new RuTreeItem(slot));
        page.addChild(slot);
    }

    @Override
    public void removeNode(RuTreeItem item){
        RuNode node = item.getNodeModel();
        int index=-1;
        if(!(node instanceof Workspace)&& node!=null) {
            RuNodeComposite parent = (RuNodeComposite) node.getParent();
           ArrayList<RuNode> children = (ArrayList<RuNode>) parent.getChildren();
            for (RuNode ruNode : children) {
                if (ruNode.equals(node)) {
                     index = children.indexOf(node);
                    //children.remove(node);
                    //parent.setChildren(children);
                }
            }


            try {
                children.remove(index);
                index=-1;
            }
            catch (IndexOutOfBoundsException exception){
                new DeleteErrorAction();
            }
        }

        SwingUtilities.updateComponentTreeUI(treeView);
    }


    /*
    @Override
    public void removeNode(RuTreeItem node){
        if(!node.isRoot() && node!=null){
            node.removeFromParent();
            SwingUtilities.updateComponentTreeUI(treeView);
        }
    }

     */
}
