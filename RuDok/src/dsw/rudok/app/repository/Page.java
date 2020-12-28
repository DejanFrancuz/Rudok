package dsw.rudok.app.repository;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.commands.AddDeviceCommand;
import dsw.rudok.app.commands.CommandManager;
import dsw.rudok.app.commands.ShapeEnum;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.gui.swing.view.state.StateManager;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page extends RuNodeComposite implements Serializable,ISubscriber {

    private PageTab pageTab;
    List<ISubscriber> subscribers;
    private PageModel pageModel = new PageModel();
    private PageSelectionModel pageSelectionModel=new PageSelectionModel();
    boolean rotate;
    private CommandManager commandManager=new CommandManager();
    private Rectangle2D selectionRectangle=null;
    private Point2D lastPosition=null;


    public Page(String name, RuNode parent) {
        super(name, parent);
        getCommandManager().setPage(this);
    }
    private StateManager stateManager= new StateManager(this);

    public void addChild(RuNode child) {
        if (child != null && child instanceof Slot) {
            Slot slot = (Slot) child;
            if (!this.getChildren().contains(slot)) {
                this.getChildren().add(slot);
                notifyObs(slot);
                //getCommandManager().addCommand(new AddDeviceCommand(getPageModel(),getPageSelectionModel(),slot.getPosition(), ShapeEnum.RECTANGLE));
            }
        }
    }

    public void startTriangleState(){stateManager.setTriangleState(); }
    public void startSelectState() {
        stateManager.setSelectState();
    }
    public void startRectangleState(){
        stateManager.setRectangleState();
    }
    public void startCircleState(){stateManager.setCircleState();}
    public void startResizeState(){stateManager.setResizeState();}
    public void startMoveState(){stateManager.setMoveState();}
    public void startRotateState(){stateManager.setRotateState();}
    public void startDeleteSlotState(){stateManager.setDeleteSlotState();}
    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public Rectangle2D getSelectionRectangle() {
        return selectionRectangle;
    }

    public Point2D getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(Point2D lastPosition) {
        this.lastPosition = lastPosition;
    }

    public void setSelectionRectangle(Rectangle2D selectionRectangle) {
        this.selectionRectangle = selectionRectangle;
        notifyObs(selectionRectangle);
    }

    @Override
    public void removeChild(int index) {
        notifyObs(index);
    }

    public PageSelectionModel getPageSelectionModel() {
        return pageSelectionModel;
    }

    public void setPageSelectionModel(PageSelectionModel pageSelectionModel) {
        this.pageSelectionModel = pageSelectionModel;
    }

    public PageTab getPageTab() {
        return pageTab;
    }

    public void setPageTab(PageTab pageTab) {
        this.pageTab = pageTab;
    }

    public boolean isRotate() {
        return rotate;
    }

    public void setRotate(boolean rotate) {
        this.rotate = rotate;
        notifyObs(rotate);
    }



    @Override
    public void addSubs(ISubscriber sub) {
        if (sub == null)
            return;
        if (this.subscribers == null)
            this.subscribers = new ArrayList<>();
        if (this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }



    @Override
    public void removeSubs(ISubscriber sub) {
        if (sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifyObs(Object notif) {
        if (notif == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for (ISubscriber listener : subscribers) {

            listener.update(notif);
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    public PageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(PageModel pageModel) {
        this.pageModel = pageModel;
    }


    @Override
    public void update(Object notif) {
        notifyObs(new Object());
    }
}
