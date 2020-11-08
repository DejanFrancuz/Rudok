package dsw.rudok.app.repository;

import dsw.rudok.app.gui.swing.view.ProjectTab;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

public class Project extends RuNodeComposite {

    private ProjectTab projectTab;

    public Project(String name, RuNode parent){

        super(name,parent);
    }
    @Override
    public void addChild(RuNode child){
        if(child!=null && child instanceof Document){
            Document document= (Document)child;
            if(!this.getChildren().contains(document)){
                this.getChildren().add(document);
            }
        }
    }

    public ProjectTab getProjectTab() {
        return projectTab;
    }

    public void setProjectTab(ProjectTab projectTab) {
        this.projectTab = projectTab;
    }
}
