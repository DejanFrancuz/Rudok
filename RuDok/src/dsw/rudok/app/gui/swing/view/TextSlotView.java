package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.element.Slot;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TextSlotView extends SlotView implements ISubscriber {

    private  JPanel jpanel = new JPanel();
    private JToolBar toolbar;
    private JButton btnUnderLine,btnBold,btnItalic,btnSave;


    public TextSlotView(Slot slot){
        super(slot);
        setLocationRelativeTo(null);

        toolbar = new JToolBar();

        btnBold = new JButton("B");
        btnItalic = new JButton("I");
        btnUnderLine = new JButton("U");
        btnSave = new JButton("Save");

       JTextPane pane = new JTextPane();
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
       /* StyleConstants.setBold(attributeSet, true);

        // Set the attributes before adding text
        pane.setCharacterAttributes(attributeSet, true);
        pane.setText("Welcome");

        attributeSet = new SimpleAttributeSet();
        StyleConstants.setItalic(attributeSet, true);
        StyleConstants.setForeground(attributeSet, Color.red);
        StyleConstants.setBackground(attributeSet, Color.blue);

        Document doc = pane.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), "To Java ", attributeSet);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        attributeSet = new SimpleAttributeSet();
        try {
            doc.insertString(doc.getLength(), "World", attributeSet);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }*/

        pane.setPreferredSize(new Dimension(300,400));


        if(getSlot().getFile() != null){
            MainFrame.getInstance().getSlotInterface().showText(getSlot(),pane);
        }

        btnBold.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainFrame.getInstance().getSlotInterface().boldText(pane,attributeSet);
            }
        });

        btnItalic.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().getSlotInterface().italicText(pane,attributeSet);
            }
        });

        btnUnderLine.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().getSlotInterface().underlineText(pane,attributeSet);

            }
        });


        btnSave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().getSlotInterface().saveText(getSlot(),pane,attributeSet);
            }
        });

        toolbar.add(btnBold);
        toolbar.add(btnItalic);
        toolbar.add(btnUnderLine);
        toolbar.add(btnSave);

        jpanel.add(toolbar,BorderLayout.NORTH);
        jpanel.add(pane,BorderLayout.CENTER);


        this.setMinimumSize(new Dimension(400,300));
        add(jpanel);

    }

    @Override
    public void update(Object notif) {

    }
}
