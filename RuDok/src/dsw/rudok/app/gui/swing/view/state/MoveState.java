package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.commands.AddDeviceCommand;
import dsw.rudok.app.commands.ShapeEnum;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.SlotHandler;
import dsw.rudok.app.repository.element.TransformType;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class MoveState extends State{
    private Page page;
    Slot slot=null;
    SlotHandler handler=new SlotHandler();
    boolean hit=false;
    public MoveState(Page page) {
        this.page = page;
    }
    Point position=null;
    Point first=null;

    public void mousePressed(MouseEvent e) {

        position = e.getPoint();
        if (e.getButton()==MouseEvent.BUTTON1){
            if(page.getPageModel().getSlotatPosition(position) != null && page.getPageSelectionModel().isElementSelected(page.getPageModel().getSlotatPosition(position))) {
                slot=page.getPageModel().getSlotatPosition(position);
                slot.addSubs(page);
                hit=true;
                first= (Point) slot.getPosition();
            }
        }

    }
    public void mouseDragged(MouseEvent e) {
        if (hit) {
            position = e.getPoint();
            handler.transform(slot, page, TransformType.MOVE, position, null);
        }
    }
    public void mouseReleased(MouseEvent e) {
        if (hit) {
            page.getCommandManager().addCommand(new AddDeviceCommand(page.getPageModel(), page.getPageSelectionModel(), slot.getPosition(), ShapeEnum.MOVE, null, first, slot));
        }
        hit = false;
    }
}
