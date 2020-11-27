package dsw.rudok.app.repository;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.node.RuNode;

public class Slot extends RuNode {
    public Slot(String name, RuNode parent) {
        super(name, parent);
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
