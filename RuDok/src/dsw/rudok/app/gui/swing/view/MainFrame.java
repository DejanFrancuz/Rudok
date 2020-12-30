package dsw.rudok.app.gui.swing.view;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

import dsw.rudok.app.core.Repository;
import dsw.rudok.app.errorHandler.MyError;
import dsw.rudok.app.gui.swing.controller.ActionManager;
import dsw.rudok.app.gui.swing.controller.JTabbedPaneCloseButton;
import dsw.rudok.app.gui.swing.tree.RuTree;
import dsw.rudok.app.gui.swing.tree.view.RuTreeImplementation;
import dsw.rudok.app.gui.swing.view.state.StateManager;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.Workspace;
import dsw.rudok.app.repository.node.RuNode;


import java.awt.*;



public class MainFrame extends  JFrame implements ISubscriber {
	


	
	private JMenuBar menu;
	private JToolBar toolBar;
	private JTree workspaceTree;
	private static MainFrame instance;
	private Repository documentRepository;
	private ActionManager actionManager;
	private RuTree tree;
	private DefaultTreeModel treeModel;
	private JTabbedPane tabbedPane;
	private JPanel jPanel;
	private StateManager stateManager;


	private MainFrame() {

	}
	
	private void initialise() {
		actionManager = new ActionManager();

	}
	
	public void initialiseWorkspaceTree() {
		tree=new RuTreeImplementation();
		workspaceTree=tree.generateTree(documentRepository.getWorkspace());
		documentRepository.getWorkspace().addSubs(this);
		initialiseGUI();
	}
	
	private void initialiseGUI() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2+100, screenHeight / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RuDok");
		
		menu = new MyMenuBar();
		setJMenuBar(menu);
		
		toolBar = new Toolbar();
		add(toolBar,BorderLayout.NORTH);
		
		JScrollPane scroll = new JScrollPane(workspaceTree);
		scroll.setMinimumSize(new Dimension(200,150));

		this.createTabbedPane();
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,tabbedPane);
		getContentPane().add(split,BorderLayout.CENTER);
		split.setDividerLocation(250);
		split.setOneTouchExpandable(true);
		setVisible(true);
	
		
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
			instance.initialise();
		}
		return instance;
	}


	private void addMyTabToTabbedPane(String name){

	}

	public JPanel getjPanel() {
		return jPanel;
	}

	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}

	private void createTabbedPane() {
		this.tabbedPane = new JTabbedPaneCloseButton();
	}

	public ActionManager getActionManager() {
		return actionManager;
	}

	public void setDocumentRepository(Repository documentRepository) {
		this.documentRepository = documentRepository;
	}

	public JMenuBar getMenu() {
		return menu;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public JTree getWorkspaceTree() {
		return workspaceTree;
	}

	public Repository getDocumentRepository() {
		return documentRepository;
	}

	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}

	public void setToolBar(JToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public void setWorkspaceTree(JTree workspaceTree) {
		this.workspaceTree = workspaceTree;
	}

	public static void setInstance(MainFrame instance) {
		MainFrame.instance = instance;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}

	public JTree getWorkspace(){
		return workspaceTree;
	}
	public RuTree getTree(){
		return tree;
	}

	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTree(RuTree tree) {
		this.tree = tree;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public StateManager getStateManager() {
		return stateManager;
	}

	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	public JTabbedPane getTabbedPane() {

		return tabbedPane;
	}


	public void showError(MyError e){
		JOptionPane.showMessageDialog(this,e.getTitle(), e.getMessage(),e.getType());
	}
	public void enableUndo(){getActionManager().getUndoAction().setEnabled(true);}
	public void enableRedo(){getActionManager().getRedoAction().setEnabled(true);}
	public void disableUndo(){getActionManager().getUndoAction().setEnabled(false);}
	public void disableRedo(){getActionManager().getRedoAction().setEnabled(false);}

	@Override
	public void update(Object notif) {
		if(notif instanceof Integer){
			int index = (Integer) notif;
			getTabbedPane().remove(index);
		}
	}
}
