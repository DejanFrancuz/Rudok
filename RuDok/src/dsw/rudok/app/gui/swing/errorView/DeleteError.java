package dsw.rudok.app.gui.swing.errorView;

import javax.swing.*;
import java.awt.*;

public class DeleteError extends JDialog {

    public DeleteError(){
        JLabel poruka = new JLabel("Cvor mora biti selektovan!!!");

        add((poruka), BorderLayout.CENTER);

        setSize(300,300);
        setTitle("Warning!");
        this.setVisible(true);
    }

}
