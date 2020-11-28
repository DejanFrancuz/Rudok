package dsw.rudok.app.gui.swing.controller;


import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.DocumentTab;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.Project;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewPageAction extends AbstractRudokAction{

    public NewPageAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/Page-icon.png"));
        putValue(NAME, "New Page");
        putValue(SHORT_DESCRIPTION, "New Page");
    }
    @Override
    public void actionPerformed(ActionEvent e){
        RuTreeItem node = (RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        if(node.getNodeModel() instanceof Document) {

            Document document  = (Document) node.getNodeModel();
            Page page = new Page("Page " + (node.getChildCount() + 1), document);
            MainFrame.getInstance().getTree().addPage();
            //MainFrame.getInstance().getWorkspaceTree().updateUI();

            //DODAVANJE STRANICE NA DOKUMENT
/*
            String name = page.getName();
            PageTab pageTab = new PageTab(name,page.getParent());
            Icon icon = loadIcon("images/close.png");
            document.getDocumentTab().addPageToDoc(pageTab,icon,page);
            page.setPageTab(pageTab);
*/

        }

    }



}
