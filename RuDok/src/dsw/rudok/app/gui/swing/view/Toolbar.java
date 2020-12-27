package dsw.rudok.app.gui.swing.view;

import javax.swing.*;

public class Toolbar extends JToolBar{
	
	public Toolbar() {
		super(HORIZONTAL);
		setFloatable(false);
		
		add(MainFrame.getInstance().getActionManager().getExitAction());
		add(MainFrame.getInstance().getActionManager().getNewProjectAction());
		add(MainFrame.getInstance().getActionManager().getNewDocumentAction());
		add(MainFrame.getInstance().getActionManager().getNewPageAction());
		add(MainFrame.getInstance().getActionManager().getDeleteNode());
		add(MainFrame.getInstance().getActionManager().getShareDocumentAction());
		add(MainFrame.getInstance().getActionManager().getCircleAction());
		add(MainFrame.getInstance().getActionManager().getRectangleAction());
		add(MainFrame.getInstance().getActionManager().getTriangleAction());
		add(MainFrame.getInstance().getActionManager().getSelectAction());
		add(MainFrame.getInstance().getActionManager().getMoveAction());
		add(MainFrame.getInstance().getActionManager().getResizeAction());
		add(MainFrame.getInstance().getActionManager().getRotateAction());
		add(MainFrame.getInstance().getActionManager().getDeleteSlotAction());
		add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
		add(MainFrame.getInstance().getActionManager().getSaveProjectAction());
		add(MainFrame.getInstance().getActionManager().getUndoAction());
		add(MainFrame.getInstance().getActionManager().getRedoAction());
		add(MainFrame.getInstance().getActionManager().getLassoAction());
	}
	
}
