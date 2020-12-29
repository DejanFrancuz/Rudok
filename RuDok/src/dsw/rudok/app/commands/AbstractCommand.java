package dsw.rudok.app.commands;

public abstract class AbstractCommand {
    public abstract void doCommand();
    public abstract void undoCommand();
    public abstract void resizeCommand();
    public abstract void rotateCommand();
    public abstract void moveCommand();
    public abstract void undoResize();
    public abstract void undoMove();
    public abstract void undoRotate();

}
