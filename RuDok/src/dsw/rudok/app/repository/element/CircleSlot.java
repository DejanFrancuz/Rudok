package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.CirclePainter;
import dsw.rudok.app.gui.swing.view.painters.ElementPainter;
import dsw.rudok.app.gui.swing.view.state.StateManager;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.SlotModel;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class CircleSlot extends Slot{




    public CircleSlot(String name, RuNode parent, SlotModel slotModel, Stroke stroke, Paint paint, Dimension size, Point2D position, String name1, ElementPainter elementPainter, List<ISubscriber> subscribers, StateManager stateManager) {
        super(name, parent, slotModel, stroke, paint, size, position, name1, elementPainter, subscribers, stateManager);
        devicePainter = new CirclePainter(this);
    }

    public static Slot createDefault(Point2D pos){
        Point2D position = (Point2D) pos.clone();

        CircleSlot or=new CircleSlot(
                new Dimension(50,50),position);
        or.setName("Circle ");
        return or;
    }

}
