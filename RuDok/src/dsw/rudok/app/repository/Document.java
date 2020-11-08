package dsw.rudok.app.repository;

import dsw.rudok.app.gui.swing.view.DocumentTab;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

public class Document extends RuNodeComposite {

    private DocumentTab documentTab;

    public Document(String name, RuNode parent) {

        super(name, parent);
    }


    public void addChild(RuNode child){
        if(child!=null && child instanceof Page){
            Page page=(Page)child;
            if(!this.getChildren().contains(page)){
                this.getChildren().add(page);
            }
        }
    }

    public DocumentTab getDocumentTab() {
        return documentTab;
    }

    public void setDocumentTab(DocumentTab documentTab) {
        this.documentTab = documentTab;
    }
}
