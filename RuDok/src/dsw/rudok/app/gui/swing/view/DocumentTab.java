package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import java.awt.*;

public class DocumentTab extends JPanel {


    private String documentName;
    private RuNode parent;


    public DocumentTab(String name,RuNode parent){
        this.documentName = name;
        this.parent = parent;


        this.setLayout(new BorderLayout());;


        JPanel rightPanel = new JPanel();
        rightPanel.add(new JLabel( this.parent.getName() + ", " + this.documentName));

        this.add( rightPanel, BorderLayout.CENTER);



    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
}
