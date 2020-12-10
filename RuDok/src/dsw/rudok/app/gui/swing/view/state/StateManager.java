package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;

public class StateManager {
    private State currentState;

    CircleState circleState;
    RectangleState rectangleState;
    SelectState selectState;

    public StateManager(Page page)
    {

        circleState = new CircleState(page);
        rectangleState=new RectangleState(page);
        selectState=new SelectState(page);
        currentState = selectState;
    }

    public void setCircleState() { currentState = circleState; }
    public void setRectangleState(){ currentState = rectangleState; }
    public void setSelectState(){ currentState = selectState; }
    public State getCurrentState() {
        return currentState;
    }
}
