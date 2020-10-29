package dsw.rudok.app.gui.swing.controller;




public class ActionManager {

	private ExitAction exitAction;
	private NewProjectAction newProjectAction;
	
	public ActionManager() {
		initialiseActions();
	}
	
	private void initialiseActions() {
		exitAction = new ExitAction();
		newProjectAction = new NewProjectAction();
	}

	public ExitAction getExitAction() {
		return exitAction;
	}

	public NewProjectAction getNewProjectAction() {
		return newProjectAction;
	}

	public void setExitAction(ExitAction exitAction) {
		this.exitAction = exitAction;
	}

	public void setNewProjectAction(NewProjectAction newProjectAction) {
		this.newProjectAction = newProjectAction;
	}
}
