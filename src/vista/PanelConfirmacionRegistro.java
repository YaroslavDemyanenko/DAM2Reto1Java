package vista;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class PanelConfirmacionRegistro extends JPanel {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7175866429394634264L;

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
		
	}

}
