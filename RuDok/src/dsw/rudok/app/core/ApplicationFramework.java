package dsw.rudok.app.core;

import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
public abstract class ApplicationFramework {

    protected Gui gui;
    protected Repository repository;

    public abstract void run():
    public void initialise(Gui gui,Repository repository){
        this.gui = gui;
        this.repository=repository;
    }
}
