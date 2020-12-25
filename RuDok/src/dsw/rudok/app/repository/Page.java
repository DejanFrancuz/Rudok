package dsw.rudok.app.repository;

import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.gui.swing.view.state.StateManager;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class Page extends RuNodeComposite {

    private PageTab pageTab;
    List<ISubscriber> subscribers;
    private PageModel pageModel = new PageModel();
    //private Slot selected;
    boolean rotate;


    public Page(String name, RuNode parent) {

        super(name, parent);
    }
    private StateManager stateManager= new StateManager(this);

    public void addChild(RuNode child) {
        if (child != null && child instanceof Slot) {
            Slot slot = (Slot) child;
            if (!this.getChildren().contains(slot)) {
                this.getChildren().add(slot);
                notifyObs(slot);
            }
        }
    }

    public void startTriangleState(){stateManager.setTriangleState(); }
    public void startSelectState() {
        stateManager.setSelectState();
    }
    public void startRectangleState(){
        stateManager.setRectangleState();
    }
    public void startCircleState(){stateManager.setCircleState();}
    public void startResizeState(){stateManager.setResizeState();}
    public void startMoveState(){stateManager.setMoveState();}
    public void startRotateState(){stateManager.setRotateState();}
    public void startDeleteSlotState(){stateManager.setDeleteSlotState();}
    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
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

    public boolean isRotate() {
        return rotate;
    }

    public void setRotate(boolean rotate) {
        this.rotate = rotate;
        notifyObs(rotate);
    }

    @Override
    public void addSubs(ISubscriber sub) {
        if (sub == null)
            return;
        if (this.subscribers == null)
            this.subscribers = new ArrayList<>();
        if (this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }


    @Override
    public void removeSubs(ISubscriber sub) {
        if (sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifyObs(Object notif) {
        if (notif == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for (ISubscriber listener : subscribers) {

            listener.update(notif);
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    public PageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(PageModel pageModel) {
        this.pageModel = pageModel;
    }



    /*public Slot getSelected() {
        return selected;
    }

    public void setSelected(Slot selected) {
        this.selected = selected;
        notifyObs(selected);
    }*/


}
