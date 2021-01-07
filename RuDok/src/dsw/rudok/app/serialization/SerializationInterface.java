package dsw.rudok.app.serialization;

import dsw.rudok.app.repository.Page;

import javax.swing.*;
import java.io.File;

public interface SerializationInterface {
    void save(Page p, File pageFile);
    void open(JFileChooser jfc);
}
