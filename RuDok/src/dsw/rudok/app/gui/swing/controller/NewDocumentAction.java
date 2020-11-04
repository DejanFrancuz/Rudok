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
		int label = new Random().nextInt(100);
		Document d = new Document("Document "+label, ((RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel());
		MainFrame.getInstance().getTree().addDocument(d);
	}

	
}
