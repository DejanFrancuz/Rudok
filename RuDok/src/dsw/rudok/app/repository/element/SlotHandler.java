package dsw.rudok.app.repository.element;

import java.awt.*;
import java.awt.geom.Point2D;

public class SlotHandler {
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

