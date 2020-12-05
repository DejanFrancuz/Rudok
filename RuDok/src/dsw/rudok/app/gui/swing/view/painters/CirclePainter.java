package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.element.CircleDevice;
import dsw.rudok.app.repository.element.SlotDevice;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class CirclePainter extends DevicePainter{


    public CirclePainter(SlotDevice device) {
        super(device);
        CircleDevice or = (CircleDevice) device;

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
