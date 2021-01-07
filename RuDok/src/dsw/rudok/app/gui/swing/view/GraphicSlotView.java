package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.Slot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GraphicSlotView extends SlotView implements ISubscriber {

    private  JPanel jpanel = new JPanel();
    private JToolBar toolbar;
    private JButton btnSave,btnOpen;
    private JLabel label;
    private String filePath;

    public GraphicSlotView(Slot slot) {
        super(slot);
        setTitle("Graficki slot");

        setLocationRelativeTo(null);

        label = new JLabel();
        label.setBounds(10,10,200,300);

        toolbar = new JToolBar();
        toolbar.setFloatable(false);
        btnSave = new JButton("Save");
        btnOpen = new JButton("Open");

        if(getSlot().getFile() != null){
            MainFrame.getInstance().getSlotInterface().showPicture(getSlot(),label);
        }

        btnOpen.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().getSlotInterface().openPicture(getSlot(),label);
            }
        });

        btnSave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().getSlotInterface().savePicture(getSlot());
            }
        });



        setSize(new Dimension(400,400));

        toolbar.add(btnSave);
        toolbar.add(btnOpen);

        jpanel.add(toolbar,BorderLayout.NORTH);
        jpanel.add(label,BorderLayout.SOUTH);

        add(jpanel);

    }

    @Override
    public void update(Object notif) {


    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
