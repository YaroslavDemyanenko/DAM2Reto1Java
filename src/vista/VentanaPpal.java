package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import javafx.scene.layout.Border;

public class VentanaPpal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public PanelCenter pCenter;
	public BorderLayout border;
	
	public VentanaPpal() {
		setIconImage(null);
		getContentPane().setBackground(Color.WHITE);	
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		border = new BorderLayout(5,5);
		setLayout(border);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1024,768));		
		//setSize(new Dimension(1024,768));
		setTitle("Reto 1");
		setVisible(true);
		pack();
		
	}
	
	private void instanciarObjetos() {
		pCenter = new PanelCenter();
		add(pCenter,BorderLayout.CENTER);
	}
}
