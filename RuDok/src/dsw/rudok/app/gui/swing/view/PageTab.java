package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.controller.JTabbedPaneCloseButton;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.Slot;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PageTab extends JPanel implements ISubscriber {

    private String pageName;
    private RuNode parent;
    private JPanel panCenter;
    private Page page;
    private List<SlotTab> slotTabs = new ArrayList<>();

    public PageTab(Page page){
        this.page = page;
        this.panCenter = new JPanel();
        this.page.addSubs(this);

        TitledBorder title = BorderFactory.createTitledBorder(page.toString());
        title.setTitlePosition(4);
        title.setTitleJustification(2);
        setBorder(title);

        this.setLayout(new BorderLayout());;


        this.panCenter.setBackground(Color.WHITE);
        add(this.panCenter);

    }

    public JPanel getPanCenter() {
        return panCenter;
    }

    public void setPanCenter(JPanel panCenter) {
        this.panCenter = panCenter;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }



    @Override
    public void update(Object notif) {

            if(notif instanceof  Slot){
                Slot slot = (Slot) notif;
                SlotTab slotTab = new SlotTab(slot);
                this.slotTabs.add(slotTab);


                int maxWidth = (int)getSize().getWidth();
                int maxHeight = (int)getSize().getHeight();


                for (int i = 0; i < this.slotTabs.size(); i++)
                {
                    SlotTab slotViewer = (SlotTab) this.slotTabs.get(i);
                    slotViewer.setPreferredSize(new Dimension(maxWidth ,
                            maxHeight / 3));
                    this.panCenter.add(slotViewer);
                }

                validate();


            }

        if(notif instanceof Integer){
            int index = (Integer)notif;
            //this.slotTab.remove(index);
            this.panCenter.remove(index);
            this.panCenter.updateUI();
        }
        if(notif instanceof String){
            String s = (String)notif;
            getPage().getPageTab().setName(s);
        }
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }



}
