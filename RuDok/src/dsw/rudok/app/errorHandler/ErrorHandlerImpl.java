package dsw.rudok.app.errorHandler;

import dsw.rudok.app.core.ErrorHandler;
import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandlerImpl  implements ErrorHandler {
    List<ISubscriber> subscribers;
    public void generateError(ErrorType errorType){
        if(errorType == ErrorType.NAME_CANNOT_BE_EMPTY){
            notifyObs(new MyError(1,"Greska prilikom dodele imena","Polje za ime ne moze biti prazno"));
        }
        if(errorType == ErrorType.NOTHING_SELECTED){
            notifyObs(new MyError(2, "Greska prilikom selektovanja", "Nista nije selektovano"));
        }
        if(errorType==ErrorType.DOCUMENTS_CANNOT_HAVE_SAME_NAME){
            notifyObs(new MyError(1,"Greska prilikom dodele imena","Vec postoji dokument sa ovim imenom"));
        }

        if(errorType == ErrorType.NOT_SELECTED_JPANEL){
            notifyObs(new MyError(2, "Greska prilikom selektovanja Page-a", "PageTab mora biti selektovan"));
        }

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
