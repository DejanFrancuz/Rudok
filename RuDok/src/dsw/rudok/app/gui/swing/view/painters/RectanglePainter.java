package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.element.RectangleDevice;
import dsw.rudok.app.repository.element.SlotDevice;

import java.awt.geom.GeneralPath;

public class RectanglePainter extends DevicePainter{

    public RectanglePainter(SlotDevice device) {
        super(device);
        RectangleDevice rectangle = (RectangleDevice) device;

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(rectangle.getPosition().getX(),rectangle.getPosition().getY());

        ((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY());

        ((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY()+rectangle.getSize().height);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().getX(),rectangle.getPosition().getY()+rectangle.getSize().height);

        ((GeneralPath)shape).closePath();
    }
}
