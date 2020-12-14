package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.*;
import dsw.rudok.app.repository.factory.CircleFactory;
import dsw.rudok.app.repository.factory.RectangleFactory;
import dsw.rudok.app.repository.factory.SlotFactory;
import dsw.rudok.app.repository.factory.TriangleFactory;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState extends State{
    private Page med; //save the Mediator
    private Slot slotLastSelected = null;
    SlotHandler handler=new SlotHandler();
    public SelectState(Page md) {
        med = md;
    }


    public void mousePressed(MouseEvent e) {



        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){

            if(med.getPageModel().getSlotatPosition(position) != null){
                Slot slotClicked = med.getPageModel().getSlotatPosition(position);
                handler.transform(slotClicked,slotLastSelected,TransformType.SELECT,null);
                slotLastSelected=slotClicked;
                med.setSelected(slotClicked);
            }
        }
    }
}
