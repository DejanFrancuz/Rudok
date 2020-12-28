package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.commands.CommandManager;
import dsw.rudok.app.gui.swing.view.painters.ElementPainter;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.*;
import dsw.rudok.app.repository.node.RuNode;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

public class PageTab extends JPanel implements ISubscriber {
    static int openFrameCount = 0;

    static final int xOffset = 30, yOffset = 30;




    private String pageName;
    private RuNode parent;
    private JPanel panCenter;
    private Page page;



    static final int handleSize = 7;



    public PageTab(Page page){
        this.page = page;
        this.panCenter = new JPanel();
        this.page.addSubs(this);
        this.page.getPageSelectionModel().addSubs(this);
        this.page.getPageModel().addSubs(this);

        TitledBorder title = BorderFactory.createTitledBorder(page.toString());
        title.setTitlePosition(4);
        title.setTitleJustification(2);
        setBorder(title);

        this.setLayout(new BorderLayout());
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



    public void setuj(){

        MainFrame.getInstance().setjPanel(this);
    }

    private class SlotController extends MouseAdapter implements MouseMotionListener{


        public void mousePressed(MouseEvent e) {
            setuj();
            page.setLastPosition(e.getPoint());
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



            Slot slot =it.next();
            if(slot.isRotate()){
                AffineTransform at=graphics2D.getTransform();
                graphics2D.rotate(Math.toRadians(slot.getAngle()),slot.getNorth().getX(),slot.getNorth().getY());


                ElementPainter painter = slot.getSlotPainter();
                painter.paint(graphics2D, slot);
                graphics2D.setTransform(at);
            }else {
                ElementPainter painter = slot.getSlotPainter();
                painter.paint(graphics2D, slot);
            }
            paintSelectionHandles(graphics2D);
            paintLasso(graphics2D);
        }
    }
    private void paintLasso(Graphics2D g2){
        if(page.getSelectionRectangle()!=null){
            Rectangle2D rec=page.getSelectionRectangle();
            g2.setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0));
            g2.setPaint(Color.BLACK);

            g2.drawRect((int)  rec.getBounds2D().getX(), (int) rec.getBounds2D().getY(),
                    (int) rec.getBounds().getWidth(), (int) rec.getBounds().getHeight());
        }
    }
    private void paintSelectionHandles(Graphics2D g2) {
        Iterator<Slot> it=page.getPageSelectionModel().getSelectionListIterator();
        while(it.hasNext()) {
            Slot slot = it.next();
            if (slot == null) return;
            // Iscrtavanje pravougaonika sa isprekidanom linijom
            g2.setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0));
            g2.setPaint(Color.BLACK);

            g2.drawRect((int) slot.getPosition().getX(), (int) slot.getPosition().getY(),
                    (int) slot.getSize().getWidth(), (int) slot.getSize().getHeight());

            // 	Iscrtavanje hendlova
            for (Handle e : Handle.values()) {
                paintSelectionHandle(g2, getHandlePoint(slot.getPosition(), slot.getSize(), e));
                // System.out.println(getHandlePoint(slot.getPosition(), slot.getSize(), e));
            }

        }
        }



    private void paintSelectionHandle(Graphics2D g2, Point2D position){
        double size = handleSize;
        g2.fill(new Rectangle2D.Double(position.getX()-size/2, position.getY()-size/2,
                size, size));
    }
    public Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition ){
        double x=0, y=0;

        // Doređivanje y koordinate

        // Ako su gornji hendlovi
        if(handlePosition == Handle.NorthWest || handlePosition == Handle.North || handlePosition == Handle.NorthEast){
            y = topLeft.getY();
        }
        // Ako su centralni po y osi
        if(handlePosition == Handle.East || handlePosition == Handle.West){
            y = topLeft.getY()+size.getHeight()/2;
        }
        //Ako su donji
        if(handlePosition == Handle.SouthWest || handlePosition == Handle.South || handlePosition == Handle.SouthEast){
            y = topLeft.getY() + size.getHeight();
        }

        // Određivanje x koordinate

        // Ako su levi
        if(handlePosition == Handle.NorthWest || handlePosition == Handle.West || handlePosition == Handle.SouthWest){
            x = topLeft.getX();
        }
        // ako su centralni po x osi
        if(handlePosition == Handle.North || handlePosition == Handle.South){
            x = topLeft.getX() + size.getWidth()/2;
        }
        // ako su desni
        if(handlePosition == Handle.NorthEast || handlePosition == Handle.East || handlePosition == Handle.SouthEast){
            x = topLeft.getX() + size.getWidth();
        }

        return new Point2D.Double(x,y);

    }
    @Override
    public void update(Object notif) {
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
}
