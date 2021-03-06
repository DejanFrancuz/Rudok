package dsw.rudok.app.gui.swing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;


import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.gui.swing.view.ProjectTab;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.Workspace;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

public class NewProjectAction extends AbstractRudokAction{
	
	 public NewProjectAction() {
		
		 putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		 putValue(SMALL_ICON, loadIcon("images/Project-icon.png"));
		 putValue(NAME, "New Project");
		 putValue(SHORT_DESCRIPTION, "New Project");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().getTree().addProject();
	}
}

