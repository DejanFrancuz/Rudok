package dsw.rudok.app.repository;

import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.SlotDevice;

import java.util.ArrayList;
import java.util.List;

public class SlotModel implements IPublisher {
    private String name;
    private static int count=0;

    protected ArrayList<SlotDevice> slotDevices = new ArrayList<>();
    private List<ISubscriber> subscribers;
/*
    public SlotModel(String name, ArrayList<SlotDevice> slotDevices) {
        this.name = name;
        this.slotDevices = slotDevices;
    }
 */
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
