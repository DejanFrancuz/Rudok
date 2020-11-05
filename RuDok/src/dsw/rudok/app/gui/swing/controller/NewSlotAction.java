package dsw.rudok.app.gui.swing.controller;

import com.sun.glass.events.KeyEvent;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.Slot;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewSlotAction extends AbstractRudokAction{
    public NewSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/newbook.png"));
        putValue(NAME, "New Slot");
        putValue(SHORT_DESCRIPTION, "New Slot");
    }
    public void actionPerformed(ActionEvent e){
        RuTreeItem node = (RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        if(node.getNodeModel() instanceof Page) {

            Page page  = (Page) node.getNodeModel();
            Slot slot = new Slot("Page " + (node.getChildCount() + 1), page);
            MainFrame.getInstance().getTree().addSlot(page, slot);
            MainFrame.getInstance().getWorkspaceTree().updateUI();
        }
    }
}
