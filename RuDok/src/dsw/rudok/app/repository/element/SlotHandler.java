package dsw.rudok.app.repository.element;


import dsw.rudok.app.gui.swing.view.Handle;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.gui.swing.view.painters.SlotPainter;
import dsw.rudok.app.repository.Page;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class SlotHandler {

    public void transform(Slot novi, Object s, TransformType type, Point2D position) {
        if (type == TransformType.SELECT) {
            Slot stari=(Slot)s;
            if (!novi.equals(stari)) {
                novi.getSlotPainter().setPaint(Color.CYAN);

                if (stari != null)
                    stari.getSlotPainter().setPaint(Color.BLACK);
            }
        }else if(type == TransformType.MOVE){
            //novi.setPosition(position);
           Page p=(Page)s;

            Slot slot=null;
            if(novi instanceof RectangleSlot){
                slot=new RectangleSlot(novi.getSize(),position,novi.getName());
            }else if(novi instanceof CircleSlot){
                slot=new CircleSlot(novi.getSize(),position,novi.getName());
            }else if(novi instanceof TriangleSlot){
                slot=new TriangleSlot(novi.getSize(),position,novi.getName());
            }

            p.getPageModel().removeSlots(novi);
            p.getPageModel().addSlots(slot);
            p.getPageModel().setSelectedSlot(slot);
            slot.getSlotPainter().setPaint(Color.CYAN);
            p.getStateManager().getSelectState().setSlotLastSelected(slot);



        }
    }

}

