package dsw.rudok.app.repository.element;


import dsw.rudok.app.AppCore;
import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.gui.swing.view.Handle;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.gui.swing.view.painters.SlotPainter;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.factory.RectangleFactory;
import dsw.rudok.app.repository.factory.SlotFactory;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class SlotHandler {

    public void transform(Slot novi, Page p, TransformType type, Point2D position,Handle handle) {
        if(type == TransformType.MOVE){
            novi.setPosition(position);
            /*double distance=calculate1(novi.getPosition(),position);
            ArrayList<Slot> list= p.getPageSelectionModel().getSelectionList();
            for(Slot s: list){
               // Point p=new Point(s.getPosition().getX())
                s.setPosition(s.getPosition());
            }*/
        }else if(type==TransformType.ROTATE){
            Point2D point=p.getStateManager().getRotateState().getHandlePoint(novi.getPosition(),novi.getSize(),handle);
            double angle=angleBetweenTwoPointsWithFixedPoint(point.getX(),point.getY(),position.getX(),position.getY(),novi.getPosition().getX(),novi.getPosition().getY())*50;
           // novi.setAngle(angleBetweenTwoPointsWithFixedPoint(point.getX(),point.getY(),position.getX(),position.getY(),novi.getPosition().getX(),novi.getPosition().getY())*50);
            ArrayList<Slot> list= p.getPageSelectionModel().getSelectionList();
            for(Slot s: list){
                s.setAngle(angle);
            }
        }else if(type==TransformType.RESIZE){
            Dimension d=null;
            switch (handle){
                case NorthWest:
                    d=new Dimension((int)calculate(novi.getNorthEast().getX(),novi.getNorthEast().getY(),position.getX(),position.getY()),(int)calculate(novi.getSouthWest().getX(),novi.getSouthWest().getY(),position.getX(),position.getY()));
                    break;
                case NorthEast:
                    d=new Dimension((int)calculate(position.getX(),position.getY(),novi.getPosition().getX(),novi.getPosition().getY()),(int)calculate(novi.getSouthEast().getX(),novi.getSouthEast().getY(),position.getX(),position.getY()));
                    break;
                case North:
                    d=new Dimension((int)novi.getSize().getWidth(),(int)calculate(novi.getSouth().getX(),novi.getSouth().getY(),position.getX(),position.getY()));
                    break;
                case East:
                    d=new Dimension((int)calculate(novi.getWest().getX(),novi.getWest().getY(),position.getX(),position.getY()),(int)novi.getSize().getHeight());
                    break;
                case West:
                    d=new Dimension((int)calculate(novi.getEast().getX(),novi.getEast().getY(),position.getX(),position.getY()),(int)novi.getSize().getHeight());
                    break;
                case South:
                    d=new Dimension((int)novi.getSize().getWidth(),(int)calculate(novi.getNorth().getX(),novi.getNorth().getY(),position.getX(),position.getY()));
                    break;
                case SouthWest:
                    d=new Dimension((int)calculate(novi.getSouthEast().getX(),novi.getSouthEast().getY(),position.getX(),position.getY()),(int)calculate(novi.getPosition().getX(),novi.getPosition().getY(),position.getX(),position.getY()));
                    break;
                case SouthEast:
                    d=new Dimension((int)calculate(novi.getSouthWest().getX(),novi.getSouthWest().getY(),position.getX(),position.getY()),(int)calculate(novi.getNorthEast().getX(),novi.getNorthEast().getY(),position.getX(),position.getY()));
                    break;
            }
            //novi.setSize(d);
            ArrayList<Slot> list= p.getPageSelectionModel().getSelectionList();
            for(Slot s: list){
                System.out.println(s);
                s.setSize(d);
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
    public double calculate(double x1,double y1,double x2,double y2) {
        return Point2D.distance(x1,y1,x2,y2);
    }
    public double calculate1(Point2D point1,Point2D point2){ return Point2D.distance(point1.getX(),point1.getY(),point2.getX(),point2.getY());}
}

