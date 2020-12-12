package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.view.painters.ElementPainter;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.RectangleSlot;
import dsw.rudok.app.repository.element.SlotDevice;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.util.Iterator;

public class PageTab extends JPanel implements ISubscriber {
    static int openFrameCount = 0;

    static final int xOffset = 30, yOffset = 30;



    private String pageName;
    private RuNode parent;
    private JPanel panCenter;
    private Page page;
   // private List<SlotTab> slotTabs = new ArrayList<>();



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


        ++openFrameCount;
        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);


        setSize(400,400);
        setVisible(true);
        panCenter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panCenter.setBackground(Color.WHITE);
        SlotController s=new SlotController();
        panCenter.addMouseListener(s);
        panCenter.addMouseMotionListener(s);



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

   /*private class SlotController extends MouseAdapter implements MouseMotionListener {

        public void mousePressed(MouseEvent e) {
            //slot.getStateManager().getCurrentState().mousePressed(e);
           // MainFrame.getInstance().getWorkspace().setSelectionModel();


            *//*page.addChild(slot);
            MainFrame.getInstance().getWorkspaceTree().updateUI();*//*
            Point position = e.getPoint();
            GeneralPath gp=new GeneralPath();

            Paint fill = Color.BLACK;

            //RectangleElement rectangle=new RectangleElement(position, new Dimension(100,50), new BasicStroke(2f), fill);

            RectangleSlot rectangle= new RectangleSlot(new Dimension(100,50),position,new BasicStroke(),fill,
                    "Rectangle " + page.getPageModel().getElementCount());

            //new RectangleSlot( new Dimension(100,50),position);

            // rectangle.setName("RectangleSlot ");//+ slot.getSlotModel().getElementCount()
            MainFrame.getInstance().getTree().addSlot(rectangle,getPage());
           // System.out.println(page.getName());
            page.getPageModel().addSlots(rectangle);
            MainFrame.getInstance().getTabbedPane().updateUI();
        }

      *//*  public void mouseReleased(MouseEvent e) {
            slot.getStateManager().getCurrentState().mouseReleased(e);
        }

        public void mouseDragged(MouseEvent e ){
            slot.getStateManager().getCurrentState().mouseDragged(e);
        }*//*

    }*/

    public void setuj(){
        MainFrame.getInstance().setjPanel(this);
    }
    private class SlotController extends MouseAdapter implements MouseMotionListener{



        public void mousePressed(MouseEvent e) {
            setuj();
            page.getStateManager().getCurrentState().mousePressed(e);
        }

        public void mouseReleased(MouseEvent e) {
            page.getStateManager().getCurrentState().mouseReleased(e);
        }

        public void mouseDragged(MouseEvent e ){
            page.getStateManager().getCurrentState().mouseDragged(e);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        graphics2D.setStroke(new BasicStroke());

        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
         Iterator<Slot> it = page.getPageModel().getSlotIterator();
        while (it.hasNext()){



            Slot slot = (Slot) it.next();
            ElementPainter painter = slot.getSlotPainter();
            painter.paint(graphics2D,slot);
        }
    }

    @Override
    public void update(Object notif) {



         /*  if(notif instanceof  Slot){
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


            }*/

        if(notif instanceof Integer){
            int index = (Integer)notif;
            //this.slotTab.remove(index);
            this.panCenter.remove(index);
            this.panCenter.updateUI();
        }
        if(notif instanceof String){
            String s = (String)notif;
            getPage().getPageTab().setName(s);
        }else{
            repaint();
        }
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public static int getOpenFrameCount() {
        return openFrameCount;
    }

    public static void setOpenFrameCount(int openFrameCount) {
        PageTab.openFrameCount = openFrameCount;
    }

    public static int getxOffset() {
        return xOffset;
    }

    public static int getyOffset() {
        return yOffset;
    }




    public void setParent(RuNode parent) {
        this.parent = parent;
    }

    /*public List<SlotTab> getSlotTabs() {
        return slotTabs;
    }

    public void setSlotTabs(List<SlotTab> slotTabs) {
        this.slotTabs = slotTabs;
    }*/
}
