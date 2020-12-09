package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.ElementPainter;
import dsw.rudok.app.gui.swing.view.painters.SlotDevicePainter;
import dsw.rudok.app.gui.swing.view.state.StateManager;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.SlotModel;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Slot extends RuNode {

    SlotModel slotModel=new SlotModel();
    public Stroke stroke;
    public Paint paint;
    public Dimension size;
    public Point2D position;
    public String name;

    public ElementPainter elementPainter;

    public Slot(String name, RuNode parent) {
        super(name, parent);
    }
    List<ISubscriber> subscribers;

    public Slot(String name, RuNode parent, SlotModel slotModel, Stroke stroke, Paint paint, Dimension size, Point2D position, String name1, ElementPainter elementPainter, List<ISubscriber> subscribers, StateManager stateManager) {
        super(name, parent);
        this.slotModel = slotModel;
        this.stroke = stroke;
        this.paint = paint;
        this.size = size;
        this.position = position;
        this.name = name1;
        this.elementPainter = elementPainter;
        this.subscribers = subscribers;
        this.stateManager = stateManager;
    }
    protected SlotDevicePainter devicePainter;



    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public ElementPainter getElementPainter() {
        return elementPainter;
    }

    public void setElementPainter(ElementPainter elementPainter) {
        this.elementPainter = elementPainter;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    private StateManager stateManager=new StateManager(this);

    public void startCircleState() {
        stateManager.setCircleState();
    }

    public void startSelectState() {
        stateManager.setSelectState();
    }
    public void startRectangleState(){
        stateManager.setRectangleState();
    }
    public StateManager getStateManager() {
        return stateManager;
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
