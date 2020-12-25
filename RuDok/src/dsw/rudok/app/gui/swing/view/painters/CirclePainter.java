package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.CircleSlot;
import dsw.rudok.app.repository.element.Slot;

import java.awt.geom.GeneralPath;

public class CirclePainter extends SlotPainter implements ISubscriber {


    public CirclePainter(Slot slot) {
        super(slot);
        CircleSlot or = (CircleSlot) slot;
        slot.addSubs(this);

        shape=new GeneralPath();

        ((GeneralPath)shape).moveTo(or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());

        ((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY(),
                or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight()/2);

        ((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight(),
                or.getPosition().getX()+or.getSize().getWidth()/2, or.getPosition().getY()+or.getSize().getHeight());

        ((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight(),
                or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight()/2);


        ((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY(),
                or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());
    }

    @Override
    public void update(Object notif) {
        Slot slot=(Slot)notif;
        CircleSlot or = (CircleSlot) slot;

        shape=new GeneralPath();

        ((GeneralPath)shape).moveTo(or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());

        ((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY(),
                or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight()/2);

        ((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight(),
                or.getPosition().getX()+or.getSize().getWidth()/2, or.getPosition().getY()+or.getSize().getHeight());

        ((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight(),
                or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight()/2);


        ((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY(),
                or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());

    }
}
