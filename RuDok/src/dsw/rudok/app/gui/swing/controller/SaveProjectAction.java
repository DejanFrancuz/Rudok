package dsw.rudok.app.gui.swing.controller;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.core.ApplicationFramework;
import dsw.rudok.app.gui.swing.tree.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class SaveProjectAction extends AbstractRudokAction{
    public SaveProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/save-icon.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new MyFileFilter());


        RuTreeItem item= ((RuTreeItem)MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent());
        //MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        Page page= (Page)item.getNodeModel();
        File pageFile=page.getPageFile();


       /* if (!page.isChanged()){
            System.out.println("ZASTO");
            return;
        }*/

        if (page.getPageFile()==null){
            if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                pageFile=jfc.getSelectedFile();
            }else{
                return;
            }

        }


       /* ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(projectFile));
            os.writeObject(project);
            project.setProjectFile(projectFile);
            project.setChanged(false);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/


        AppCore.getInstance().getSerializationInterface().save(page,pageFile);
    }
}
