package dsw.rudok.app.repository.element;


import dsw.rudok.app.gui.swing.view.Handle;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.gui.swing.view.painters.SlotPainter;
import dsw.rudok.app.repository.Page;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class SlotHandler {

    public void transform(Slot novi, Object s, TransformType type, Point2D position,Handle handle) {
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
        }else if(type==TransformType.ROTATE){
            Page p=(Page)s;
            Point2D point=p.getStateManager().getRotateState().getHandlePoint(novi.getPosition(),novi.getSize(),handle);

            Line2D line1= new Line2D.Double(novi.getPosition(),position);
            Line2D line2=new Line2D.Double(new Point(0,0),new Point(0,100));
            /*double slope1 = line1.getY1() - line1.getY2() / line1.getX1() - line1.getX2();
            double slope2 = line2.getY1() - line2.getY2() / line2.getX1() - line2.getX2();
            double angle = Math.atan((slope1 - slope2) / (1 - (slope1 * slope2)));*/
            novi.setAngle(angleBetweenTwoPointsWithFixedPoint(point.getX(),point.getY(),position.getX(),position.getY(),novi.getPosition().getX(),novi.getPosition().getY())*50);
            //novi.setAngle(angleBetween2Lines(line2,line1));

        }else if(type==TransformType.RESIZE){
            //Handle handle=(Handle)s;
            Slot slot=null;
            Dimension d=null;
            if(novi instanceof TriangleSlot) {
                switch (handle) {
                    case South:
                        d=new Dimension((int) novi.getSize().getHeight(),(int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getPosition().getX(),novi.getPosition().getY(),position.getX(),position.getY()));
                    break;
                        case North:
                        d=new Dimension((int) novi.getSize().getHeight(),(int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getPosition().getX(),novi.getPosition().getY(),position.getX(),position.getY()));
                    break;
                        case NorthEast:
                        d=new Dimension((int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getPosition().getX(),novi.getPosition().getY(),position.getX(),position.getY()),(int)novi.getSize().getWidth());
                    break;
                    case NorthWest:
                        d=new Dimension((int)novi.getSize().getHeight(),(int)novi.calculateDistanceBetweenPointsWithPoint2D(position.getX(),position.getY(),novi.getPosition().getX(),novi.getPosition().getY()));
                        break;
                    default:
                        return;

                }
                if(handle != Handle.East && handle != Handle.West && handle != Handle.SouthEast && handle != Handle.SouthWest) {

                        slot = new TriangleSlot(d, novi.getPosition(), novi.getName());
                    Page p = (Page) s;
                    p.getPageModel().addSlots(slot);
                    p.getPageModel().removeSlots(novi);
                    p.getPageModel().setSelectedSlot(slot);
                    slot.getSlotPainter().setPaint(Color.CYAN);
                    p.getStateManager().getSelectState().setSlotLastSelected(slot);
                }

            }else if(novi instanceof CircleSlot){

                switch (handle) {
                    case North:
                    slot = new CircleSlot(new Dimension((int) (position.getY() - novi.getSouth(novi).getY()), (int) (position.getY() - novi.getSouth(novi).getY())), novi.getPosition(), novi.getName());
                    case NorthEast:
                        slot = new CircleSlot(new Dimension((int) (position.getY() - novi.getSouthEast(novi).getY()), (int) (position.getY() - novi.getSouthEast(novi).getY())), novi.getPosition(), novi.getName());
                    case East:
                        slot = new CircleSlot(new Dimension((int) (position.getY() - novi.getWest(novi).getY()), (int) (position.getY() - novi.getWest(novi).getY())), novi.getPosition(), novi.getName());
                    case West:
                        slot = new CircleSlot(new Dimension((int) (position.getY() - novi.getEast(novi).getY()), (int) (position.getY() - novi.getEast(novi).getY())), novi.getPosition(), novi.getName());
                    case South:
                        slot = new CircleSlot(new Dimension((int) (position.getY() - novi.getSouth(novi).getY()), (int) (position.getY() - novi.getSouth(novi).getY())), novi.getPosition(), novi.getName());
                    case SouthEast:
                        slot = new CircleSlot(new Dimension((int) (position.getY() - novi.getPosition().getY()), (int) (position.getY() - novi.getPosition().getY())), novi.getPosition(), novi.getName());
                    case SouthWest:
                        slot = new CircleSlot(new Dimension((int) (position.getY() - novi.getPosition().getY()), (int) (position.getY() - novi.getPosition().getY())), novi.getPosition(), novi.getName());
                    case NorthWest:
                        slot = new CircleSlot(new Dimension((int) (position.getY() - novi.getSouthEast(novi).getY()), (int) (position.getY() - novi.getSouthEast(novi).getY())), novi.getPosition(), novi.getName());

                }
                slot.getSlotPainter().setPaint(Color.CYAN);
                ((PageTab) MainFrame.getInstance().getjPanel()).getPage().getPageModel().removeSlots(novi);
                ((PageTab) MainFrame.getInstance().getjPanel()).getPage().getPageModel().addSlots(slot);
                ((PageTab) MainFrame.getInstance().getjPanel()).getPage().setSelected(slot);
            }else if(novi instanceof RectangleSlot){
                Page p=(Page)s;
                switch (handle){
                    case East:
                        d=new Dimension((int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getPosition().getX(),novi.getPosition().getY(),position.getX(),position.getY()),(int)novi.getSize().getHeight());
                    break;
                        case North:
                            d=new Dimension((int)novi.getSize().getWidth(),(int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getSouth(novi).getX(),novi.getSouth(novi).getY(),position.getX(),position.getY()));
                            break;
                    case NorthWest:
                        d=new Dimension((int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getNorthEast(novi).getX(),novi.getNorthEast(novi).getY(),position.getX(),position.getY()),(int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getSouthWest(novi).getX(),novi.getSouthWest(novi).getY(),position.getX(),position.getY()));
                        break;

                    case NorthEast:
                        d=new Dimension((int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getPosition().getX(),novi.getPosition().getY(),position.getX(),position.getY()),(int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getSouthEast(novi).getX(),novi.getSouthEast(novi).getY(),position.getX(),position.getY()));
                        break;

                    case SouthEast:
                        d=new Dimension((int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getSouthWest(novi).getX(),novi.getSouthWest(novi).getY(),position.getX(),position.getY()),(int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getNorthEast(novi).getX(),novi.getNorthEast(novi).getY(),position.getX(),position.getY()));
                        break;

                    case West:
                        d=new Dimension((int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getEast(novi).getX(),novi.getEast(novi).getY(),position.getX(),position.getY()),(int)novi.getSize().getHeight());
                        break;

                    case South:
                        d=new Dimension((int)novi.getSize().getWidth(),(int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getSouth(novi).getX(),novi.getSouth(novi).getY(),position.getX(),position.getY()));
                        break;

                    case SouthWest:
                        d=new Dimension((int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getSouthEast(novi).getX(),novi.getSouthEast(novi).getY(),position.getX(),position.getY()),(int)novi.calculateDistanceBetweenPointsWithPoint2D(novi.getPosition().getX(),novi.getPosition().getY(),position.getX(),position.getY()));
                        break;

                }
               slot=new RectangleSlot(d,novi.getPosition(),novi.getName());
                p.getPageModel().removeSlots(novi);
                p.getPageModel().addSlots(slot);
                p.getPageModel().setSelectedSlot(slot);
                slot.getSlotPainter().setPaint(Color.CYAN);
                p.getStateManager().getSelectState().setSlotLastSelected(slot);
            }
        }
    }
    public static double angleBetweenTwoPointsWithFixedPoint(double point1X, double point1Y,
                                                             double point2X, double point2Y,
                                                             double fixedX, double fixedY) {

        double angle1 = Math.atan2(point1Y - fixedY, point1X - fixedX);
        double angle2 = Math.atan2(point2Y - fixedY, point2X - fixedX);

        return angle1 - angle2;
    }
    public double angleBetween2Lines(Line2D line1, Line2D line2)
    {
        double angle1 = Math.atan2(line1.getY1() - line1.getY2(),
                line1.getX1() - line1.getX2());
        double angle2 = Math.atan2(line2.getY1() - line2.getY2(),
                line2.getX1() - line2.getX2());
        return angle1-angle2;
    }

}

