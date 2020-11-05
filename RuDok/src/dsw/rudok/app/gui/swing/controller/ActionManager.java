package dsw.rudok.app.gui.swing.controller;




public class ActionManager {

	private ExitAction exitAction;
	private NewProjectAction newProjectAction;
	private NewDocumentAction newDocumentAction;
	private NewPageAction newPageAction;
	private NewSlotAction newSlotAction;
	private DeleteNode deleteNode;
	
	public ActionManager() {
		initialiseActions();
	}
	
	private void initialiseActions() {
		exitAction = new ExitAction();
		newProjectAction = new NewProjectAction();
		newDocumentAction = new NewDocumentAction();
		newPageAction=new NewPageAction();
		newSlotAction=new NewSlotAction();
		deleteNode=new DeleteNode();
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

	public NewSlotAction getNewSlotAction() {
		return newSlotAction;
	}

	public void setNewSlotAction(NewSlotAction newSlotAction) {
		this.newSlotAction = newSlotAction;
	}

	public DeleteNode getDeleteNode() {
		return deleteNode;
	}

	public void setDeleteNode(DeleteNode deleteNode) {
		this.deleteNode = deleteNode;
	}
}
