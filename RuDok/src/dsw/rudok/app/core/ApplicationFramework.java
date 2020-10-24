package dsw.rudok.app.core;



public abstract class ApplicationFramework {

    protected Gui gui;
    protected Repository repository;

    public abstract void run():
    public void initialise(Gui gui,Repository repository){
        this.gui = gui;
        this.repository=repository;
    }
}
