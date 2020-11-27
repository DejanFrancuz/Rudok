package dsw.rudok.app.repository;

import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

public class Page extends RuNodeComposite {

    private PageTab pageTab;


    public Page(String name, RuNode parent) {

        super(name, parent);
    }



    public void addChild(RuNode child){
        if(child!=null && child instanceof Slot){
            Slot slot= (Slot)child;
            if(!this.getChildren().contains(slot)){
                this.getChildren().add(slot);
            }
        }
    }

    public PageTab getPageTab() {
        return pageTab;
    }

    public void setPageTab(PageTab pageTab) {
        this.pageTab = pageTab;
    }

    @Override
    public void addSubs(ISubscriber iSubscriber) {

    }

    @Override
    public void removeSubs(ISubscriber iSubscriber) {

    }

    @Override
    public void notifyObs(Object notif) {

    }
}
