package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ResizeState extends State{
    private Page page;
    public ResizeState(Page page) {
        this.page = page;
    }


    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){

        }

    }
}
