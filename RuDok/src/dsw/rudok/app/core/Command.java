package dsw.rudok.app.core;

import dsw.rudok.app.observer.IPublisher;

import javax.imageio.IIOParamController;

public interface Command extends IPublisher {
    void doCommand();
    void undoCommand();
}
