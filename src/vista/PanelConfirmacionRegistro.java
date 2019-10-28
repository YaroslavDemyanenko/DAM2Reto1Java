package vista;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelConfirmacionRegistro extends JPanel {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7175866429394634264L;

	public JLabel lbl1, lbl2;
	
	/**
	 * Create the panel.
	 */
	
	public PanelConfirmacionRegistro() {
		setBorder(new CompoundBorder(null, new EmptyBorder(0, 5, 0, 0)));
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(1024, 588));		
	}
	
	private void instanciarObjetos() {
		setLayout(null);
		
		lbl1 = new JLabel("\u00A1FELICIDADES!");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(354, 249, 397, 35);
		add(lbl1);
		
		lbl2 = new JLabel("Elemento generado correctamente");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(354, 292, 397, 35);
		add(lbl2);
		
	}
}
