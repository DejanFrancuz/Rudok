package dsw.rudok.app.gui.swing.controller;

import java.awt.event.ActionEvent;

import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.node.RuNodeComposite;

public class NewDocumentAction extends AbstractRudokAction{
	
	public NewDocumentAction() {
		putValue(SMALL_ICON, loadIcon("images/document_add.png"));
		putValue(NAME, "New Document");
		putValue(SHORT_DESCRIPTION, "New Project");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

	
}
