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

    public void transform(Slot novi, Slot stari, TransformType type, Point2D position) {
        if (type == TransformType.SELECT) {

            if (!novi.equals(stari)) {
                novi.getSlotPainter().setPaint(Color.CYAN);

                if (stari != null)
                    stari.getSlotPainter().setPaint(Color.BLACK);
            }
        }else if(type == TransformType.MOVE){
            //novi.setPosition(position);
            Slot slot=null;
            ((PageTab)MainFrame.getInstance().getjPanel()).getPage().getPageModel().removeSlots(novi);
            if(novi instanceof RectangleSlot){
                slot=new RectangleSlot(novi.getSize(),position,novi.getName());
            }else if(novi instanceof CircleSlot){
                slot=new CircleSlot(novi.getSize(),position,novi.getName());
            }else if(novi instanceof TriangleSlot){
                slot=new TriangleSlot(novi.getSize(),position,novi.getName());
            }
            ((PageTab)MainFrame.getInstance().getjPanel()).getPage().getPageModel().addSlots(slot);
            ((PageTab)MainFrame.getInstance().getjPanel()).getPage().getPageModel().setSelectedSlot(slot);
            //transform(slot,((PageTab)MainFrame.getInstance().getjPanel()).getPage().getStateManager().getSelectState().getSlotLastSelected(),TransformType.SELECT,position);
            slot.getSlotPainter().setPaint(Color.CYAN);
            ((PageTab)MainFrame.getInstance().getjPanel()).getPage().getStateManager().getSelectState().setSlotLastSelected(slot);




        }
    }

}

