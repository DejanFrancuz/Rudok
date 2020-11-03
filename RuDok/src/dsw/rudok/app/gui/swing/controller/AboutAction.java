package dsw.rudok.app.gui.swing.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import dsw.rudok.app.gui.swing.view.AboutDialog;

public class AboutAction extends AbstractAction{
	
		public AboutAction() {
			super();
			setEnabled(false);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		AboutDialog aDialog = new AboutDialog();
		aDialog.setVisible(true);
		
	}

	
}
