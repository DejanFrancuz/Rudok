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
    public MoveState(Page page) {
        this.page = page;
    }


    public void mousePressed(MouseEvent e) {

        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){

        }

    }
    public void mouseDragged(MouseEvent e){
        Point position=e.getPoint();
        Slot slot=page.getSelected();
        handler.transform(slot,page, TransformType.MOVE,position,null);
    }
    public void mouseReleased(MouseEvent e){

    }
}
