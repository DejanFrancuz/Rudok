package dsw.rudok.app.gui.swing.controller;

import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.Project;

import javax.print.Doc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewDocumentAction extends AbstractRudokAction{
    public NewDocumentAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/document_add.png"));
        putValue(NAME, "New Page");
        putValue(SHORT_DESCRIPTION, "New Page");
    }
    @Override
    public void actionPerformed(ActionEvent e){
        RuTreeItem node = (RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        if(node.getNodeModel() instanceof Project) {

            Project project  = (Project) node.getNodeModel();
            Document document = new Document("Document " + (node.getChildCount() + 1), project);
            MainFrame.getInstance().getTree().addDocument(project, document);
            MainFrame.getInstance().getWorkspaceTree().updateUI();
        }
    }
}
