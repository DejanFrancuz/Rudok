package dsw.rudok.app.observer;

public interface IPublisher {
    void addSubs(ISubscriber iSubscriber);
    void removeSubs(ISubscriber iSubscriber);
    void notifyObs(Object notif);


}
