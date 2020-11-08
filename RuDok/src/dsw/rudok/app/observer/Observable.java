package dsw.rudok.app.observer;

public interface Observable {
    public void notifyObserver();
    public void addObserver(Observer o);
}
