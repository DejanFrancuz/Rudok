package dsw.rudok.app.observer;

import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;

public interface Observer {
    public void onUpdate(RuTreeItem item);
}
