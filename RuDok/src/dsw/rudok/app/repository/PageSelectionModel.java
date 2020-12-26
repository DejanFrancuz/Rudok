package dsw.rudok.app.repository;

import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.Slot;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PageSelectionModel extends DefaultSingleSelectionModel implements IPublisher {

    private ArrayList<Slot> selectionList=new ArrayList<>();
    private List<ISubscriber> subscribers;

    public void addToSelectionList(Slot slot) {
        selectionList.add(slot);
        notifyObs(slot);
    }
    public void addToSelectionList(ArrayList<Slot> list) {
        selectionList.addAll(list);
        notifyObs(list);
    }
    public int getSelectionListSize() {
        return selectionList.size();
    }
    public Slot getElementFromSelectionListAt(int index) {
        return (Slot)selectionList.get(index);
    }
    public int getIndexByObject(Slot slot) {
        return selectionList.indexOf(slot);
    }
    public void removeFromSelectionList(Slot slot) {
        selectionList.remove(slot);
        notifyObs(slot);
    }
    public void removeAllFromSelectionList() {
        selectionList.clear();
        notifyObs(new Object());
    }
    public ArrayList<Slot>  getSelectionList() {
        return selectionList;
    }

    public Iterator<Slot> getSelectionListIterator(){
        return selectionList.iterator();
    }

    public boolean isElementSelected(Slot slot){
        return selectionList.contains(slot);

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
