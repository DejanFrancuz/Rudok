package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.Slot;

import java.awt.*;

public class SlotPainter extends  ElementPainter{
    protected Shape shape;
    protected Stroke stroke = new BasicStroke();
    protected Paint paint = Color.BLACK;

    public SlotPainter(Slot device) {
        super(device);
    }
    public void paint(Graphics2D g, Slot element){

        g.setPaint(paint);

        g.setStroke(stroke);
        g.draw(getShape());


        g.fill(getShape());
        if (element instanceof Slot){
            g.setPaint(Color.BLACK);
            Slot device=(Slot)element;
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

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
