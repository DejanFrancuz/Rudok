package dsw.rudok.app.gui.swing.view;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

import dsw.rudok.app.core.Repository;
import dsw.rudok.app.gui.swing.controller.ActionManager;
import dsw.rudok.app.gui.swing.tree.RuTree;
import dsw.rudok.app.gui.swing.tree.view.RuTreeImplementation;
import dsw.rudok.app.repository.node.RuNode;


import java.awt.*;



public class MainFrame extends  JFrame{
	
	
	
	private JMenuBar menu;
	private JToolBar toolBar;
	private JTree workspaceTree;
	private static MainFrame instance;
	private Repository documentRepository;
	private ActionManager actionManager;
	private RuTree tree;
	private DefaultTreeModel treeModel;
	private JDesktopPane desktop;

	private MainFrame() {
		
	}
	
	private void initialise() {
		actionManager = new ActionManager();
		
	}
	
	public void initialiseWorkspaceTree() {
		tree=new RuTreeImplementation();
		workspaceTree=tree.generateTree(documentRepository.getWorkspace());
		initialiseGUI();
	}
	
	private void initialiseGUI() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RuDok");
		
		menu = new MyMenuBar();
		setJMenuBar(menu);
		
		toolBar = new Toolbar();
		add(toolBar,BorderLayout.NORTH);
		
		this.desktop = new JDesktopPane();
		this.desktop.setBackground(Color.white);
		
		JScrollPane scroll = new JScrollPane(workspaceTree);
		scroll.setMinimumSize(new Dimension(200,150));
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
		getContentPane().add(split,BorderLayout.CENTER);
		split.setDividerLocation(250);
		split.setOneTouchExpandable(true);
				

	
		
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
			instance.initialise();
		}
		return instance;
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

	public JDesktopPane getDesktop() {
		return desktop;
	}
}
