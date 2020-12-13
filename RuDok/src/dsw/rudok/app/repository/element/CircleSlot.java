package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.CirclePainter;
import dsw.rudok.app.gui.swing.view.painters.RectanglePainter;
import dsw.rudok.app.repository.node.RuNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class CircleSlot extends Slot{




    public CircleSlot( Dimension size, Point2D position,Stroke stroke, Paint paint,String name) {
        super(size,position,stroke,paint,name);
        slotPainter = new CirclePainter(this);
    }

    public CircleSlot(String name, RuNode parent) {
        super(name, parent);
    }

    public static Slot createDefault(Point position, int index){
        Paint fill = Color.BLACK;
        CircleSlot circle= new CircleSlot(new Dimension(50,50),position,new BasicStroke(),fill,
                "Circle " + index);
        return circle;
    }

    public static void changeSlotSelected(Slot novi, Slot stari) {

        if(!novi.equals(stari)) {
            novi.setPaint(Color.CYAN);

            if (stari != null)
                stari.setPaint(Color.BLACK);
        }
    }
}
/*Paint fill = Color.WHITE;
	    CircleElement or=new CircleElement(position,
	    		                   new Dimension(50,50),
	    		                   new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),
	    		                   fill,
	    		                   Color.BLACK);
        or.setName("Circle " + elemNo);*/

/*Paint fill = Color.WHITE;
        RectangleElement rectangleElement=new RectangleElement(position,
	    		                       new Dimension(80,40),
	    		                      new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),
             	                      fill,
	    		                      Color.BLACK);
        rectangleElement.setName("Rectangle" + elemNo);
		return rectangleElement;*/
