package dsw.rudok.app.repository;

import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class Page extends RuNodeComposite {

    private PageTab pageTab;
    List<ISubscriber> subscribers;


    public Page(String name, RuNode parent) {

        super(name, parent);
    }



    public void addChild(RuNode child){
        if(child!=null && child instanceof Slot){
            Slot slot= (Slot)child;
            if(!this.getChildren().contains(slot)){
                this.getChildren().add(slot);
                notifyObs(slot);
            }
        }
    }
    @Override
    public void removeChild(int index) {
        notifyObs(index);
    }


    public PageTab getPageTab() {
        return pageTab;
    }

    public void setPageTab(PageTab pageTab) {
        this.pageTab = pageTab;
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
}
