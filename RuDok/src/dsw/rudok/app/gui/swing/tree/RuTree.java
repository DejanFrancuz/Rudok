package dsw.rudok.app.gui.swing.tree;

import dsw.rudok.app.repository.*;
import dsw.rudok.app.repository.element.CircleSlot;
import dsw.rudok.app.repository.element.RectangleSlot;

import javax.swing.*;

public interface RuTree {
    JTree generateTree(Workspace workspace);
    void addProject();
    void addDocument();
    void addPage();
    void addSlot(RectangleSlot rectangle, Page page);
    void addSlot(CircleSlot circle,Page page);
    void removeNode();
    void shareDocument();

}
