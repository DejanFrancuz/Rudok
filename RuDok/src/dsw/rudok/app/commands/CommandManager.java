package dsw.rudok.app.commands;

import dsw.rudok.app.core.Command;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements Command{
    List<ISubscriber> subscribers;
    //lista koja predstavlja stek na kome se nalaze konkretne izvršene komande
    private ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();
    //pokazivač steka, sadrži redni broj komande za undo / redo operaciju
    private int currentCommand = 0;

    /*
     * Dodaje novu komandu na stek i poziva izvršavanje komande
     */
    public void addCommand(AbstractCommand command){
        while(currentCommand < commands.size())
            commands.remove(currentCommand);
        commands.add(command);
        doCommand();
    }

    /*
     * Metoda koja poziva izvršavanje konkretne komande
     */
    public void doCommand(){
        if(currentCommand < commands.size()){
            commands.get(currentCommand++).doCommand();
            notifyObs(EventType.UNDO_ENABLE);
        }
        if(currentCommand==commands.size()){
            notifyObs(EventType.REDO_DISABLE);
        }
    }

    /*
     * Metoda koja poziva redo konkretne komande
     */
    public void undoCommand(){
        if(currentCommand > 0){
            notifyObs(EventType.REDO_ENABLE);
            commands.get(--currentCommand).undoCommand();
        }
        if(currentCommand==0){
            notifyObs(EventType.UNDO_DISABLE);
        }
    }
    public void addSubs(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
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
