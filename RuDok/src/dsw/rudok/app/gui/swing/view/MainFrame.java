package dsw.rudok.app.gui.swing.view;

import javax.swing.*;

import dsw.rudok.app.core.Repository;
import dsw.rudok.app.gui.swing.controller.ActionManager;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter

public class MainFrame extends  JFrame{
	
	
	
	private JMenuBar menu;
	private JToolBar toolBar;
	private JTree workspaceTree;
	private static MainFrame instance;
	private Repository documentRepository;
	private ActionManager actionManager;

	private MainFrame() {
		
	}
	
	private void initialise() {
		actionManager = new ActionManager();
		
	}
	
	public void initialiseWorkspaceTree() {
		
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
		
		JPanel desktop = new JPanel();
		
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
}
