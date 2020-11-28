package dsw.rudok.app.repository.node;


import dsw.rudok.app.AppCore;
import dsw.rudok.app.errorHandler.ErrorType;
import dsw.rudok.app.errorHandler.MyError;
import dsw.rudok.app.observer.IPublisher;

public abstract class RuNode implements IPublisher{

    private String name;

    private RuNode parent;

    public RuNode(String name,RuNode parent){
        this.name=name;
        this.parent=parent;
    }
    @Override
    public boolean equals(Object obj){
        if(obj!=null && obj instanceof RuNode){
            RuNode otherObj = (RuNode)obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public RuNode getParent() {
        return parent;
    }

    public void setName(String name) {
        if(name ==""){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.NAME_CANNOT_BE_EMPTY);
            return;
        }
        this.name = name;
        notifyObs(name);
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "RuNode{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
}
