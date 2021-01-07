package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.SlotViewInterface;
import dsw.rudok.app.gui.swing.controller.MyFileFilter;
import dsw.rudok.app.gui.swing.controller.MyPictureFilter;
import dsw.rudok.app.html.MyHtml2Text;
import dsw.rudok.app.repository.element.Slot;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;


public class SlotViewImplementation implements SlotViewInterface {
    @Override
    public void boldText(JTextPane pane, SimpleAttributeSet attributeSet) {

        StyledDocument doc = pane.getStyledDocument();

        int selectionEnd = pane.getSelectionEnd();
        int selectionStart = pane.getSelectionStart();

        Element element = doc.getCharacterElement(selectionStart);
        MutableAttributeSet asNew = new SimpleAttributeSet(attributeSet.copyAttributes());

        StyleConstants.setBold(asNew, !StyleConstants.isBold(attributeSet));
        doc.setCharacterAttributes(selectionStart, pane.getSelectedText()
                .length(), asNew, false);


    }

    @Override
    public void underlineText(JTextPane pane, SimpleAttributeSet attributeSet) {
        StyledDocument doc = pane.getStyledDocument();

        int selectionEnd = pane.getSelectionEnd();
        int selectionStart = pane.getSelectionStart();

        Element element = doc.getCharacterElement(selectionStart);
        MutableAttributeSet asNew = new SimpleAttributeSet(attributeSet.copyAttributes());

        StyleConstants.setUnderline(asNew, !StyleConstants.isUnderline(attributeSet));
        doc.setCharacterAttributes(selectionStart, pane.getSelectedText()
                .length(), asNew, false);
    }

    @Override
    public void italicText(JTextPane pane, SimpleAttributeSet attributeSet) {

        StyledDocument doc = pane.getStyledDocument();

        int selectionEnd = pane.getSelectionEnd();
        int selectionStart = pane.getSelectionStart();

        Element element = doc.getCharacterElement(selectionStart);
        MutableAttributeSet asNew = new SimpleAttributeSet(attributeSet.copyAttributes());

        StyleConstants.setItalic(asNew, !StyleConstants.isItalic(attributeSet));
        doc.setCharacterAttributes(selectionStart, pane.getSelectedText()
                .length(), asNew, false);
    }

    @Override
    public void saveText(Slot slot, JTextPane pane,SimpleAttributeSet attributeSet) {

        String text = pane.getText();
        System.out.println(text);

        StyledDocument doc = pane.getStyledDocument();


        PrintWriter writer = null;
        File file = new File(slot.name + "file");


        try {
            writer = new PrintWriter(new FileWriter(file));
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (writer != null) {
                writer.close();
            }
        }

        slot.setFile(file);
    }

    @Override
    public void showText(Slot slot, JTextPane pane) {


        try {
            String line;
            FileReader fr = new FileReader(slot.getFile());
            BufferedReader reader = new BufferedReader(fr);


            MyHtml2Text parser = new MyHtml2Text();
            try {
                parser.parse(fr);
            } catch (IOException ee) {
               ee.printStackTrace();
            }



                    pane.setText(parser.getText());


            }catch(IOException e){
                e.printStackTrace();
            }
        }

    @Override
    public void showPicture(Slot slot,JLabel label) {

        GraphicSlotView slotView = (GraphicSlotView) slot.getSlotView();
        ImageIcon icon = new ImageIcon(slot.getFile().getAbsolutePath());
        Image image = icon.getImage();
        image = getScaledImage(image,200,300);

        label.setIcon(new ImageIcon(image));

    }

    @Override
    public void openPicture(Slot slot,JLabel label) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new MyPictureFilter());
        int result = jfc.showOpenDialog(null);

        GraphicSlotView slotView = (GraphicSlotView) slot.getSlotView();

        if (result == JFileChooser.APPROVE_OPTION){


            File selectedFile = jfc.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            ImageIcon icon = new ImageIcon(path);
            Image image = icon.getImage();
            image = getScaledImage(image,200,300);

            label.setIcon(new ImageIcon(image));
            slotView.setFilePath(path);

        }

         }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }



    @Override
    public void savePicture(Slot slot) {

        GraphicSlotView slotView = (GraphicSlotView) slot.getSlotView();
        slot.setFile(new File(slotView.getFilePath()));
    }


}
