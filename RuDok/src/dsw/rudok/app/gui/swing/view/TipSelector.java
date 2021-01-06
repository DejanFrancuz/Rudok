package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.repository.element.Slot;
import dsw.rudok.app.repository.element.TipSlota;

import javax.swing.*;
import javax.tools.DocumentationTool;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TipSelector extends JDialog {

    private  JLabel label = new JLabel();
    private JButton btnGraphic,btnText;
    private Slot slot;

    public TipSelector(Slot slot){

        setTitle("Izbor tipa selektovanog slota");
        setLocationRelativeTo(null);


        this.slot = slot;
        label.setText("Izaberite tip Slota:");

        btnGraphic = new JButton("Graficki");
        btnText = new JButton("Tekstualni");

        btnText.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slot.setTip(TipSlota.TEKSTUALNI);
                setVisible(false);

            }
        });


        btnGraphic.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slot.setTip(TipSlota.GRAFICKI);
                setVisible(false);
            }
        });

        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());



        jp.add(label,BorderLayout.CENTER);
        jp.add(btnText);
        jp.add(btnGraphic);

        this.setSize(new Dimension(200,100));
        add(jp);

    }

}
