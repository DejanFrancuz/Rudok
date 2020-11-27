package dsw.rudok.app.core;


public abstract class ApplicationFramework {

    protected Gui gui;
    protected Repository repository;
    protected ErrorHandler errorHandler;

    public ApplicationFramework() {
    }

    public abstract void run();
    public void initialise(Gui gui,Repository repository,ErrorHandler errorHandler){
        this.gui = gui;
        this.repository=repository;
        this.errorHandler=errorHandler;
        this.errorHandler.addSubs(gui);
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Gui getGui() {
        return gui;
    }

    public Repository getRepository() {
        return repository;
    }

    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }
}
