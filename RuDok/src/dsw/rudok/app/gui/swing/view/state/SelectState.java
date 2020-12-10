package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState extends State{
    private Page med; //save the Mediator
    public SelectState(Page md) {
        med = md;
    }


    public void mousePressed(MouseEvent e) {

        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){

        }
    }
}
