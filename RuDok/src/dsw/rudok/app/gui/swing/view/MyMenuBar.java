package dsw.rudok.app.gui.swing.view;

import java.awt.event.KeyEvent;
import java.io.ObjectStreamException;
import java.util.Observer;
import javax.swing.*;

import dsw.rudok.app.gui.swing.controller.AboutAction;


public class MyMenuBar extends JMenuBar {

	public MyMenuBar() {
		JMenu fileMenu = new JMenu("File");
		
		JMenu about = new JMenu("About");
		JMenuItem aboutUs = new JMenuItem("About Developers");
		aboutUs.addActionListener(new AboutAction());
		about.add(aboutUs);
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getNewDocumentAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getNewPageAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getNewSlotAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteNode());

		
		this.add(fileMenu);
		this.add(about);
	}
	
}
