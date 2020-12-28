package dsw.rudok.app.gui.swing.view.state;

import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;

public class StateManager {
    private State currentState;

    CircleState circleState;
    RectangleState rectangleState;
    SelectState selectState;
    TriangleState triangleState;
    DeleteSlotState deleteSlotState;
    MoveState moveState;
    ResizeState resizeState;
    RotateState rotateState;
    LassoState lassoState;

    public StateManager(Page page)
    {

        circleState = new CircleState(page);
        rectangleState=new RectangleState(page);
        selectState=new SelectState(page);
        triangleState=new TriangleState(page);
        deleteSlotState=new DeleteSlotState(page);
        moveState=new MoveState(page);
        resizeState=new ResizeState(page);
        rotateState=new RotateState(page);
        lassoState=new LassoState(page);


        currentState = selectState;
    }
    public void setTriangleState(){currentState=triangleState; }
    public void setCircleState() { currentState = circleState; }
    public void setRectangleState(){ currentState = rectangleState; }
    public void setSelectState(){ currentState = selectState; }
    public void setDeleteSlotState(){ currentState = deleteSlotState; }
    public void setResizeState(){ currentState = resizeState; }
    public void setRotateState(){ currentState = rotateState; }
    public void setMoveState(){ currentState = moveState; }
    public void setLassoState(){currentState=lassoState;}

    public CircleState getCircleState() {
        return circleState;
    }

    public RectangleState getRectangleState() {
        return rectangleState;
    }

    public SelectState getSelectState() {
        return selectState;
    }

    public TriangleState getTriangleState() {
        return triangleState;
    }

    public DeleteSlotState getDeleteSlotState() {
        return deleteSlotState;
    }

    public MoveState getMoveState() {
        return moveState;
    }

    public ResizeState getResizeState() {
        return resizeState;
    }

    public RotateState getRotateState() {
        return rotateState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public LassoState getLassoState() {
        return lassoState;
    }
}
