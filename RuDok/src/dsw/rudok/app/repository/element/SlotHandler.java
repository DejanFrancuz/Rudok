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
            //Handle handle=(Handle)s;
            Point2D point2D = new Point((int)(novi.position.getX()+novi.getSize().getWidth()),(int)(novi.getPosition().getY()-novi.getSize().getHeight()));

            Point2D center=new Point2D.Double(novi.getSize().getWidth()/2,novi.getSize().getHeight()/2);
            Point2D point=new Point2D.Double();
            switch (handle){
                case NorthEast:
                    point=novi.getNorthEast(novi);
                case NorthWest:
                    point=novi.getPosition();
                case SouthEast:
                    point=novi.getSouthEast(novi);
                case SouthWest:
                    point=novi.getSouthWest(novi);
            }
            Line2D line1= new Line2D.Double(center,point);
            Line2D line2=new Line2D.Double(center,position);
            /*double slope1 = line1.getY1() - line1.getY2() / line1.getX1() - line1.getX2();
            double slope2 = line2.getY1() - line2.getY2() / line2.getX1() - line2.getX2();
            double angle = Math.atan((slope1 - slope2) / (1 - (slope1 * slope2)));
            */
            novi.setAngle(angleBetween2Lines(line1,line2));
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
                        d=new Dimension((int)novi.calculateDistanceBetweenPointsWithPoint2D(position.getX(),position.getY(),novi.getPosition().getX(),novi.getPosition().getY()),(int)novi.getSize().getWidth());
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
            }
        }
        /*else if(type == TransformType.RESIZE){


            Page p=(Page)s;
            Slot slot=null;
            Handle start=(Handle)s;
            Point2D startPoint=novi.getSouth(novi);

            if(novi instanceof RectangleSlot){

                RectangleSlot novii= (RectangleSlot) novi;
                double vrednostPovlacenja = novii.calculateDistanceBetweenPointsWithPoint2D(position.getX(),position.getY(),startPoint.getX(),startPoint.getY());

                if(start.equals(Handle.NorthEast)){

                }
                else if(start.equals(Handle.North)){

                }
                else if(start.equals(Handle.South)){

                }
                else if(start.equals(Handle.East)){

                    int novaSirina = (int)(novii.getSize().getWidth() + vrednostPovlacenja);
                    int visina =(int) novii.getSize().getHeight();


                    slot = new RectangleSlot(new Dimension(novaSirina,visina),novii.getPosition(), novii.getName());
                }
                else if(start.equals(Handle.West)){

                }
                else if(start.equals(Handle.NorthWest)){

                }
                else if(start.equals(Handle.SouthEast)){

                }
                else if(start.equals(Handle.SouthWest)){

                }

            }
            else if(novi instanceof CircleSlot){

            }
            else if(novi instanceof TriangleSlot){

            }

            p.getPageModel().removeSlots(novi);
            p.getPageModel().addSlots(slot);
            p.getPageModel().setSelectedSlot(slot);
            slot.getSlotPainter().setPaint(Color.CYAN);
            p.getStateManager().getSelectState().setSlotLastSelected(slot);

        }*/
    }
    public static double angleBetween2Lines(Line2D line1, Line2D line2)
    {
        double angle1 = Math.atan2(line1.getY1() - line1.getY2(),
                line1.getX1() - line1.getX2());
        double angle2 = Math.atan2(line2.getY1() - line2.getY2(),
                line2.getX1() - line2.getX2());
        return angle1-angle2;
    }

}

