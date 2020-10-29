package dsw.rudok.app.repository;

import dsw.rudok.app.core.Repository;
import dsw.rudok.app.repository.node.RuNode;


public class RepositoryImpl implements Repository {
    private Workspace root;

    public RepositoryImpl(){
        root=new Workspace("Workspace");
    }

    public RepositoryImpl(Workspace root) {
        this.root = root;
    }

    @Override
    public Workspace getWorkspace(){
        return root;
    }

    public Workspace getRoot() {
        return root;
    }

    public void setRoot(Workspace root) {
        this.root = root;
    }
}
