package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.SlotViewInterface;
import dsw.rudok.app.repository.element.Slot;

import javax.swing.*;
import javax.swing.text.*;
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
                .length(), asNew, true);


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
                .length(), asNew, true);
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
                .length(), asNew, true);
    }

    @Override
    public void saveText(Slot slot, JTextPane pane,SimpleAttributeSet attributeSet) {
        String text = pane.getText();

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

            while ((line = reader.readLine()) != null) {

                    pane.setText(line);

                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
