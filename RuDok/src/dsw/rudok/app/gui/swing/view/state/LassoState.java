package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.RectangleSlot;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.SlotHandler;
import dsw.rudok.app.repository.element.TransformType;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

public class LassoState extends State{
    private Page page;
    Slot slot=null;
    SlotHandler handler=new SlotHandler();
    ArrayList<Slot> selected=new ArrayList<>();
    public LassoState(Page page) {
        this.page = page;
    }


    public void mouseDragged(MouseEvent e) {

            Point position = e.getPoint();
            Dimension d=new Dimension((int)handler.calculate1(page.getLastPosition(),new Point2D.Double(position.getX(),page.getLastPosition().getY())),(int)handler.calculate1(page.getLastPosition(),new Point2D.Double(page.getLastPosition().getX(),position.getY())));
            page.setSelectionRectangle(new Rectangle((Point) page.getLastPosition(),d));


        Iterator<Slot> it=page.getPageModel().getSlotIterator();
        while(it.hasNext()){
            Slot slot=it.next();
            if(page.getSelectionRectangle().intersects(slot.getPosition().getX(),slot.getPosition().getY(),slot.getSize().width,slot.getSize().getHeight())){
                selected.add(slot);
            }
        }
        }

    public void mouseReleased(MouseEvent e){
        page.getPageSelectionModel().removeAllFromSelectionList();
        page.getPageSelectionModel().addToSelectionList(selected);
        page.setSelectionRectangle(null);
    }
}

