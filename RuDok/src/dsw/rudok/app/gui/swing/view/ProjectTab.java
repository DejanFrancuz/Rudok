package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.controller.JTabbedPaneCloseButton;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Project;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectTab extends JInternalFrame implements ISubscriber {


    private static final long serialVersionUID = 7445755320045782268L;


    private Project project;
    private JTabbedPane documentsTab = new JTabbedPane();
    private List<DocumentTab> documentTabs= new ArrayList<>();
    public static int count = 0;


    public ProjectTab(Project project){

        super(project.toString(), true, true, true, true);
        this.project = project;
        this.project.addSubs(this);


        setSize(new Dimension(600, 600));
        setLocation(count * 40, count * 40);

        add(this.documentsTab);

        count += 1;

        setVisible(true);

    }

    @Override
    public void update(Object notif) {
        if(notif instanceof  Document) {
            Document document = (Document) notif;
                DocumentTab docTab = new DocumentTab(document);

                this.documentsTab.add(docTab, document.getName());

                this.documentsTab.setSelectedIndex(this.documentsTab.getComponentCount() - 1);
            }
        if(notif instanceof Integer){
            int index = (Integer)notif;
            this.documentsTab.remove(index);
        }
    }

    public JTabbedPane getDocumentsTab() {
        return documentsTab;
    }


    public void setDocumentsTab(JTabbedPane documentsTab) {
        this.documentsTab = documentsTab;
    }


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


   /* public DocumentTab getDocumentTabForDocument(Document document)
    {
        DocumentTab documentTab = null;
        System.out.println("sdds");
        for (DocumentTab documentTabTemp : this.documentTabs) {
            if (documentTabTemp.getDocument().equals(document))
            {

                documentTab = documentTabTemp;
                break;
            }
        }
        return documentTab;
    }*/

    public DocumentTab setDocumentTab(TreeNode selectedNode)
    {
        DocumentTab documentTab = null;
        for (int i = 0; i < this.documentsTab.getComponentCount(); i++)
        {
            documentTab = (DocumentTab) this.documentsTab.getComponent(i);
            Document document = documentTab.getDocument();
            if (document.equals((Document)selectedNode))
            {
                this.documentsTab.setSelectedIndex(i);
                break;
            }
        }
        return documentTab;
    }
}
