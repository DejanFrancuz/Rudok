package dsw.rudok.app.gui.swing.tree.view;



import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.Workspace;


import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class RuTreeCellRender extends DefaultTreeCellRenderer {

    public RuTreeCellRender(){

    }
    public Component getTreeCellRenderComponent(JTree tree,Object value,boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){
        super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);
        if(((RuTreeItem)value).getNodeModel() instanceof Workspace){
            URL imageURL= getClass().getResource("images/tdiagram.gif");
            Icon icon=null;
            if(imageURL != null)
                icon=new ImageIcon((imageURL));
            setIcon(icon);
        }else if(((RuTreeItem)value).getNodeModel() instanceof Project){
            URL imageURL = getClass().getResource("images/tproject.gif");
            Icon icon = null;
            if(imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        }
        return this;
    }

}
