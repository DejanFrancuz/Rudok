package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.ElementPainter;
import dsw.rudok.app.gui.swing.view.painters.SlotPainter;
import dsw.rudok.app.gui.swing.view.state.StateManager;
import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Slot extends RuNode implements IPublisher{



    public Dimension size;
    public Point2D position;
    public String name;
    public double angle;
    public boolean rotate;


    public SlotPainter slotPainter;

    public Slot(String name, RuNode parent) {
        super(name, parent);
    }
    List<ISubscriber> subscribers;

    public Slot(Dimension size, Point2D position,String name) {
        super(name);


        this.size = size;
        this.position = position;
        this.name = name;



    }




    public Dimension getSize() {
        return size;
    }

    public boolean isRotate() {
        return rotate;
    }

    public void setRotate(boolean rotate) {
        this.rotate = rotate;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
        notifyObs(position);
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }



    public SlotPainter getSlotPainter() {
        return slotPainter;
    }

    public void setSlotPainter(SlotPainter slotPainter) {
        this.slotPainter = slotPainter;
    }

    public Point2D getNorthEast(Slot slot){
        Point2D point= new Point2D.Double(slot.getPosition().getX()+slot.getSize().getWidth(),slot.getPosition().getY());
        return point;
    }
    public Point2D getSouthEast(Slot slot){
        Point2D point=new Point2D.Double(slot.getPosition().getX()+slot.getSize().getWidth(),slot.getPosition().getY()-slot.getSize().getHeight());
        return point;
    }
    public Point2D getSouthWest(Slot slot){
        Point2D point= new Point2D.Double(slot.getPosition().getX(),slot.getPosition().getY()-slot.getSize().getHeight());
        return point;
    }
    public Point2D getSouth(Slot slot){
        Point2D point=new Point2D.Double(slot.getPosition().getX()+slot.getSize().getWidth()/2,slot.getPosition().getY()-slot.getSize().getHeight());
        return point;
    }
    public Point2D getNorth(Slot slot){
        Point2D point=new Point2D.Double(slot.getPosition().getX()+slot.getSize().getWidth()/2,slot.getPosition().getY());
        return point;
    }
    public Point2D getWest(Slot slot){
        Point2D point=new Point2D.Double(slot.getPosition().getX(),slot.getPosition().getY()-slot.getSize().getHeight()/2);
        return point;
    }
    public Point2D getEast(Slot slot){
        Point2D point=new Point2D.Double(slot.getPosition().getX()+slot.getSize().getWidth(),slot.getPosition().getY()-slot.getSize().getHeight()/2);
        return point;
    }
    public Point2D getCenter(Slot slot){
        Point2D point=new Point2D.Double(slot.getPosition().getX()+slot.getSize().getWidth()/2,slot.getPosition().getY()-slot.getSize().getHeight()/2);
        return point;
    }
    public double calculateDistanceBetweenPointsWithPoint2D(double x1,double y1,double x2,double y2) {


        return Point2D.distance(x1,y1,x2,y2);
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

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
