package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.controller.JTabbedPaneCloseButton;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Project;

import javax.swing.*;
import java.awt.*;

public class ProjectTab extends JPanel {

    private static final long serialVersionUID = 7445755320045782268L;

    private String projectName;
    private JTabbedPaneCloseButton tabbedPane;


    public ProjectTab(String name){
        this.projectName = name;
        tabbedPane = new JTabbedPaneCloseButton();
        this.setLayout(new BorderLayout());;


        JPanel rightPanel = new JPanel();
        rightPanel.add(new JLabel( this.projectName));

        this.add( rightPanel,
                BorderLayout.CENTER);

        add(tabbedPane);

    }

    public void saveProjectState() {
        System.out.println("Cuvam sadrzaj projekta: " + this.projectName);
    }

    public void addDocToPrj(DocumentTab documentTab, Icon icon, Document document) {
        //(project.getName(),icon,projectTab,project.getName()

        tabbedPane.addTab(document.getName(),icon,documentTab);


    }
}
