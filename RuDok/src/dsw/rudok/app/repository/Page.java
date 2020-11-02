package dsw.rudok.app.repository;

import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

public class Page extends RuNodeComposite {
    public Page(String name, RuNode parent) {
        super(name, parent);
    }
}
