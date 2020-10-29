package dsw.rudok.app.repository.node;


public abstract class RuNode {

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
        this.name = name;
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
