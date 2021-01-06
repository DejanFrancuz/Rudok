package dsw.rudok.app.repository;

import dsw.rudok.app.commands.CommandManager;
import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.Slot;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PageModel implements IPublisher, Serializable {
    private String name;
    private static int count=0;


    protected ArrayList<Slot> slots = new ArrayList<Slot>();
    private List<ISubscriber> subscribers;

public Slot getSlotatPosition(Point point) {
    for(int i=getDeviceCount()-1;i>=0;i--){
        Slot slot = getSlotAt(i);
        if(slot==null)return null;
        if(slot.getSlotPainter().isElementAt(point)){
            return slot;
        }
    }
    return null;
}

    public Iterator<Slot> getSlotIterator(){
        return slots.iterator();
    }

    public int getDeviceCount(){
        return slots.size();
    }

    public Slot getSlotAt(int i){
        return slots.get(i);
    }

    public static int getCount() {
        return count;
    }


    public static void setCount(int count) {
        PageModel.count = count;
    }



    public String getName() {
        return name;
    }
    public int getIndexAtPosition(Point point) {
        for(int i=getDeviceCount()-1;i>=0;i--){
            Slot element = getSlotAt(i);
            if(element.getSlotPainter().elementAt(element,point)){
                return i;
            }
        }
        return -1;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
    public int getElementCount(){
        return slots.size();
    }


    public void addSlots(Slot slot){
    if(!getSlots().contains(slot)) {
        slots.add(slot);
        notifyObs(slot);
    }
    }
    public void removeSlots(Slot slot){
    slots.remove(slot);
    notifyObs(slot);
    }
    public void removeAllSlots(){
    slots.clear();
    notifyObs(new Object());
    }
    public void addToList(ArrayList<Slot> list) {
            slots.addAll(list);
            notifyObs(list);
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

    public ArrayList<Slot> getSlots() {
        return slots;
    }





}
