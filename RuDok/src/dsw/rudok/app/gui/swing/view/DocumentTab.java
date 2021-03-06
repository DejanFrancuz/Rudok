package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentTab extends JPanel implements ISubscriber {


    private String documentName;
    private Document document;
    private RuNode parent;
    private JPanel panCenter;
    private List<PageTab> pageTabs = new ArrayList<>();

    public DocumentTab(Document document){
        this.document = document;
       this.panCenter = new JPanel();
       this.document.addSubs(this);


        this.setLayout(new BorderLayout());;


        this.panCenter.setBackground(Color.LIGHT_GRAY);
        JScrollPane sc = new JScrollPane(this.panCenter,  20,  30);
        add(sc);
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public JPanel getPanCenter() {
        return panCenter;
    }

    public void setPanCenter(JPanel panCenter) {
        this.panCenter = panCenter;
    }



    @Override
    public void update(Object notif) {

        if(notif instanceof Page){
            Page page = (Page) notif;
            PageTab pageTab = new PageTab(page);
            //pageTab.setSlot((Slot) page.getChildren().get(0));
            this.pageTabs.add(pageTab);
            this.panCenter.add(pageTab,"align center");

            int maxWidth = (int)getSize().getWidth();

            for (PageTab pageTabTmp : pageTabs)
            {


                pageTabTmp.setPreferredSize(new Dimension(maxWidth - 100, maxWidth - 100));

                this.panCenter.add(pageTabTmp, "align center");
            }
            pageTab.setuj();
            validate();
            repaint();
            MainFrame.getInstance().getTabbedPane().updateUI();
            /*for (PageTab pageViewer : this.pageTabs) {
                pageViewer.update( null);
            }*/

        }
        if(notif instanceof Integer){
            int index = (Integer)notif;
            //this.pagesTab.remove(index);
            this.panCenter.remove(index);
            panCenter.updateUI();
        }
        if(notif instanceof String){
            String s =(String)notif;

            setDocumentName(s);
            this.getDocument().getDocumentTab().setName(s);


            System.out.println(document.getName());
        }
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }


   /* public PageTab getPageTabForPage(Page page)
    {
       PageTab pageTab = null;
        for (PageTab pageTabTemp : this.pageTabs) {
            if (pageTabTemp.getPage().equals(page))
            {
                System.out.println("SFFSSF");
                pageTab = pageTabTemp;
                break;
            }
        }
        return pageTab;
    }*/


}
