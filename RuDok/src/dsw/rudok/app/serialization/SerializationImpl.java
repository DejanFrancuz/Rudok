package dsw.rudok.app.serialization;

import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.element.Slot;

import javax.swing.*;
import java.io.*;

public class SerializationImpl implements SerializationInterface{


    @Override
    public void save(Page page, File pageFile) {

        ObjectOutputStream os;

        try {
            os = new ObjectOutputStream(new FileOutputStream(pageFile));
            os.writeObject(page);
            page.setPageFile(pageFile);
            page.setChanged(false);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void open(JFileChooser jfc) {

        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

            Page page = null;
            try {
                page = (Page) os.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            //AppCore.getInstance().getWorkspaceTree().addProject(p);
            MainFrame.getInstance().getTree().addPage();

            for (int i = 0; i < page.getChildren().size(); i++) {
                Slot slot = (Slot) page.getChildren().get(i);
                //MainFrame.getInstance().getTabbedPane().add(dtab);
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
