package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.SlotHandler;
import dsw.rudok.app.repository.element.TransformType;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class MoveState extends State{
    private Page page;
    SlotHandler handler=new SlotHandler();
    boolean hit=false;
    public MoveState(Page page) {
        this.page = page;
    }


    public void mousePressed(MouseEvent e) {

        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){
            if(page.getPageModel().getSlotatPosition(position) != null) {
                hit=true;
            }
        }

    }
    public void mouseDragged(MouseEvent e) {
        if (hit) {
            Point position = e.getPoint();
            Slot slot = page.getPageModel().getSelectedSlot();
            handler.transform(slot, page, TransformType.MOVE, position, null);
            page.getPageModel().setSelectedSlot(slot);
        }
    }
    public void mouseReleased(MouseEvent e){
        hit=false;
    }
}
