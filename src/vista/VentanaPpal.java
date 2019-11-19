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
		setSize(1000,770);
		setLocationRelativeTo(null);
		setResizable(true);		
		setTitle("Reto 1");
		setVisible(true);
		setBackground(new Color(180,187,194));
		setForeground(Color.WHITE);
	}
	
	private void instanciarObjetos() {
		pCenter = new PanelCenter();
		add(pCenter);
	}
}
