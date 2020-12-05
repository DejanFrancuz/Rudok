package dsw.rudok.app.repository;

import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.SlotDevice;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
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
public int getDeviceAtPosition(Point point) {
    for(int i=getDeviceCount()-1;i>=0;i--){
        SlotDevice device = getDeviceAt(i);
        if(device.getDevicePainter().isElementAt(point)){
            return i;
        }
    }
    return -1;
}

    public int getDeviceCount(){
        return slotDevices.size();
    }

    public SlotDevice getDeviceAt(int i){
        return slotDevices.get(i);
    }

    public static int getCount() {
        return count;
    }


    public static void setCount(int count) {
        SlotModel.count = count;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
    public int getElementCount(){
        return slotDevices.size();
    }


    public void addDiagramElements(SlotDevice device){

        slotDevices.add(device);
        notifyObs(device);
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
