package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelMenuDpto extends JPanel {
	
	private static final long serialVersionUID = 2097932691575063214L;

	public JLabel lblTitulo, lblNombreDpto;
	public JButton btnIngresarDpto, btnSiguiente, btnUltimo, btnAnterior, btnPrimero, btnVolver;
	public JList listEmpleados;
	
	public PanelMenuDpto() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(1024, 588));
		setLayout(null);
	}
	
	private void instanciarObjetos() {
		lblTitulo = new JLabel("MENÚ GESTIÓN DEPARTAMENTO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 1004, 77);
		add(lblTitulo);
		
		btnIngresarDpto = new JButton("INGRESAR NUEVO DEPARTAMENTO");
		btnIngresarDpto.setBounds(393, 156, 226, 23);
		add(btnIngresarDpto);
		
		lblNombreDpto = new JLabel("");
		lblNombreDpto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDpto.setBounds(419, 322, 200, 23);
		add(lblNombreDpto);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(629, 322, 89, 23);
		add(btnSiguiente);
		
		btnUltimo = new JButton("\u00DAltimo");
		btnUltimo.setBounds(728, 322, 89, 23);
		add(btnUltimo);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(320, 322, 89, 23);
		add(btnAnterior);
		
		btnPrimero = new JButton("Primero");
		btnPrimero.setBounds(221, 322, 89, 23);
		add(btnPrimero);
		
		listEmpleados = new JList();
		listEmpleados.setBorder(new LineBorder(new Color(0, 0, 0)));
		listEmpleados.setBackground(Color.LIGHT_GRAY);
		listEmpleados.setBounds(320, 398, 398, 150);
		add(listEmpleados);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(54, 516, 89, 23);
		add(btnVolver);
	}
}
