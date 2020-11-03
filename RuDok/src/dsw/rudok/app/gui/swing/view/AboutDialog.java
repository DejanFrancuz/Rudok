package dsw.rudok.app.gui.swing.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AboutDialog extends JDialog{

	public AboutDialog() {
		
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new BorderLayout());
		
		JLabel lbl1 = new JLabel("Ignjat Krdzavac RN 115/20");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl2 = new JLabel("Dejan Francuz ");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(lbl1,BorderLayout.NORTH);
		panel.add(lbl2,BorderLayout.AFTER_LAST_LINE);
		
		
		
		this.add(panel);
		this.pack();
		setVisible(true);
		
	}
}
