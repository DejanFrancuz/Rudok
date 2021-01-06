package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.SlotHandler;
import dsw.rudok.app.repository.element.TransformType;

import java.awt.*;
import java.awt.event.MouseEvent;

public class OpenSlotState extends State{

    private Page page;
    Slot slot=null;
    SlotHandler handler=new SlotHandler();
    Point position = null;

    public OpenSlotState(Page page) {

        this.page = page;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){
            if(page.getPageModel().getSlotatPosition(position) != null && page.getPageSelectionModel().isElementSelected(page.getPageModel().getSlotatPosition(position))) {
                slot=page.getPageModel().getSlotatPosition(position);
                slot.addSubs(page);
                handler.transform(slot,page, TransformType.SLOT_OPENING,position,null);
                }
            }
    }
}
