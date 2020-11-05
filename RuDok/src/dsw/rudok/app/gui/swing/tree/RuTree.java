package dsw.rudok.app.gui.swing.tree;

import dsw.rudok.app.repository.*;

import javax.swing.*;
import javax.swing.tree.TreePath;

public interface RuTree {
    JTree generateTree(Workspace workspace);
    void addProject(Project project);
    void addDocument(Project project,Document document);
    void addPage(Document document, Page page);
    void addSlot(Page page, Slot slot);

}
