package dsw.rudok.app.repository;

import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;


public class Workspace extends RuNodeComposite {
    public Workspace(String name){
        super(name,null);
    }
    @Override
    public void addChild(RuNode child){
        if(child!=null && child instanceof Project){
            Project project = (Project) child;
            if(!this.getChildren().contains(project)){
                this.getChildren().add(project);
            }
        }
    }
}
