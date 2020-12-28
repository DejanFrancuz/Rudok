package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.commands.AddDeviceCommand;
import dsw.rudok.app.commands.ShapeEnum;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.factory.RectangleFactory;
import dsw.rudok.app.repository.factory.SlotFactory;

import java.awt.*;
import java.awt.event.MouseEvent;

public class RectangleState extends State{
    private Page page;
    public RectangleState(Page page) {
        this.page = page;
    }


    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){
            if (page.getPageModel().getSlotatPosition(position)== null){
              SlotFactory factory= new RectangleFactory();
                Slot slot= factory.makeSlot(position,page.getPageModel().getDeviceCount());
                page.getPageModel().addSlots(slot);
                MainFrame.getInstance().getTree().addSlot(slot,page);
               // page.getCommandManager().addCommand(new AddDeviceCommand(page.getPageModel(),page.getPageSelectionModel(),position, ShapeEnum.RECTANGLE));
            }

            }
        }
    }

