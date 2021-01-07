package dsw.rudok.app.commands;

import java.io.Serializable;

public abstract class AbstractCommand implements Serializable {
    public abstract void doCommand();
    public abstract void undoCommand();
    public abstract void resizeCommand();
    public abstract void rotateCommand();
    public abstract void moveCommand();
    public abstract void undoResize();
    public abstract void undoMove();
    public abstract void undoRotate();

}
