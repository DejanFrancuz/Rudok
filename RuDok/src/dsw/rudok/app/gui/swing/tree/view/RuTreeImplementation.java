package dsw.rudok.app.gui.swing.tree.view;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.gui.swing.tree.RuTree;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.ProjectTab;
import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.*;
import dsw.rudok.app.repository.element.CircleSlot;
import dsw.rudok.app.repository.element.RectangleSlot;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.List;

public class RuTreeImplementation implements RuTree, IPublisher {

    private RuTreeView treeView;
    private DefaultTreeModel treeModel;
    private List<ISubscriber> subscribers;

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
        Workspace workspace = (Workspace) project.getParent();
        List<RuNode> deca = workspace.getChildren();
        int index = 1;
        while(deca.contains(project)){
            project.setName("Project "+index);
            index++;
        }
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
        if(treeView.getLastSelectedPathComponent() == null){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
            return;
        }
        RuTreeItem item = (RuTreeItem) treeView.getLastSelectedPathComponent();
        RuNode node = item.getNodeModel();

        if(node instanceof Project) {


            Project project = (Project) node;
            Document document = new Document("Document " + (item.getChildCount() + 1), project);
            List<RuNode> ocevi=new ArrayList<>();
            Workspace w=(Workspace)((RuTreeItem)MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel();
            ocevi=w.getChildren();
            List<RuNode> deca = new ArrayList<>();
            for(RuNode p: ocevi){
                Project p1=(Project)p;
                deca.addAll(p1.getChildren());
            }

            int index = 1;
            while(deca.contains(document)){
                document =new Document("Document "+index,node);
                index++;
            }
            item.add(new RuTreeItem(document));
            project.addChild(document);
            SwingUtilities.updateComponentTreeUI(treeView);

            //DODAVNJE TABA
          //  document.setDocumentTab(project.getProjectTab().getDocumentTabForDocument(document));


        }
    }

     @Override
     public void addPage(){
         if(treeView.getLastSelectedPathComponent() == null){
             AppCore.getInstance().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
             return;
         }
         RuTreeItem item = (RuTreeItem) treeView.getLastSelectedPathComponent();
         RuNode node=item.getNodeModel();
         if(node instanceof Document){
             List<RuNode> projekti= new ArrayList<>();
             List<RuNode> dokumenti= new ArrayList<>();
             Workspace w=(Workspace)((RuTreeItem)MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel();
             projekti=w.getChildren();
             for(RuNode project: projekti){
                 Project p=(Project)project;
                 dokumenti.addAll(p.getChildren());
             }
             Document document = (Document) node;
             Page page = new Page("Page " + (item.getChildCount() + 1), document);
             List<RuNode> deca = new ArrayList<>();
             for(RuNode dokument: dokumenti){
                 Document d=(Document)dokument;
                 deca.addAll(d.getChildren());
             }
             int index = 1;
             while(deca.contains(page)){
                 page.setName("Page " + index);
                 index++;
             }
             item.add(new RuTreeItem(page));
             document.addChild(page);
             SwingUtilities.updateComponentTreeUI(treeView);

             //DODAVANJE TABA

            // page.setPageTab(document.getDocumentTab().getPageTabForPage(page));
         }
     }
    @Override
    public void addSlot(RectangleSlot rectangleSlot,Page page){
        if(treeView.getLastSelectedPathComponent() == null){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
            return;
        }
        RuTreeItem item= page.getItem();

        //if(node instanceof Page) {
            List<RuNode> projekti= new ArrayList<>();
            List<RuNode> dokumenti= new ArrayList<>();
            List<RuNode> pages= new ArrayList<>();
            Workspace w=(Workspace)((RuTreeItem)MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel();
            projekti=w.getChildren();
            for(RuNode project: projekti){
                Project p=(Project)project;
                dokumenti.addAll(p.getChildren());
            }
            for(RuNode dokument: dokumenti){
                Document d=(Document)dokument;
                pages.addAll(d.getChildren());
            }
           // Page page = (Page) node;
            List<RuNode> deca = new ArrayList<>();
            for(RuNode s: pages){
                Page s1=(Page) s;
                deca.addAll(s1.getChildren());
            }

            int index = 1;
            while(deca.contains(rectangleSlot)){
                //rectangleSlot.setName("RectangleSlot " + index);
                index++;
            }

            item.add(new RuTreeItem(rectangleSlot));
            //page.getPageTab().setSlot(slot);
            page.addChild(rectangleSlot);
            SwingUtilities.updateComponentTreeUI(treeView);
        //}
    }

    @Override
    public void addSlot(CircleSlot circle,Page page) {

    }

    @Override
    public void removeNode(){
        if(treeView.getLastSelectedPathComponent() == null){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
            return;
        }
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
            itemm.removeAllChildren();
            index=-1;
        }
        treeView.setSelectionPath(null);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void shareDocument() {
        if(treeView.getLastSelectedPathComponent()==null){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
            return;
        }
        RuTreeItem item= (RuTreeItem) treeView.getLastSelectedPathComponent();
        RuNode node=item.getNodeModel();
        if(node instanceof Document) {
            Document d=(Document)node;
            Workspace w = (Workspace) ((RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel();

            List<RuNode> projects = w.getChildren();

            JFrame frame = new JFrame("Document share");

            Project selectedProject = (Project) JOptionPane.showInputDialog(frame, "Select project", "Select document", JOptionPane.QUESTION_MESSAGE, null, projects.toArray(), projects.toArray()[0]);
            if(selectedProject==null)return;
            RuTreeItem i=new RuTreeItem(d);
            selectedProject.getItem().insert(i,selectedProject.getChildren().size());
            /*selectedProject.shareDocument(i);*/
            selectedProject.addChild(d);
            SwingUtilities.updateComponentTreeUI(treeView);

            //notifyObs(selectedProject);
            //System.out.println(selectedProject);
        }
    }


    @Override
    public void addSubs(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubs(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifyObs(Object notif) {
        if(notif == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(ISubscriber listener : subscribers){
            listener.update(notif);
        }
    }
}
