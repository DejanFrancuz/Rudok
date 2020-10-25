package dsw.rudok.app.repository.node;

import lombok.*;

@Getter
@Setter
public abstract class RuNode {

    private String name;
    @ToString.Exclude
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
}
