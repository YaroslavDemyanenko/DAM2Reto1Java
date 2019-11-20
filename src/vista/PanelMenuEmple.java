package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.objetos.Empleado;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class PanelMenuEmple extends JPanel {

	private static final long serialVersionUID = 2656417989723357437L;
	public JButton btnIngresarEmple, btnVolver, btnBuscar;
	public JList<String> listDatosEmple;
	public DefaultListModel<String> modeloListDatosEmple;
	public JLabel lblBuscarEmple, lblMenuGestionEmpleados;
	public JTextField txtBuscarEmple;
	public DefaultComboBoxModel<Empleado> modeloCmbEmpleados;
	public JComboBox<Empleado> cmbEmpleados;

	public PanelMenuEmple() {
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setBorder(null);
		setPreferredSize(new Dimension(1000, 770));
		setLayout(null);
		setBackground(new Color(136, 136, 207));
		setForeground(Color.WHITE);
	}

	private void instanciarObjetos() {

		btnIngresarEmple = new JButton("INGRESAR NUEVO EMPLEADO");
		btnIngresarEmple.setForeground(new Color(255, 255, 255));
		btnIngresarEmple.setBounds(334, 143, 331, 38);
		add(btnIngresarEmple);

		lblBuscarEmple = new JLabel("BUSCAR EMPLEADO");
		lblBuscarEmple.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarEmple.setForeground(new Color(255, 255, 255));
		lblBuscarEmple.setBounds(308, 211, 384, 50);
		lblBuscarEmple.setFont(new Font("Perpetua", Font.PLAIN, 20));
		add(lblBuscarEmple);

		txtBuscarEmple = new JTextField();
		txtBuscarEmple.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtBuscarEmple.setForeground(new Color(1,35,80));
		txtBuscarEmple.setToolTipText("Ingresar nombre o ID");
		txtBuscarEmple.setColumns(10);
		txtBuscarEmple.setBounds(334, 283, 331, 38);
		txtBuscarEmple.setBorder(BorderFactory.createLineBorder(new Color(1, 35, 80), 2));
		add(txtBuscarEmple);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBounds(334, 334, 331, 38);
		add(btnBuscar);

		modeloListDatosEmple = new DefaultListModel<String>();

		listDatosEmple = new JList<String>(modeloListDatosEmple);
		listDatosEmple.setBorder(new LineBorder(new Color(1, 35, 80)));
		listDatosEmple.setFont(new Font("Dialog", Font.PLAIN, 17));
		listDatosEmple.setForeground(new Color(1, 35, 80));
		listDatosEmple.setBounds(282, 449, 435, 207);
		add(listDatosEmple);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnVolver.setBounds(46, 667, 130, 38);
		btnVolver.setBackground(new Color(1, 35, 80));
		btnVolver.setForeground(new Color(255, 255, 255));
		add(btnVolver);

		modeloCmbEmpleados = new DefaultComboBoxModel<Empleado>();

		cmbEmpleados = new JComboBox<Empleado>(modeloCmbEmpleados);
		cmbEmpleados.setFont(new Font("Dialog", Font.PLAIN, 17));
		cmbEmpleados.setBackground(new Color(1, 35, 80));
		cmbEmpleados.setForeground(Color.WHITE);
		cmbEmpleados.setUI(new BasicComboBoxUI());
		cmbEmpleados.setBounds(334, 383, 331, 38);
		cmbEmpleados.setBorder(new LineBorder(new Color(1, 35, 80)));
		add(cmbEmpleados);

		btnIngresarEmple.setBackground(new Color(1, 35, 80));
		btnBuscar.setBackground(new Color(1, 35, 80));
		btnIngresarEmple.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnBuscar.setFont(new Font("Perpetua", Font.PLAIN, 20));

		lblMenuGestionEmpleados = new JLabel("MENU GESTION EMPLEADOS");
		lblMenuGestionEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuGestionEmpleados.setForeground(Color.WHITE);
		lblMenuGestionEmpleados.setFont(new Font("Perpetua", Font.PLAIN, 25));
		lblMenuGestionEmpleados.setBounds(254, 41, 492, 77);
		add(lblMenuGestionEmpleados);
		
	
		
		
		
		btnBuscar.setFocusPainted(false);
		btnIngresarEmple.setFocusPainted(false);
		btnVolver.setFocusPainted(false);
        cmbEmpleados.setFocusable(false);
	}
}