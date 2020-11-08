package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import java.awt.*;

public class PageTab extends JPanel {

    private String pageName;
    private RuNode parent;


    public PageTab(String name,RuNode parent){
        this.pageName = name;
        this.parent = parent;


        this.setLayout(new BorderLayout());;


        JPanel rightPanel = new JPanel();
        rightPanel.add(new JLabel( this.parent.getName() + ", " + this.pageName));

        this.add( rightPanel, BorderLayout.CENTER);



    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

}
