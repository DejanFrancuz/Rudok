package dsw.rudok.app.repository;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.gui.swing.tree.RuTree;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.ProjectTab;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.tree.MutableTreeNode;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project extends RuNodeComposite {

    List<ISubscriber> subscribers;
    ProjectTab projectTab;


    public Project(String name, RuNode parent){
        super(name,parent);

    }
    @Override
    public void addChild(RuNode child){
        if(child!=null && child instanceof Document){
            Document document= (Document)child;
            if(!this.getChildren().contains(document)){
                this.getChildren().add(document);
                notifyObs(document);
            }
        }

    }

    @Override
    public void removeChild(int index) {
        notifyObs(index);
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

    @Override
    public String toString() {
        return getName();
    }

    public ProjectTab getProjectTab() {
        return projectTab;
    }

    public void setProjectTab(ProjectTab projectTab) {
        this.projectTab = projectTab;
    }
}
