package dsw.rudok.app.observer;

public interface IPublisher {
    void addSubs(ISubscriber sub);
    void removeSubs(ISubscriber sub);
    void notifyObs(Object notif);


}
