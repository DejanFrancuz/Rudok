package dsw.rudok.app.gui.swing.controller;


public class ActionManager {

	private ExitAction exitAction;
	private NewProjectAction newProjectAction;
	private NewDocumentAction newDocumentAction;
	private NewPageAction newPageAction;
	private DeleteNode deleteNode;
	private ShareDocumentAction shareDocumentAction;
	private CircleAction circleAction;
	private RectangleAction rectangleAction;
	private TriangleAction triangleAction;
	private SelectAction selectAction;
	private MoveAction moveAction;
	private ResizeAction resizeAction;
	private RotateAction rotateAction;
	private DeleteSlotAction deleteSlotAction;
	private OpenProjectAction openProjectAction;
	private SaveProjectAction saveProjectAction;
	
	public ActionManager() {
		initialiseActions();
	}
	
	private void initialiseActions() {
		exitAction = new ExitAction();
		newProjectAction = new NewProjectAction();
		newDocumentAction = new NewDocumentAction();
		newPageAction=new NewPageAction();
		deleteNode=new DeleteNode();
		shareDocumentAction=new ShareDocumentAction();
		circleAction=new CircleAction();
		rectangleAction=new RectangleAction();
		triangleAction=new TriangleAction();
		selectAction=new SelectAction();
		moveAction = new MoveAction();
		resizeAction=new ResizeAction();
		rotateAction=new RotateAction();
		deleteSlotAction=new DeleteSlotAction();
		openProjectAction=new OpenProjectAction();
		saveProjectAction=new SaveProjectAction();
	}

	public MoveAction getMoveAction() {
		return moveAction;
	}

	public void setMoveAction(MoveAction moveAction) {
		this.moveAction = moveAction;
	}

	public ResizeAction getResizeAction() {
		return resizeAction;
	}

	public void setResizeAction(ResizeAction resizeAction) {
		this.resizeAction = resizeAction;
	}

	public RotateAction getRotateAction() {
		return rotateAction;
	}

	public void setRotateAction(RotateAction rotateAction) {
		this.rotateAction = rotateAction;
	}

	public DeleteSlotAction getDeleteSlotAction() {
		return deleteSlotAction;
	}

	public void setDeleteSlotAction(DeleteSlotAction deleteSlotAction) {
		this.deleteSlotAction = deleteSlotAction;
	}

	public RectangleAction getRectangleAction() {
		return rectangleAction;
	}

	public void setRectangleAction(RectangleAction rectangleAction) {
		this.rectangleAction = rectangleAction;
	}

	public TriangleAction getTriangleAction() {
		return triangleAction;
	}

	public void setTriangleAction(TriangleAction triangleAction) {
		this.triangleAction = triangleAction;
	}

	public SelectAction getSelectAction() {
		return selectAction;
	}

	public void setSelectAction(SelectAction selectAction) {
		this.selectAction = selectAction;
	}

	public CircleAction getCircleAction() {
		return circleAction;
	}

	public void setCircleAction(CircleAction circleAction) {
		this.circleAction = circleAction;
	}

	public ShareDocumentAction getShareDocumentAction() {
		return shareDocumentAction;
	}

	public void setShareDocumentAction(ShareDocumentAction shareDocumentAction) {
		this.shareDocumentAction = shareDocumentAction;
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


	public DeleteNode getDeleteNode() {
		return deleteNode;
	}

	public void setDeleteNode(DeleteNode deleteNode) {
		this.deleteNode = deleteNode;
	}

	public OpenProjectAction getOpenProjectAction() {
		return openProjectAction;
	}

	public void setOpenProjectAction(OpenProjectAction openProjectAction) {
		this.openProjectAction = openProjectAction;
	}

	public SaveProjectAction getSaveProjectAction() {
		return saveProjectAction;
	}

	public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
		this.saveProjectAction = saveProjectAction;
	}
}
