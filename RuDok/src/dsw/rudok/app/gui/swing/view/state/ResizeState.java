package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.commands.AddDeviceCommand;
import dsw.rudok.app.commands.ShapeEnum;
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
import java.util.ArrayList;
import java.util.Iterator;

public class ResizeState extends State {
    private Page page;
    Slot slot = null;
    int p = -1;
    static final int handleSize = 14;
    SlotHandler handler = new SlotHandler();
    Handle handle;

    public ResizeState(Page page) {
        this.page = page;
    }

    Dimension d = null;


    public void mousePressed(MouseEvent e) {
        Point2D position = e.getPoint();
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (page.getPageModel().getSlotatPosition((Point) position) != null) {
                slot = page.getPageModel().getSlotatPosition((Point) position);
                handle = getHandleForPoint(slot, position);
                if (handle != null) {
                    p = 1;
                    slot.addSubs(page);
                    d = slot.getSize();
                }

            }
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (p == 1) {
            handler.transform(slot, page, TransformType.RESIZE, e.getPoint(), handle);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (p == 1) {
            ArrayList<String> list=new ArrayList<>();
            for(Slot s:page.getPageSelectionModel().getSelectionList()){
                list.add(s.getName());
            }
        page.getCommandManager().addCommand(new AddDeviceCommand(page.getPageModel(), page.getPageSelectionModel(), e.getPoint(), ShapeEnum.RESIZE, list, d, slot.getSize()));
        }
        p = -1;

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
    public Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition ){
        double x=0, y=0;
        if(handlePosition == Handle.NorthWest || handlePosition == Handle.North || handlePosition == Handle.NorthEast){
            y = topLeft.getY();
        }
        if(handlePosition == Handle.East || handlePosition == Handle.West){
            y = topLeft.getY()+size.getHeight()/2;
        }
        if(handlePosition == Handle.SouthWest || handlePosition == Handle.South || handlePosition == Handle.SouthEast){
            y = topLeft.getY() + size.getHeight();
        }
        if(handlePosition == Handle.NorthWest || handlePosition == Handle.West || handlePosition == Handle.SouthWest){
            x = topLeft.getX();
        }
        if(handlePosition == Handle.North || handlePosition == Handle.South){
            x = topLeft.getX() + size.getWidth()/2;
        }
        if(handlePosition == Handle.NorthEast || handlePosition == Handle.East || handlePosition == Handle.SouthEast){
            x = topLeft.getX() + size.getWidth();
        }
        return new Point2D.Double(x,y);
    }
    }

