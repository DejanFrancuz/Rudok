package dsw.rudok.app.commands;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.core.Command;
import dsw.rudok.app.observer.ISubscriber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommandManager implements Command, Serializable {
    private transient List<ISubscriber> subscribers = new ArrayList<>();
    private ArrayList<AbstractCommand> commands = new ArrayList<>();
    private int currentCommand = 0;

    public void addCommand(AbstractCommand command){
        while(currentCommand < commands.size())
            commands.remove(currentCommand);
        commands.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentCommand < commands.size()){
            commands.get(currentCommand++).doCommand();
            notifyObs(EventType.UNDO_ENABLE);
        }
        if(currentCommand==commands.size()){
            notifyObs(EventType.REDO_DISABLE);
        }
    }

    public void undoCommand(){
        if(currentCommand > 0){
            notifyObs(EventType.REDO_ENABLE);
            commands.get(--currentCommand).undoCommand();
        }
        if(currentCommand==0){
            notifyObs(EventType.UNDO_DISABLE);
        }
    }

    public ArrayList<AbstractCommand> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<AbstractCommand> commands) {
        this.commands = commands;
    }

    public int getCurrentCommand() {
        return currentCommand;
    }

    public void setCurrentCommand(int currentCommand) {
        this.currentCommand = currentCommand;
    }

    @Override
    public void addSubs(ISubscriber sub) {
        if(sub == null) {
            return;
        }
        if(this.subscribers ==null) {
            this.subscribers = new ArrayList<>();
        }
        if(this.subscribers.contains(sub)) {
            return;
        }
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubs(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifyObs(Object notif) {
        if(notif == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(ISubscriber listener : subscribers){
            listener.update(notif);
        }
    }

}
