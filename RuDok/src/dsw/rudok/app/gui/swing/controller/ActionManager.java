package dsw.rudok.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
	
}
