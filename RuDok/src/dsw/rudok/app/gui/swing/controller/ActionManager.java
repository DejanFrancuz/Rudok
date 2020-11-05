package dsw.rudok.app.gui.swing.controller;




public class ActionManager {

	private ExitAction exitAction;
	private NewProjectAction newProjectAction;
	private NewDocumentAction newDocumentAction;
	private NewPageAction newPageAction;
	
	public ActionManager() {
		initialiseActions();
	}
	
	private void initialiseActions() {
		exitAction = new ExitAction();
		newProjectAction = new NewProjectAction();
		newDocumentAction = new NewDocumentAction();
		newPageAction=new NewPageAction();
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

	public NewDocumentAction getNewDocumentAction() {
		return newDocumentAction;
	}

	public void setNewDocumentAction(NewDocumentAction newDocumentAction) {
		this.newDocumentAction = newDocumentAction;
	}

	public NewPageAction getNewPageAction() {
		return newPageAction;
	}

	public void setNewPageAction(NewPageAction newPageAction) {
		this.newPageAction = newPageAction;
	}
}
