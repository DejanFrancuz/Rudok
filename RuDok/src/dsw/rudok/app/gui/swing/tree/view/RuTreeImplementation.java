package dsw.rudok.app.gui.swing.tree.view;

import dsw.rudok.app.gui.swing.tree.RuTree;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.*;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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
    public void addDocument(){
        RuTreeItem item = (RuTreeItem) treeView.getLastSelectedPathComponent();
        RuNode node = item.getNodeModel();

        if(node instanceof Project) {

            Project project = (Project) node;
            Document document = new Document("Document" + (item.getChildCount() + 1), project);
            item.add(new RuTreeItem(document));
            project.addChild(document);
            SwingUtilities.updateComponentTreeUI(treeView);
        }
    }
    /*
    @Override
    public void addPage(Document document, Page page){
        ((RuTreeItem)treeView.getLastSelectedPathComponent()).add(new RuTreeItem(page));
        document.addChild(page);
    }
    */
     @Override
     public void addPage(){

         RuTreeItem item = (RuTreeItem) treeView.getLastSelectedPathComponent();
         RuNode node=item.getNodeModel();
         if(node instanceof Document) {

             Document document = (Document) node;
             Page page = new Page("Page " + (item.getChildCount() + 1), document);
             item.add(new RuTreeItem(page));
             document.addChild(page);
             SwingUtilities.updateComponentTreeUI(treeView);
         }
     }
    @Override
    public void addSlot(Page page, Slot slot){
        ((RuTreeItem)treeView.getLastSelectedPathComponent()).add(new RuTreeItem(slot));
        page.addChild(slot);
    }

    @Override
    public void removeNode(){
        RuTreeItem itemm= (RuTreeItem) treeView.getLastSelectedPathComponent();
        RuNode node=itemm.getNodeModel();
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
            children.remove(index);
            index=-1;
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
