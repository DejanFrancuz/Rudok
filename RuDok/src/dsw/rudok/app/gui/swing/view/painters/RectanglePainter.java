package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.element.RectangleSlot;
import dsw.rudok.app.repository.element.Slot;

import java.awt.geom.GeneralPath;

public class RectanglePainter extends SlotPainter {


    public RectanglePainter(Slot slot) {
        super(slot);
        RectangleSlot rectangle = (RectangleSlot) slot;

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(rectangle.getPosition().getX(),rectangle.getPosition().getY());

        ((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY());

        ((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY()+rectangle.getSize().height);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().getX(),rectangle.getPosition().getY()+rectangle.getSize().height);

        ((GeneralPath)shape).closePath();
    }
}
