package dsw.rudok.app;

import dsw.rudok.app.commands.CommandManager;
import dsw.rudok.app.core.*;
import dsw.rudok.app.errorHandler.ErrorHandlerImpl;
import dsw.rudok.app.gui.swing.SwingGui;
import dsw.rudok.app.repository.RepositoryImpl;

import java.awt.*;

public class AppCore extends ApplicationFramework {

    private static AppCore instance;

    private AppCore(){

    }
    public static AppCore getInstance(){
        if(instance==null){
            instance = new AppCore();
        }
        return instance;
    }
    public void run(){
        this.gui.start();
    }
    public static void main(String[] args){
        Repository repository=new RepositoryImpl();
        Gui gui= new SwingGui(repository);
        ErrorHandler errorHandler=new ErrorHandlerImpl();
        Command command= new CommandManager();
        ApplicationFramework appCore= AppCore.getInstance();
        appCore.initialise(gui,repository,errorHandler,command);
        appCore.run();
    }
}
