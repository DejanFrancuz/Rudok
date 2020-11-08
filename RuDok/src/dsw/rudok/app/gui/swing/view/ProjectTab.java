package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.repository.Project;

import javax.swing.*;
import java.awt.*;

public class ProjectTab extends JPanel {

    private static final long serialVersionUID = 7445755320045782268L;

    private JPanel topPanel;
    private String projectName;

    public ProjectTab(String name){
        this.projectName = name;
        this.setLayout(new BorderLayout());;


        JPanel rightPanel = new JPanel();
        rightPanel.add(new JLabel( this.projectName));

        this.add( rightPanel,
                BorderLayout.CENTER);


    }


}
