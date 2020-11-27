package dsw.rudok.app.observer;

import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;

public interface ISubscriber {
    void update(Object notif);
}
