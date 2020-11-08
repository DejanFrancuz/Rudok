package dsw.rudok.app.gui.swing.controller;

import javax.swing.*;
import java.awt.*;

public class JTabbedPaneCloseButton extends JTabbedPane {

    private static final long serialVersionUID = 6162048567980039381L;

    public JTabbedPaneCloseButton() {
        super();
    }

    @Override
    public void addTab(String title, Icon icon,Component component,String tip) {
        super.addTab(title, icon, component, tip);
        int count = this.getTabCount() - 1;
    }
}
