package dsw.rudok.app.repository;

import dsw.rudok.app.core.Repository;
import dsw.rudok.app.repository.element.SlotHandler;
import dsw.rudok.app.repository.node.RuNode;


public class RepositoryImpl implements Repository {
    private Workspace root;
    private SlotHandler slotHandler;

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

    public SlotHandler getSlotHandler() {
        return slotHandler;
    }

    public void setSlotHandler(SlotHandler slotHandler) {
        this.slotHandler = slotHandler;
    }
}
