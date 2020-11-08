package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.controller.JTabbedPaneCloseButton;
import dsw.rudok.app.repository.Slot;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import java.awt.*;

public class PageTab extends JPanel {

    private String pageName;
    private RuNode parent;
    private JTabbedPaneCloseButton tabbedPane;


    public PageTab(String name,RuNode parent){
        this.pageName = name;
        this.parent = parent;
        this.tabbedPane = new JTabbedPaneCloseButton();


        this.setLayout(new BorderLayout());;


        JPanel rightPanel = new JPanel();
        rightPanel.add(new JLabel( this.parent.getParent().getName() + ", " + this.parent.getName() + ", " + this.pageName));

        this.add( rightPanel, BorderLayout.CENTER);

        add(tabbedPane);

    }

    public JTabbedPaneCloseButton getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPaneCloseButton tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public void addSlotToPage(SlotTab slotTab, Icon icon, Slot slot) {

        //public void addPageToDoc(PageTab tab, Icon icon, Page page) {
        //        tabbedPane.addTab(page.getName(),icon,tab);
        //    }
        tabbedPane.addTab(slot.getName(),icon,slotTab);
    }
}
