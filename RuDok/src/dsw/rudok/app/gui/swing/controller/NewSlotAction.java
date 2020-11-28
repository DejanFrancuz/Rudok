package dsw.rudok.app.gui.swing.controller;


import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.PageTab;
import dsw.rudok.app.gui.swing.view.SlotTab;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.Slot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewSlotAction extends AbstractRudokAction{
    public NewSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/graphicslot-icon.png"));
        putValue(NAME, "New Slot");
        putValue(SHORT_DESCRIPTION, "New Slot");
    }
    public void actionPerformed(ActionEvent e){
        /*
        RuTreeItem node = (RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        if(node.getNodeModel() instanceof Page) {

            Page page  = (Page) node.getNodeModel();
            Slot slot = new Slot("Slot " + (node.getChildCount() + 1), page);
         */
            MainFrame.getInstance().getTree().addSlot();
           // MainFrame.getInstance().getWorkspaceTree().updateUI();

            //DODAVANJE SLOTOVA NA STRANICE
/*
            String name = slot.getName();
            SlotTab slotTab = new SlotTab(name,slot.getParent());
            Icon icon = loadIcon("images/close.png");
            page.getPageTab().addSlotToPage(slotTab,icon,slot);

 */
        }

}
