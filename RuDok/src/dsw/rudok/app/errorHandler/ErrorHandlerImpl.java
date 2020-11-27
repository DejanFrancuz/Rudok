package dsw.rudok.app.errorHandler;

import dsw.rudok.app.core.ErrorHandler;
import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;

public class ErrorHandlerImpl  implements ErrorHandler {
    public void generateError(ErrorType errorType){
        if(errorType == ErrorType.WS_CANNOT_BE_DELETED){
            notifyObs(new MyError(1,"Greska prilikom brisanja","Workspace ne moze biti obrisan"));
        }

    }

    @Override
    public void addSubs(ISubscriber iSubscriber) {

    }

    @Override
    public void removeSubs(ISubscriber iSubscriber) {

    }

    @Override
    public void notifyObs(Object notif) {

    }
}
