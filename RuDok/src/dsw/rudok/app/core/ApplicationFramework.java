package dsw.rudok.app.core;


import dsw.rudok.app.AppCore;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.serialization.SerializationInterface;

public abstract class ApplicationFramework {

    protected Gui gui;
    protected Repository repository;
    protected ErrorHandler errorHandler;
    protected Command command;
    protected SerializationInterface serializationInterface;

    public ApplicationFramework() {
    }

    public abstract void run();
    public void initialise(Gui gui,Repository repository,ErrorHandler errorHandler,Command command,SerializationInterface serializationInterface){
        this.gui = gui;
        this.repository=repository;
        this.errorHandler=errorHandler;
        this.command=command;
        this.errorHandler.addSubs(gui);
        this.command.addSubs(gui);
        this.serializationInterface = serializationInterface;
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

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public SerializationInterface getSerializationInterface() {
        return serializationInterface;
    }

    public void setSerializationInterface(SerializationInterface serializationInterface) {
        this.serializationInterface = serializationInterface;
    }
}
