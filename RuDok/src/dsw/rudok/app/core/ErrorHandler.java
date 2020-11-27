package dsw.rudok.app.core;

import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.observer.IPublisher;

public interface ErrorHandler extends IPublisher {
    void generateError(ErrorType errorType);




}
