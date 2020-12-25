package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.RectangleSlot;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.TriangleSlot;

import java.awt.geom.GeneralPath;

public class TrianglePainter extends SlotPainter implements ISubscriber {

    public TrianglePainter(Slot slot) {
        super(slot);
        TriangleSlot triangle= (TriangleSlot) slot;
        slot.addSubs(this);

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(triangle.getPosition().getX(),triangle.getPosition().getY());

        ((GeneralPath)shape).lineTo(triangle.getPosition().getX()+triangle.getSize().width,triangle.getPosition().getY());

        ((GeneralPath)shape).lineTo(triangle.getPosition().getX()+triangle.getSize().width / 2,triangle.getPosition().getY()+triangle.getSize().height );


        ((GeneralPath)shape).closePath();
    }

    @Override
    public void update(Object notif) {
        Slot slot=(Slot)notif;
        TriangleSlot triangle= (TriangleSlot) slot;

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(triangle.getPosition().getX(),triangle.getPosition().getY());

        ((GeneralPath)shape).lineTo(triangle.getPosition().getX()+triangle.getSize().width,triangle.getPosition().getY());

        ((GeneralPath)shape).lineTo(triangle.getPosition().getX()+triangle.getSize().width / 2,triangle.getPosition().getY()+triangle.getSize().height );


        ((GeneralPath)shape).closePath();
    }
}
