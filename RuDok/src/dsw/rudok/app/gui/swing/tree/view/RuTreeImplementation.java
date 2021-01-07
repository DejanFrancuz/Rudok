package dsw.rudok.app.gui.swing.tree.view;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.core.Repository;
import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.gui.swing.tree.RuTree;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.gui.swing.view.ProjectTab;
import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.*;
import dsw.rudok.app.repository.element.CircleSlot;
import dsw.rudok.app.repository.element.RectangleSlot;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RuTreeImplementation implements RuTree, IPublisher, Serializable {

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
    public void addSlot(Slot slot,Page page){
        Document d=(Document) page.getParent();
        Project p=(Project)d.getParent();
        int indexD=p.getChildren().indexOf(d);
        RuTreeItem projI=getProjectItem(p);
        RuTreeItem docItem=(RuTreeItem) projI.findChildByIndex(indexD);
        int indexP= d.getChildren().indexOf(page);
        RuTreeItem pageItem=(RuTreeItem) docItem.findChildByIndex(indexP);
            pageItem.add(new RuTreeItem(slot));
            page.addChild(slot);
            SwingUtilities.updateComponentTreeUI(treeView);
    }
    public RuTreeItem getProjectItem(Project project){
        RuTreeItem item = (RuTreeItem) treeModel.getRoot();
        Workspace w = (Workspace) ((RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel();
        int index=w.getChildren().indexOf(project);
        return (RuTreeItem) item.findChildByIndex(index);
    }
    @Override
    public void removeSlot(Slot slot){
        System.out.println(slot);
        Page page=((PageTab)MainFrame.getInstance().getjPanel()).getPage();
        Document d=(Document) page.getParent();
        Project p=(Project)d.getParent();
        int indexD=p.getChildren().indexOf(d);
        RuTreeItem projI=getProjectItem(p);
        RuTreeItem docItem=(RuTreeItem) projI.findChildByIndex(indexD);
        int indexP= d.getChildren().indexOf(page);
        RuTreeItem pageItem=(RuTreeItem) docItem.findChildByIndex(indexP);
        int slotIndex=page.getChildren().indexOf(slot);
        RuTreeItem slotItem=(RuTreeItem)pageItem.findChildByIndex(slotIndex);
        RuNode node=slotItem.getNodeModel();
        remove(node,slotItem);
        treeView.setSelectionPath(null);
        SwingUtilities.updateComponentTreeUI(treeView);
    }
    @Override
    public void removeNode(){
        if(treeView.getLastSelectedPathComponent() == null){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
            return;
        }
        Workspace w = (Workspace) ((RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel();
        RuTreeItem itemm= (RuTreeItem) treeView.getLastSelectedPathComponent();
        RuNode node=itemm.getNodeModel();
        int index=-1;
        if(!(node instanceof Workspace)&& node!=null) {
            remove(node,itemm);
        }
        if(node instanceof Document){

            Document d=(Document)node;
            if (d.getShared().contains(d)){
                List<RuNode> projects= w.getChildren();
                List<RuNodeComposite> projectsComposite=new ArrayList<>();
                for(RuNode nodee: projects){
                    RuNodeComposite com=(RuNodeComposite) nodee;
                    projectsComposite.add(com);
                }

                for(RuNodeComposite project: projectsComposite){
                    if(project.getChildren().contains(node)){
                        Project p=(Project)project;
                        itemm.removeFromParent();
                        int indexx=p.getChildren().indexOf(node);
                        p.getChildren().remove(node);
                        p.removeChild(indexx);
                        d.getShared().remove(d);


                    }
                }
            }
        }
        treeView.setSelectionPath(null);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    public void remove(RuNode node,RuTreeItem item){
        int index=-1;
        RuNodeComposite parent = (RuNodeComposite) node.getParent();
        ArrayList<RuNode> children = (ArrayList<RuNode>) parent.getChildren();
        for (RuNode ruNode : children) {
            if (ruNode.equals(node)) {
                index = children.indexOf(node);
            }
        }
        children.remove(index);
        parent.removeChild(index);
        item.removeAllChildren();
        item.removeFromParent();
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
            RuTreeItem ii=getProjectItem(selectedProject);
            if(!d.getShared().contains(d)) {
                d.getShared().add(d);
            }
            ii.insert(item,selectedProject.getChildren().size());
            selectedProject.addChild(d);
            SwingUtilities.updateComponentTreeUI(treeView);
        }
    }

    public void addProject(Project project){
        RuTreeItem item = (RuTreeItem) treeModel.getRoot();
        Workspace workspace = (Workspace) project.getParent();
        item.add(new RuTreeItem(project));
        workspace.addChild(project);
        SwingUtilities.updateComponentTreeUI(treeView);


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
