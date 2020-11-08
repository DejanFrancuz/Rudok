package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.controller.JTabbedPaneCloseButton;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import java.awt.*;

public class DocumentTab extends JPanel {


    private String documentName;
    private RuNode parent;
    private JTabbedPaneCloseButton tabbedPane;


    public DocumentTab(String name,RuNode parent){
        this.documentName = name;
        this.parent = parent;
       this.tabbedPane = new JTabbedPaneCloseButton();


        this.setLayout(new BorderLayout());;


        JPanel rightPanel = new JPanel();
        rightPanel.add(new JLabel( this.parent.getName() + ", " + this.documentName));

        this.add( rightPanel, BorderLayout.CENTER);

        add(tabbedPane);

    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public JTabbedPaneCloseButton getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPaneCloseButton tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public void addPageToDoc(PageTab tab, Icon icon, Page page) {
        tabbedPane.addTab(page.getName(),icon,tab);
    }
}
