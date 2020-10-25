package dsw.rudok.app.repository;

import dsw.rudok.app.core.Repository;
import dsw.rudok.app.repository.node.RuNode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepositoryImpl implements Repository {
    private Workspace root;

    public RepositoryImpl(){
        root=new Workspace("Workspace");
    }
    @Override
    public Workspace getWorkspace(){
        return root;
    }
}
