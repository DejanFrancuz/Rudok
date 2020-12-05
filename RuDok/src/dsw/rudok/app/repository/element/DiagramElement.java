package dsw.rudok.app.repository.element;

import dsw.rudok.app.gui.swing.view.painters.ElementPainter;

public abstract class DiagramElement{
    public String name;
    public String description;

    public ElementPainter elementPainter;

    public DiagramElement(String name){
        this.name=name;
    }

    public ElementPainter getElementPainter() {
        return elementPainter;
    }

    public void setElementPainter(ElementPainter elementPainter) {
        this.elementPainter = elementPainter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
