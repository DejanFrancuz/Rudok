package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState extends State{
    private Slot med; //save the Mediator
    public SelectState(Slot md) {
        med = md;
    }


    public void mousePressed(MouseEvent e) {

        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){

        }
    }
}
