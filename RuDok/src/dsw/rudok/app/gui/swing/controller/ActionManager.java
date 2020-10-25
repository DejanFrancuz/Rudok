package dsw.rudok.app.gui.swing.controller;

public class ActionManager {

	private ExitAction exitAction;
	private NewProjectAction newProjectAction;
	
	public ActionManager() {
		
	}
	
	private void initialiseActions() {
		exitAction = new ExitAction();
		newProjectAction = new NewProjectAction();
	}
}
