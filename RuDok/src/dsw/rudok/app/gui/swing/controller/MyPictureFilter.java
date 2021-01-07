package dsw.rudok.app.gui.swing.controller;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class MyPictureFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        return f.getName().toLowerCase().endsWith(".jpg");
    }

    @Override
    public String getDescription() {
        return "Joint Photographic Experts Group (*.jpg)";
    }
}
