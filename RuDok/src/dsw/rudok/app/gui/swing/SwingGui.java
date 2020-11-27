package dsw.rudok.app.gui.swing;

import dsw.rudok.app.core.Gui;
import dsw.rudok.app.core.Repository;
import dsw.rudok.app.errorHandler.MyError;
import dsw.rudok.app.gui.swing.view.MainFrame;

public class SwingGui implements Gui{

	private MainFrame instance;
	private Repository documentRepository;
	
	
	
	public SwingGui(Repository repository) {
		
		this.documentRepository = repository;
	}



	@Override
	public void start() {
		instance = MainFrame.getInstance();
		instance.setDocumentRepository(documentRepository);
		instance.setVisible(true);
		instance.initialiseWorkspaceTree();
		
	}
	public void update(Object notif){
		if(notif instanceof MyError){
			MyError e=(MyError)notif;
			MainFrame.getInstance().showError(e);
		}
	}
}
