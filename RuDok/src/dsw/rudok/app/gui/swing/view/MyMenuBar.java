package dsw.rudok.app.gui.swing.view;

import java.awt.event.KeyEvent;
import javax.swing.*;


public class MyMenuBar extends JMenuBar{

	public MyMenuBar() {
		JMenu fileMenu = new JMenu("File");
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
		
		
		this.add(fileMenu);
	}
	
}
