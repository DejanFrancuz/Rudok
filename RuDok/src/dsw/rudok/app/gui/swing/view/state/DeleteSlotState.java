package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.commands.AddDeviceCommand;
import dsw.rudok.app.commands.ShapeEnum;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.*;
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
                ShapeEnum shape=null;
                Slot slot=page.getPageModel().getSlotatPosition(position);
                position=(Point) slot.getPosition();
                if(slot instanceof RectangleSlot){
                    shape=ShapeEnum.DELETE_R;
                }else if(slot instanceof CircleSlot){
                    shape=ShapeEnum.DELETE_C;
                }else if(slot instanceof TriangleSlot){
                    shape=ShapeEnum.DELETE_T;
                }
                /*page.getPageModel().removeSlots(slot);
                if(page.getPageSelectionModel().getSelectionList().contains(slot)){
                    page.getPageSelectionModel().removeFromSelectionList(slot);
                }*/
                page.getCommandManager().addCommand(new AddDeviceCommand(page.getPageModel(),page.getPageSelectionModel(),position,shape,page.getPageSelectionModel().getSelectionList(), null,null));
            }
            }

        }
    }


