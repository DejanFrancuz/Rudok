package dsw.rudok.app.commands;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.PageModel;
import dsw.rudok.app.repository.PageSelectionModel;
import dsw.rudok.app.repository.element.Slot;
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



    public AddDeviceCommand(PageModel model, PageSelectionModel selectionModel, Point2D lastPosition,ShapeEnum e) {

        this.model = model;
        this.lastPosition = lastPosition;
        this.selectionModel = selectionModel;
        this.e=e;

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

            }

        selectionModel.removeAllFromSelectionList();
        model.addSlots(device);
        selectionModel.addToSelectionList(device);

    }

    public void undoCommand() {
        selectionModel.removeAllFromSelectionList();
        model.removeSlots(device);
    }

}
