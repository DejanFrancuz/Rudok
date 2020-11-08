package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.controller.JTabbedPaneCloseButton;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import java.awt.*;

public class SlotTab extends JPanel {

    private String slotName;
    private RuNode parent;



    public SlotTab(String name,RuNode parent){
        this.slotName = name;
        this.parent = parent;



        this.setLayout(new BorderLayout());;


        JPanel rightPanel = new JPanel();
        rightPanel.add(new JLabel( this.parent.getParent().getParent().getName() + ", " +  this.parent.getParent().getName() + ", " + this.parent.getName() + ", " + this.slotName));

        this.add( rightPanel, BorderLayout.CENTER);



    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }


}
