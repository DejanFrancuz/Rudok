package dsw.rudok.app.gui.swing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;



public class ExitAction extends AbstractRudokAction{

	public ExitAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/log-out.png"));
		putValue(NAME, "Exit");
		putValue(SHORT_DESCRIPTION, "Exit");
		
	}

	@Override
	
		 public void actionPerformed(ActionEvent arg0) {
		        System.exit(0);
		    
	}

	
	
}
