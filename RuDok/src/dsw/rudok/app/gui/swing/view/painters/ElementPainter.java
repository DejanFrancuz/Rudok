package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.element.Slot;

import java.awt.*;

public abstract class  ElementPainter{

    public ElementPainter(Slot slot){

        }
        public abstract void paint(Graphics2D g, Slot slot);

    public abstract boolean elementAt(Slot slot, Point pos);
}
