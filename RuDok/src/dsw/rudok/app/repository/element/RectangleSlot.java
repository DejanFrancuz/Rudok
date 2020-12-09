package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.ElementPainter;
import dsw.rudok.app.gui.swing.view.painters.RectanglePainter;
import dsw.rudok.app.gui.swing.view.state.StateManager;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.SlotModel;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class RectangleSlot extends Slot{



    public RectangleSlot(String name, RuNode parent, SlotModel slotModel, Stroke stroke, Paint paint, Dimension size, Point2D position, String name1, ElementPainter elementPainter, List<ISubscriber> subscribers, StateManager stateManager) {
        super(name, parent, slotModel, stroke, paint, size, position, name1, elementPainter, subscribers, stateManager);
        devicePainter = new RectanglePainter(this);
    }

    public static SlotDevice createDefault(Point2D pos){
        Point2D position = (Point2D) pos.clone();

        RectangleSlot rectangleElement=new RectangleSlot(
                new Dimension(80,40),position);
        rectangleElement.setName("Rectangle");
        return rectangleElement;
    }

}
