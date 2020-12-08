package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.Slot;
import dsw.rudok.app.repository.element.SlotDevice;

import java.awt.*;

public abstract class  ElementPainter{

    public ElementPainter(SlotDevice slotDevice){

        }

        public abstract void paint(Graphics2D g, SlotDevice slotDevice);

    public abstract boolean elementAt(Slot slotDevice, Point pos);
}
