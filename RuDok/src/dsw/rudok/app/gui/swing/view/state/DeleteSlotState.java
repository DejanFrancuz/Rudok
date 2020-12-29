package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.TransformType;
import dsw.rudok.app.repository.factory.RectangleFactory;
import dsw.rudok.app.repository.factory.SlotFactory;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DeleteSlotState extends State{
    private Page page;
    public DeleteSlotState(Page page) {
        this.page = page;
    }


    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){
            if(page.getPageModel().getSlotatPosition(position) != null){
                System.out.println(page.getPageModel().getSlots());
                Slot slot=page.getPageModel().getSlotatPosition(position);
                page.getPageModel().removeSlots(slot);
                if(page.getPageSelectionModel().getSelectionList().contains(slot)){
                    page.getPageSelectionModel().removeFromSelectionList(slot);
                }

            }
            }

        }
    }


