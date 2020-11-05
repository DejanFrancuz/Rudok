package dsw.rudok.app.gui.swing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.Workspace;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

public class NewProjectAction extends AbstractRudokAction{
	
	 public NewProjectAction() {
		
		 putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		 putValue(SMALL_ICON, loadIcon("images/plus.png"));
		 putValue(NAME, "New Project");
		 putValue(SHORT_DESCRIPTION, "New Project");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		RuTreeItem node = ((RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getModel().getRoot());

		Project p = new Project("Project " +  (node.getChildCount()+1),  ((RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel());
		MainFrame.getInstance().getTree().addProject(p);
		
	}

}
