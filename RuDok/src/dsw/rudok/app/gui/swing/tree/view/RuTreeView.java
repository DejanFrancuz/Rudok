package dsw.rudok.app.gui.swing.tree.view;

import dsw.rudok.app.gui.swing.tree.controller.RuTreeCellEditor;
import dsw.rudok.app.gui.swing.tree.controller.RuTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class RuTreeView extends JTree {

    public RuTreeView(DefaultTreeModel defaultTreeModel){
        setModel(defaultTreeModel);
        RuTreeCellRender ruTreeCellRender = new RuTreeCellRender();
        addTreeSelectionListener(new RuTreeSelectionListener());
        setCellEditor(new RuTreeCellEditor(this,ruTreeCellRender));
        setCellRenderer(ruTreeCellRender);
        setEditable(true);
    }
    public void update(){
        SwingUtilities.updateComponentTreeUI(this);
    }
}
