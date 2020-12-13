package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.CircleSlot;
import dsw.rudok.app.repository.element.RectangleSlot;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.TriangleSlot;
import dsw.rudok.app.repository.factory.CircleFactory;
import dsw.rudok.app.repository.factory.RectangleFactory;
import dsw.rudok.app.repository.factory.SlotFactory;
import dsw.rudok.app.repository.factory.TriangleFactory;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState extends State{
    private Page med; //save the Mediator
    private Slot slotLastSelected = null;
    public SelectState(Page md) {
        med = md;
    }


    public void mousePressed(MouseEvent e) {


        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){

            if(med.getPageModel().getSlotatPosition(position) != null){
                Slot slotClicked = med.getPageModel().getSlotatPosition(position);




                if(slotClicked instanceof RectangleSlot){
                    SlotFactory factory= new RectangleFactory();
                    factory.change(slotClicked,slotLastSelected);

                    slotLastSelected = slotClicked;

                }
                else if(slotClicked instanceof CircleSlot){
                    SlotFactory factory = new CircleFactory();
                    factory.change(slotClicked,slotLastSelected);

                    slotLastSelected = slotClicked;

                }
                else if(slotClicked instanceof TriangleSlot){
                    SlotFactory factory = new TriangleFactory();
                    factory.change(slotClicked,slotLastSelected);

                    slotLastSelected = slotClicked;
                }
                med.setSelected(slotClicked);

            }
        }
    }
}
