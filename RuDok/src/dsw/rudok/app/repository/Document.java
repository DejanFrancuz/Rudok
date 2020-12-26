package dsw.rudok.app.repository;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.DocumentTab;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Document extends RuNodeComposite implements Serializable {

    private DocumentTab documentTab;
    List<ISubscriber> subscribers;
    List<Document> shared=new ArrayList<>();

    public Document(String name, RuNode parent) {

        super(name, parent);
    }


    public void addChild(RuNode child){
        if(child!=null && child instanceof Page){
            Page page=(Page)child;
            if(!this.getChildren().contains(page)){
                this.getChildren().add(page);
                notifyObs(page);
            }
        }
    }
    @Override
    public void removeChild(int index) {
        notifyObs(index);
    }

    public DocumentTab getDocumentTab() {
        return documentTab;
    }

    public void setDocumentTab(DocumentTab documentTab) {

        this.documentTab = documentTab;
    }

    public List<Document> getShared() {
        return shared;
    }

    public void setShared(List<Document> shared) {
        this.shared = shared;
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
