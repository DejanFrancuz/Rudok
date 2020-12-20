package dsw.rudok.app.repository.node;


import dsw.rudok.app.AppCore;
import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.errorHandler.MyError;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.Workspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNode implements IPublisher, Serializable {

    private String name;

    private RuNode parent;

    public RuNode(String name,RuNode parent){
        this.name=name;
        this.parent=parent;
    }

    public RuNode(String name) {
    }

    @Override
    public boolean equals(Object obj){
        if(obj!=null && obj instanceof RuNode){
            RuNode otherObj = (RuNode)obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public RuNode getParent() {
        return parent;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.NAME_CANNOT_BE_EMPTY);
            return;
        }
        List<RuNode> projekti = new ArrayList<>();
        List<RuNode> dokumenti = new ArrayList<>();
        Workspace w = (Workspace) ((RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel();
        projekti = w.getChildren();
        for (RuNode project : projekti) {
            Project p = (Project) project;
            dokumenti.addAll(p.getChildren());
        }
        int i = 0;
        for (RuNode ru : dokumenti) {
            Document d = (Document) ru;
            if (d.getName().equals(name)) {
                i = 1;
            }
        }
        if (i == 1) {
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.DOCUMENTS_CANNOT_HAVE_SAME_NAME);
            return;
        }
            this.name = name;
            notifyObs(name);

    }

    public void setParent(RuNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "RuNode{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
}
