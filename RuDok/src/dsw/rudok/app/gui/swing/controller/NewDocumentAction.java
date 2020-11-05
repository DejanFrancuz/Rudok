package dsw.rudok.app.gui.swing.controller;

import java.awt.event.ActionEvent;
import java.util.Random;

import com.sun.glass.events.KeyEvent;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import javax.swing.*;

public class NewDocumentAction extends AbstractRudokAction{
	
	public NewDocumentAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/document_add.png"));
		putValue(NAME, "New Document");
		putValue(SHORT_DESCRIPTION, "New Document");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		RuTreeItem node = (RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		
		
			if(node.getNodeModel() instanceof Project) {
				
				Project project  = (Project) node.getNodeModel();
				Document document = new Document("Document" + (node.getChildCount() + 1), project);
				MainFrame.getInstance().getTree().addDocument(project, document);
				MainFrame.getInstance().getWorkspaceTree().updateUI();
			}
		

	}

	
}
