package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modelo.objetos.Empleado;

public class PanelMenuDpto extends JPanel {

	private static final long serialVersionUID = -2619620055781727212L;
	
	public JLabel lblTitulo, lblNombreDpto;
	public JButton btnIngresarDpto, btnSiguiente, btnUltimo, btnAnterior, btnPrimero, btnVolver;
	public DefaultListModel<Empleado> modeloListaEmple;
	public JList<Empleado> listEmpleados;
	
	public PanelMenuDpto() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setBorder(null);
		setPreferredSize(new Dimension(1000,770));
		setLayout(null);
		setBackground(new Color(136, 136, 207));
		setForeground(Color.WHITE);
	}
	
	private void instanciarObjetos() {
		lblTitulo = new JLabel("MENU GESTION DEPARTAMENTO");
		lblTitulo.setFont(new Font("Perpetua", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(254, 41, 492, 77);
		lblTitulo.setForeground(Color.WHITE);
		add(lblTitulo);
		
		btnIngresarDpto = new JButton("INGRESAR NUEVO DEPARTAMENTO");
		btnIngresarDpto.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnIngresarDpto.setBounds(273, 194, 453, 38);
		btnIngresarDpto.setBackground(new Color(1,35,80));
		btnIngresarDpto.setForeground(Color.WHITE);
		add(btnIngresarDpto);
		
		lblNombreDpto = new JLabel("[nombre_departamento]");
		lblNombreDpto.setFont(new Font("Perpetua", Font.PLAIN, 20));
		lblNombreDpto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDpto.setBounds(362, 330, 272, 23);
		lblNombreDpto.setForeground(Color.WHITE);
		add(lblNombreDpto);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnSiguiente.setBounds(644, 322, 130, 38);
		btnSiguiente.setBackground(new Color(1,35,80));
		btnSiguiente.setForeground(Color.WHITE);
		add(btnSiguiente);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnUltimo.setBounds(803, 322,130, 38);
		btnUltimo.setBackground(new Color(1,35,80));
		btnUltimo.setForeground(Color.WHITE);
		add(btnUltimo);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnAnterior.setBounds(222, 322,130, 38);
		btnAnterior.setBackground(new Color(1,35,80));
		btnAnterior.setForeground(Color.WHITE);
		add(btnAnterior);
		
		btnPrimero = new JButton("Primero");
		btnPrimero.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnPrimero.setBounds(69, 322, 130, 38);
		btnPrimero.setBackground(new Color(1,35,80));
		btnPrimero.setForeground(Color.WHITE);
		add(btnPrimero);
		
		modeloListaEmple = new DefaultListModel<Empleado>();
		
		listEmpleados = new JList<Empleado>(modeloListaEmple);
		listEmpleados.setFont(new Font("Dialog", Font.PLAIN, 17));
		listEmpleados.setBounds(282, 398, 435, 207);
		listEmpleados.setForeground(new Color(1,35,80));
		listEmpleados.setBorder(new LineBorder(new Color(1, 35, 80)));
		add(listEmpleados);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnVolver.setBounds(46, 667, 130, 38);
		btnVolver.setForeground(Color.WHITE);
		add(btnVolver);
		
		btnIngresarDpto.setBackground(new Color(1,35,80));
		btnSiguiente.setBackground(new Color(1,35,80));
		btnUltimo.setBackground(new Color(1,35,80));
		btnAnterior.setBackground(new Color(1,35,80));
		btnPrimero.setBackground(new Color(1,35,80));
		btnVolver.setBackground(new Color(1,35,80));
		
		
		btnIngresarDpto.setFocusPainted(false);
		btnSiguiente.setFocusPainted(false);
		btnUltimo.setFocusPainted(false);
		btnAnterior.setFocusPainted(false);
		btnPrimero.setFocusPainted(false);
		btnVolver.setFocusPainted(false);
		
		
		
	}
}
