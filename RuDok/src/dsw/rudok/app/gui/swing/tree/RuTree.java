package dsw.rudok.app.gui.swing.tree;

import dsw.rudok.app.repository.*;
import dsw.rudok.app.repository.element.CircleSlot;
import dsw.rudok.app.repository.element.RectangleSlot;
import dsw.rudok.app.repository.element.Slot;

import javax.swing.*;

public interface RuTree {
    JTree generateTree(Workspace workspace);
    void addProject();
    void addProject(Project p);
    void addDocument();
    void addPage();
    void addSlot(Slot rectangle, Page page);
    void removeNode();
    void shareDocument();
    void removeSlot(Slot slot);

}
