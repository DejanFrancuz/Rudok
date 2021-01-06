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
import java.util.ArrayList;
import java.util.List;

public class AddDeviceCommand extends AbstractCommand{
    PageModel model;
    Point2D lastPosition;
    Slot device = null;
    PageSelectionModel selectionModel;
    ShapeEnum e;
    Object o=null;
    Object o1=null;
    ArrayList<Slot> list;



    public AddDeviceCommand(PageModel model, PageSelectionModel selectionModel, Point2D lastPosition,ShapeEnum e,ArrayList<Slot> list,Object o,Object o1) {

        this.model = model;
        this.lastPosition = lastPosition;
        this.selectionModel = selectionModel;
        this.e=e;
        this.o=o;
        this.o1=o1;
        this.list=list;
    }

    public void doCommand() {
        //if (device==null)
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
            }else if(e==ShapeEnum.RESIZE){
                resizeCommand();
            }else if(e==ShapeEnum.ROTATE){
                rotateCommand();
            }else if(e==ShapeEnum.DELETE_C || e==ShapeEnum.DELETE_R || e==ShapeEnum.DELETE_T){
                model.getSlots().removeAll(selectionModel.getSelectionList());
                selectionModel.removeAllFromSelectionList();
            }

        if(device!=null) {
            selectionModel.addToSelectionList(device);
            model.addSlots(device);
        }

    }

    public void undoCommand() {
        if(e==ShapeEnum.MOVE){
            undoMove();
        }else if(e==ShapeEnum.RESIZE){
            undoResize();
        }else if(e==ShapeEnum.ROTATE) {
            undoRotate();
        }else if(e==ShapeEnum.DELETE_C){
            SlotFactory factory=new CircleFactory();
            device= factory.makeSlot((Point) lastPosition,model.getDeviceCount());
        }else if(e==ShapeEnum.DELETE_R){
            SlotFactory factory=new RectangleFactory();
            device= factory.makeSlot((Point) lastPosition,model.getDeviceCount());
        }else if(e==ShapeEnum.DELETE_T){
            SlotFactory factory=new TriangleFactory();
            device= factory.makeSlot((Point) lastPosition,model.getDeviceCount());
        }
        else{
            while(selectionModel.isElementSelected(device))
                selectionModel.removeFromSelectionList(device);
            model.removeSlots(device);
        }


        }

    @Override
    public void resizeCommand() {
        Dimension d=(Dimension)o1;
        for(Slot s: list){
            s.setSize(d);
        }
    }

    @Override
    public void rotateCommand() {
        for(Slot s: list){
            s.setAngle((Double)o1);
        }
    }

    @Override
    public void moveCommand() {
        System.out.println("konacno");
        device=(Slot)o1;
        device.setPosition(lastPosition);
    }

    @Override
    public void undoMove() {

        Point p=(Point)o;
        device=(Slot)o1;
        device.setPosition(p);
    }

    @Override
    public void undoResize() {
        Dimension d=(Dimension)o;
        for(Slot s: list){
            s.setSize(d);
        }
    }
    @Override
    public void undoRotate(){
        for(Slot s: list){
            s.setAngle((Double)o);
        }
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
}
