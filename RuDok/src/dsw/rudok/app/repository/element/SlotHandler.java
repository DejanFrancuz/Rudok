package dsw.rudok.app.repository.element;


import dsw.rudok.app.gui.swing.view.Handle;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class SlotHandler {
    static final int handleSize = 7;

    public void transform(Slot novi, Slot stari, TransformType type, Point2D position) {
        if (type == TransformType.SELECT) {
            if (!novi.equals(stari)) {
                novi.setPaint(Color.CYAN);

                if (stari != null)
                    stari.setPaint(Color.BLACK);
            }
        }
    }

}

