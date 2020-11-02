package dsw.rudok.app.repository;

import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

public class Document extends RuNodeComposite {
    public Document(String name, Project parent) {
        super(name, parent);
    }
    public void addChild(RuNode child){
        if(child!=null && child instanceof Page){
            Page page=(Page)child;
            if(!this.getChildren().contains(page)){
                this.getChildren().add(page);
            }
        }
    }
}