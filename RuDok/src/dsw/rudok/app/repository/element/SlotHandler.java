package dsw.rudok.app.repository.element;


import dsw.rudok.app.gui.swing.view.Handle;
import dsw.rudok.app.gui.swing.view.painters.SlotPainter;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class SlotHandler {

    public void transform(Slot novi, Slot stari, TransformType type, Point2D position) {
        if (type == TransformType.SELECT) {

            if (!novi.equals(stari)) {
                novi.getSlotPainter().setPaint(Color.CYAN);

                if (stari != null)
                    stari.getSlotPainter().setPaint(Color.BLACK);
            }
        }else if(type == TransformType.MOVE){
          //  novi.setPosition(position);
        }
    }

}

