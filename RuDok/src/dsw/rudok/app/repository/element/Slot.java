package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.SlotView;
import dsw.rudok.app.gui.swing.view.painters.ElementPainter;
import dsw.rudok.app.gui.swing.view.painters.SlotPainter;
import dsw.rudok.app.gui.swing.view.state.StateManager;
import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Slot extends RuNode implements IPublisher, Serializable {



    public Dimension size;
    public Point2D position;
    public String name;
    public double angle;
    public boolean rotate;
    private File file;
    private TipSlota tip;
    private SlotView slotView;


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
        notifyObs(this);
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
        notifyObs(this);
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
        notifyObs(this);
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

    public Point2D getNorthEast(){
        Point2D point= new Point2D.Double(this.getPosition().getX()+this.getSize().getWidth(),this.getPosition().getY());
        return point;
    }
    public Point2D getSouthEast(){
        Point2D point=new Point2D.Double(this.getPosition().getX()+this.getSize().getWidth(),this.getPosition().getY()-this.getSize().getHeight());
        return point;
    }
    public Point2D getSouthWest(){
        Point2D point= new Point2D.Double(this.getPosition().getX(),this.getPosition().getY()-this.getSize().getHeight());
        return point;
    }
    public Point2D getSouth(){
        Point2D point=new Point2D.Double(this.getPosition().getX()+this.getSize().getWidth()/2,this.getPosition().getY()-this.getSize().getHeight());
        return point;
    }
    public Point2D getNorth(){
        Point2D point=new Point2D.Double(this.getPosition().getX()+this.getSize().getWidth()/2,this.getPosition().getY());
        return point;
    }
    public Point2D getWest(){
        Point2D point=new Point2D.Double(this.getPosition().getX(),this.getPosition().getY()-this.getSize().getHeight()/2);
        return point;
    }
    public Point2D getEast(){
        Point2D point=new Point2D.Double(this.getPosition().getX()+this.getSize().getWidth(),this.getPosition().getY()-this.getSize().getHeight()/2);
        return point;
    }
    public Point2D getCenter(){
        Point2D point=new Point2D.Double(this.getPosition().getX()+this.getSize().getWidth()/2,this.getPosition().getY()-this.getSize().getHeight()/2);
        return point;
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


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public TipSlota getTip() {
        return tip;
    }

    public void setTip(TipSlota tip) {
        this.tip = tip;
    }

    public SlotView getSlotView() {
        return slotView;
    }

    public void setSlotView(SlotView slotView) {
        this.slotView = slotView;

    }
}
