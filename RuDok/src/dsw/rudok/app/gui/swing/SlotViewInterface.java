package dsw.rudok.app.gui.swing;

import dsw.rudok.app.repository.element.Slot;

import javax.swing.*;
import javax.swing.text.LabelView;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;

public interface SlotViewInterface {
    
    void boldText(JTextPane pane, SimpleAttributeSet attributeSet);
    void underlineText(JTextPane pane, SimpleAttributeSet attributeSet);
    void italicText(JTextPane pane, SimpleAttributeSet attributeSet);
    void saveText(Slot slot, JTextPane pane,SimpleAttributeSet attributeSet);
    void showText(Slot slot, JTextPane pane);
    void showPicture(Slot slot,JLabel label);
    void openPicture(Slot slot, JLabel label);
    void savePicture(Slot slot);


}
