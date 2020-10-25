package dsw.rudok.app.gui.swing;

import dsw.rudok.app.gui.swing.view.MainFrame;

public class SwingGui{

	private MainFrame instance;
	
	public void start() {
		instance = MainFrame.getInstance();
		instance.setVisible(true);

	}
}
