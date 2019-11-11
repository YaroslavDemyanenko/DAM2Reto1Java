package vista;

import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPpal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public PanelCenter pCenter;
	
	public VentanaPpal() {		
		setParametros();
		instanciarObjetos();
		setIconImage(null);
		getContentPane().setBackground(Color.WHITE);
	}
	
	private void setParametros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024,768);
		setLocationRelativeTo(null);
		setResizable(true);		
		setTitle("Reto 1");
		setVisible(true);
	}
	
	private void instanciarObjetos() {
		pCenter = new PanelCenter();
		add(pCenter);
	}
}
