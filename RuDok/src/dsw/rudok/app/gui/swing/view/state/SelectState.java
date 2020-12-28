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
    public SelectState(Page page) {
        this.page = page;
    }

    public void mousePressed(MouseEvent e){
        if(!e.isControlDown()){
            page.getPageSelectionModel().removeAllFromSelectionList();
        }
        Point position = e.getPoint();
        if(e.getButton()==MouseEvent.BUTTON1) {
            if (page.getPageModel().getSlotatPosition(position) != null) {
                Slot slot = page.getPageModel().getSlotatPosition(position);
                slot.addSubs(page);
                if(page.getPageSelectionModel().isElementSelected(slot)){
                    page.getPageSelectionModel().removeFromSelectionList(slot);
                }else{
                    page.getPageSelectionModel().addToSelectionList(slot);
                    System.out.println(page.getPageSelectionModel().getSelectionList());
                }
            }
        }
    }
    public void mouseDragged(MouseEvent e){
        page.getStateManager().setLassoState();
    }
}
