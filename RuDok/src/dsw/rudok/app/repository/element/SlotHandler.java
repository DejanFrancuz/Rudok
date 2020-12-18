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
        }else if(type==TransformType.ROTATE){
            Handle handle=(Handle)s;
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
            Handle handle=(Handle)s;
            Slot slot=null;
            if(novi instanceof TriangleSlot) {
                switch (handle) {
                    case South:
                        novi.getSize().setSize(novi.getSize().getWidth(),(position.getY())+novi.getSize().getHeight());
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

