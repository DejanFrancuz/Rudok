package dsw.rudok.app.gui.swing.tree;

import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.Workspace;

import javax.swing.*;
import javax.swing.tree.TreePath;

public interface RuTree {
    JTree generateTree(Workspace workspace);
    void addProject(Project project);
    void addDocument(Project project,Document document);
    void addPage(Document document, Page page);

}
