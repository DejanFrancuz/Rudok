package dsw.rudok.app.gui.swing.controller;

import java.awt.event.ActionEvent;


import java.awt.event.KeyEvent;
import java.util.Random;


import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.DocumentTab;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import javax.swing.*;

public class NewDocumentAction extends AbstractRudokAction{
	int a=5;
	public NewDocumentAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/document_add.png"));
		putValue(NAME, "New Document");
		putValue(SHORT_DESCRIPTION, "New Document");

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
				MainFrame.getInstance().getTree().addDocument();
			}
	}

	

