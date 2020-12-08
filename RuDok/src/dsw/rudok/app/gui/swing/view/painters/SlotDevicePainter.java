package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.Slot;
import dsw.rudok.app.repository.element.SlotDevice;

import java.awt.*;

public class SlotDevicePainter extends  ElementPainter{
    protected Shape shape;

    public SlotDevicePainter(SlotDevice device) {
        super(device);
    }
    public void paint(Graphics2D g, SlotDevice element){

        g.setPaint(Color.MAGENTA);

        g.setStroke(element.getStroke());
        g.draw(getShape());
        g.setPaint(element.getPaint());

        g.fill(getShape());

        if (element instanceof SlotDevice){
            g.setPaint(Color.BLACK);
            SlotDevice device=(SlotDevice )element;
            g.drawString(device.getName(), (int)device.getPosition().getX()+10,
                    (int)device.getPosition().getY()+10);
        }
    }

    @Override
    public boolean elementAt(Slot slotDevice, Point pos) {
        return getShape().contains(pos);
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
