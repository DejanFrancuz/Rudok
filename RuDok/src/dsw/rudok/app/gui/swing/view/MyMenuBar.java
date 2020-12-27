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
		fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteNode());
		fileMenu.add(MainFrame.getInstance().getActionManager().getShareDocumentAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getCircleAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getRectangleAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getTriangleAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getSelectAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getMoveAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getResizeAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getRotateAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteSlotAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getSelectAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getUndoAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getRedoAction());


		
		this.add(fileMenu);
		this.add(about);
	}
	
}
