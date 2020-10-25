package dsw.rudok.app.gui.swing.controller;

import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import dsw.rudok.app.repository.node.RuNode;

public class NewProjectAction extends AbstractRudokAction{
	
	 public NewProjectAction() {
		
		 putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		 putValue(SMALL_ICON, loadIcon("Documents/plus.png"));
		 putValue(NAME, "New Project");
		 putValue(SHORT_DESCRIPTION, "New Project");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int label = new Random().nextInt(100);
		
		
	}

}
