package dsw.rudok.app.commands;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.PageModel;
import dsw.rudok.app.repository.PageSelectionModel;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.SlotHandler;
import dsw.rudok.app.repository.factory.CircleFactory;
import dsw.rudok.app.repository.factory.RectangleFactory;
import dsw.rudok.app.repository.factory.SlotFactory;
import dsw.rudok.app.repository.factory.TriangleFactory;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class AddDeviceCommand extends AbstractCommand{
    PageModel model;
    Point2D lastPosition;
    Slot device = null;
    PageSelectionModel selectionModel;
    ShapeEnum e;
    Slot slot=null;
    SlotHandler handler=new SlotHandler();
    Object o=null;



    public AddDeviceCommand(PageModel model, PageSelectionModel selectionModel, Point2D lastPosition,ShapeEnum e,Slot slot,Object o) {

        this.model = model;
        this.lastPosition = lastPosition;
        this.selectionModel = selectionModel;
        this.e=e;
        this.slot=slot;
        this.o=o;

    }

    public void doCommand() {
        if (device==null)
            if (e== ShapeEnum.CIRCLE){
                SlotFactory factory=new CircleFactory();
                device= factory.makeSlot((Point) lastPosition,model.getDeviceCount());
            }else if (e==ShapeEnum.RECTANGLE){
                SlotFactory factory=new RectangleFactory();
                device= factory.makeSlot((Point) lastPosition,model.getDeviceCount());
            } else if (e == ShapeEnum.TRIANGLE) {
                SlotFactory factory=new TriangleFactory();
                device= factory.makeSlot((Point) lastPosition,model.getDeviceCount());
            }else if(e==ShapeEnum.MOVE){
                moveCommand();
            }

        selectionModel.removeAllFromSelectionList();
        model.addSlots(device);
        selectionModel.addToSelectionList(device);

    }

    public void undoCommand() {
        if(e==ShapeEnum.MOVE){
            undoMove();
        }else {
            selectionModel.removeAllFromSelectionList();
            model.removeSlots(device);
        }
        }

    @Override
    public void resizeCommand() {

    }

    @Override
    public void rotateCommand() {

    }

    @Override
    public void moveCommand() {
        slot.setPosition(lastPosition);

    }

    @Override
    public void undoMove() {
        Point p=(Point)o;
        slot.setPosition(p);
    }

    @Override
    public void undoResize() {

    }
    @Override
    public void undoRotate(){
        slot.setAngle(0);
    }

    public PageModel getModel() {
        return model;
    }

    public void setModel(PageModel model) {
        this.model = model;
    }

    public Point2D getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(Point2D lastPosition) {
        this.lastPosition = lastPosition;
    }

    public Slot getDevice() {
        return device;
    }

    public void setDevice(Slot device) {
        this.device = device;
    }

    public PageSelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void setSelectionModel(PageSelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }

    public ShapeEnum getE() {
        return e;
    }

    public void setE(ShapeEnum e) {
        this.e = e;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
