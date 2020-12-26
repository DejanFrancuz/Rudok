package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.gui.swing.view.Handle;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.SlotHandler;
import dsw.rudok.app.repository.element.TransformType;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.Iterator;

public class ResizeState extends State{
    private Page page;
    Slot slot=null;
    int p=-1;
    static final int handleSize = 14;
    SlotHandler handler=new SlotHandler();
    Handle handle;
    public ResizeState(Page page) {
        this.page = page;
    }


    public void mousePressed(MouseEvent e) {
        Point2D position = e.getPoint();
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (page.getPageModel().getSlotatPosition((Point) position) != null) {
                slot = page.getPageModel().getSlotatPosition((Point) position);
                handle = getHandleForPoint(slot, position);
                if (handle != null) {
                    p = 1;
                    slot.addSubs(page);
                }

            }
        }
        }
        public void mouseDragged(MouseEvent e){
        if(p==1){
            handler.transform(slot,page, TransformType.RESIZE,e.getPoint(),handle);
        }
        }
        public void mouseReleased(MouseEvent e){
        p=-1;
        }
    private boolean isPointInHandle(Slot device, Point2D point, Handle handle){
            Point2D handleCenter = getHandlePoint(device.getPosition(), device.getSize(), handle);
            return ( (Math.abs(point.getX()-handleCenter.getX())<=(double)handleSize/2) &&
                    (Math.abs(point.getY()-handleCenter.getY())<=(double)handleSize/2) );
        }
    private Handle getHandleForPoint(Slot slot, Point2D point){
        if(slot == null){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
        }else {

            for (Handle h : Handle.values()) {
                if (isPointInHandle(slot, point, h)) {
                    return h;
                }
            }
        }
        return null;
    }
    public Handle getDeviceAndHandleForPoint(Point2D point){
        Slot slot;

        Iterator<Slot> it = page.getPageModel().getSlotIterator();
        while(it.hasNext()){
            slot = it.next();
            return getHandleForPoint(slot, point);
        }
        return null;
    }
    public void setMouseCursor(Point2D point){

        System.out.println("Nisam ovde puko!");
        Handle handle = getDeviceAndHandleForPoint(point);
        if(handle != null){
            Cursor cursor = null;

            switch(handle){
                case North: cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);break;
                case South: cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);break;
                case East: cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);break;
                case West: cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);break;
                case SouthEast: cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);break;
                case NorthWest: cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);break;
                case SouthWest: cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);break;
                case NorthEast: cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);break;
            }
            //page.getPageTab().setCursor(cursor);
            MainFrame.getInstance().setCursor(cursor);
        }
        else
            //page.getPageTab().setCursor(Cursor.getDefaultCursor());
        MainFrame.getInstance().setCursor(Cursor.getDefaultCursor());
    }
    public Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition ){
        double x=0, y=0;

        // Doređivanje y koordinate

        // Ako su gornji hendlovi
        if(handlePosition == Handle.NorthWest || handlePosition == Handle.North || handlePosition == Handle.NorthEast){
            y = topLeft.getY();
        }
        // Ako su centralni po y osi
        if(handlePosition == Handle.East || handlePosition == Handle.West){
            y = topLeft.getY()+size.getHeight()/2;
        }
        //Ako su donji
        if(handlePosition == Handle.SouthWest || handlePosition == Handle.South || handlePosition == Handle.SouthEast){
            y = topLeft.getY() + size.getHeight();
        }

        // Određivanje x koordinate

        // Ako su levi
        if(handlePosition == Handle.NorthWest || handlePosition == Handle.West || handlePosition == Handle.SouthWest){
            x = topLeft.getX();
        }
        // ako su centralni po x osi
        if(handlePosition == Handle.North || handlePosition == Handle.South){
            x = topLeft.getX() + size.getWidth()/2;
        }
        // ako su desni
        if(handlePosition == Handle.NorthEast || handlePosition == Handle.East || handlePosition == Handle.SouthEast){
            x = topLeft.getX() + size.getWidth();
        }

        return new Point2D.Double(x,y);

    }
    }

