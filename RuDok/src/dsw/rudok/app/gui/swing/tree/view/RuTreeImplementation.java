package dsw.rudok.app.gui.swing.tree.view;

import dsw.rudok.app.gui.swing.tree.RuTree;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.DocumentTab;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.ProjectTab;
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
    public void addProject(){
        RuTreeItem item = (RuTreeItem) treeModel.getRoot();
        RuNode node = item.getNodeModel();

        Project project = new Project("Project " +  (item.getChildCount()+1), node);
        item.add(new RuTreeItem(project));
        ((Workspace) node).addChild(project);
        SwingUtilities.updateComponentTreeUI(treeView);

        //DODAVANJE TABA

        String name = project.getName();
        ProjectTab projectTab = new ProjectTab(project);
        MainFrame.getInstance().getTabbedPane().add(projectTab);
        project.setProjectTab(projectTab);


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

            //DODAVNJE TABA
            document.setDocumentTab(project.getProjectTab().getDocumentTabForDocument(document));


        }
    }

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
    public void addSlot(){
        RuTreeItem item= (RuTreeItem) treeView.getLastSelectedPathComponent();
        RuNode node = item.getNodeModel();
        if(node instanceof Page) {

            Page page = (Page) node;
            Slot slot = new Slot("Slot " + (item.getChildCount() + 1), page);
            item.add(new RuTreeItem(slot));
            page.addChild(slot);
            SwingUtilities.updateComponentTreeUI(treeView);
        }
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
                }
            }
            children.remove(index);
            parent.removeChild(index);
            index=-1;
        }
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}
