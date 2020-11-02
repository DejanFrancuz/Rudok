package dsw.rudok.app.repository;

import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

public class Project extends RuNodeComposite {
    public Project(String name, Workspace parent){
        super(name,parent);
    }
    @Override
    public void addChild(RuNode child){
        if(child!=null && child instanceof Document){
            Document document= (Document)child;
            if(!this.getChildren().contains(document)){
                this.getChildren().add(document);
            }
        }
    }
}
