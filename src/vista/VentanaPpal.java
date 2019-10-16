package vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPpal extends JFrame {


	private static final long serialVersionUID = 1L;
	
	public BorderLayout border;
	

	public VentanaPpal() {
		setIconImage(null);
		getContentPane().setBackground(Color.WHITE);	
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		border = new BorderLayout(0,0);
		getContentPane().setLayout(border);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024,768);		
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Reto 1");
		setVisible(true);
	}
	
	private void instanciarObjetos() {
		
	}
}
