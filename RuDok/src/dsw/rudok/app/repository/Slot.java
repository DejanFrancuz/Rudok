package dsw.rudok.app.repository;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.node.RuNode;

import java.util.ArrayList;
import java.util.List;

public class Slot extends RuNode {

    SlotModel slotModel=new SlotModel();

    public Slot(String name, RuNode parent) {
        super(name, parent);
    }
    List<ISubscriber> subscribers;

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

    public SlotModel getSlotModel() {
        return slotModel;
    }

    public void setSlotModel(SlotModel slotModel) {
        this.slotModel = slotModel;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
