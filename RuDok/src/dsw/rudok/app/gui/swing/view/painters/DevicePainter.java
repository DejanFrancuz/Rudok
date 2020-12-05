package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.element.SlotDevice;

import java.awt.*;

public abstract class DevicePainter {
    protected Shape shape;

    public DevicePainter(SlotDevice device) {

    }
    public void paint(Graphics2D g, SlotDevice element){

    }

    public boolean isElementAt( Point pos){
        return getShape().contains(pos);
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
