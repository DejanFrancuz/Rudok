package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.gui.swing.view.Handle;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.*;
import dsw.rudok.app.repository.factory.CircleFactory;
import dsw.rudok.app.repository.factory.RectangleFactory;
import dsw.rudok.app.repository.factory.SlotFactory;
import dsw.rudok.app.repository.factory.TriangleFactory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class SelectState extends State{
    private Page page;
    private int elementInMotion = -1;
    public SelectState(Page page) {
        this.page = page;
    }

    public void mousePressed(MouseEvent e){
        if(!e.isControlDown()){
            page.getPageSelectionModel().removeAllFromSelectionList();
        }
        Point position = e.getPoint();
        if(e.getButton()==MouseEvent.BUTTON1){
            elementInMotion=page.getPageModel().getIndexAtPosition(position);
            if(elementInMotion != -1){
                Slot element=page.getPageModel().getSlotAt(elementInMotion);
                element.addSubs(page);
                if (page.getPageSelectionModel().isElementSelected(element)){
                    page.getPageSelectionModel().removeFromSelectionList(element);
                    System.out.println("if");
                }else{
                    page.getPageSelectionModel().addToSelectionList(element);
                    System.out.println("else");
                }
            }else{
                //nije pogodjen nijedan element
            }

    }
    }
}
