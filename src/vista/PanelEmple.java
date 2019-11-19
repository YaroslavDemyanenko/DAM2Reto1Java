package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

import modelo.objetos.Cargo;
import modelo.objetos.Departamento;
import modelo.objetos.Empleado;

import java.awt.Font;
import javax.swing.JCheckBox;

public class PanelEmple extends JPanel {

	private static final long serialVersionUID = -7098264249065901850L;

	public JTextField txtCodEmple, txtNomEmple, txtApellidos, txtSalario;
	public JLabel lblTitulo, lblCodEmple, lblNomEmple, lblDpto, lblApellidos, lblSalario, lblCargo, lblSelJefe;
	public JButton btnVolver, btnRegistrar;
	public JComboBox<Departamento> cmbDpto;
	public JComboBox<Cargo> cmbCargo;
	public JComboBox<Empleado> cmbSelJefe;
	public DefaultComboBoxModel<Departamento> modeloDpto;
	public DefaultComboBoxModel<Cargo> modeloCargo;
	public DefaultComboBoxModel<Empleado> modeloSelJefe;
	public JCheckBox chbEsJefe;
	
	public PanelEmple() {
		
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setBorder(new CompoundBorder(null, new EmptyBorder(0, 5, 0, 0)));
		setPreferredSize(new Dimension(1000,770));
		setLayout(null);
		setBackground(new Color(136, 136, 207));
		setForeground(Color.WHITE);
	}
	
	private void instanciarObjetos() {
		lblTitulo = new JLabel("INGRESO DE EMPLEADO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(260, 59, 479, 77);
		lblTitulo.setForeground(Color.WHITE);
		add(lblTitulo);
		
		lblCodEmple = new JLabel("DNI");
		lblCodEmple.setBounds(297, 223, 152, 20);
		add(lblCodEmple);
		
		txtCodEmple = new JTextField();
		txtCodEmple.setBounds(532, 219, 268, 30);
		add(txtCodEmple);
		txtCodEmple.setColumns(10);
		
		lblNomEmple = new JLabel("Nombre");
		lblNomEmple.setBounds(297, 254, 152, 20);
		add(lblNomEmple);
		
		txtNomEmple = new JTextField();
		txtNomEmple.setBounds(532, 250, 268, 30);
		add(txtNomEmple);
		txtNomEmple.setColumns(10);
		
		lblDpto = new JLabel("Departamento");
		lblDpto.setBounds(297, 345, 152, 20);
		add(lblDpto);
		
		cmbDpto = new JComboBox<Departamento>();
		modeloDpto=new DefaultComboBoxModel<Departamento>();
		cmbDpto.setModel(modeloDpto);
		cmbDpto.setBounds(532, 343, 268, 30);
		add(cmbDpto);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(532, 516, 268, 30);
		add(btnRegistrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnVolver.setBounds(46, 667, 130, 38);
		btnVolver.setBackground(new Color(1, 35, 80));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setFocusPainted(false);
		add(btnVolver);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(297, 285, 152, 20);
		add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(532, 281, 268, 30);
		add(txtApellidos);
		
		lblSalario = new JLabel("Salario");
		lblSalario.setBounds(297, 314, 152, 20);
		add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(532, 312, 268, 30);
		add(txtSalario);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(297, 376, 152, 20);
		add(lblCargo);
		
		modeloCargo = new DefaultComboBoxModel<Cargo>();
		cmbCargo = new JComboBox<Cargo>();
		cmbCargo.setModel(modeloCargo);
		cmbCargo.setBounds(532, 374, 268, 30);
		add(cmbCargo);
		
		chbEsJefe = new JCheckBox("¿Es jefe?");
		chbEsJefe.setBounds(601, 453, 152, 23);
		add(chbEsJefe);
		
		modeloSelJefe = new DefaultComboBoxModel<Empleado>();
		cmbSelJefe = new JComboBox<Empleado>();
		cmbSelJefe.setModel(modeloSelJefe);
		cmbSelJefe.setBounds(532, 405, 268, 30);
		add(cmbSelJefe);
		
		lblSelJefe = new JLabel("Seleccionar superior");
		lblSelJefe.setBounds(297, 408, 152, 20);
		add(lblSelJefe);
		
		
		txtCodEmple.setBorder(BorderFactory.createLineBorder(new Color(1, 35, 80), 2));
		txtNomEmple.setBorder(BorderFactory.createLineBorder(new Color(1, 35, 80), 2));
		txtApellidos.setBorder(BorderFactory.createLineBorder(new Color(1, 35, 80), 2));
		txtSalario.setBorder(BorderFactory.createLineBorder(new Color(1, 35, 80), 2));
		txtCodEmple.setBorder(BorderFactory.createLineBorder(new Color(1, 35, 80), 2));
		
		txtCodEmple.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtNomEmple.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtApellidos.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtSalario.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtCodEmple.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		txtCodEmple.setForeground(new Color(1,35,80));
		txtNomEmple.setForeground(new Color(1,35,80));
		txtApellidos.setForeground(new Color(1,35,80));
		txtSalario.setForeground(new Color(1,35,80));
		txtCodEmple.setForeground(new Color(1,35,80));
		
		
		
		cmbCargo.setBackground(new Color(1, 35, 80));
		cmbCargo.setForeground(Color.WHITE);
		cmbCargo.setUI(new BasicComboBoxUI());
		cmbCargo.setBorder(new LineBorder(new Color(1, 35, 80)));
		cmbCargo.setFocusable(false);
		
		cmbSelJefe.setBackground(new Color(1, 35, 80));
		cmbSelJefe.setForeground(Color.WHITE);
		cmbSelJefe.setUI(new BasicComboBoxUI());
		cmbSelJefe.setBorder(new LineBorder(new Color(1, 35, 80)));
		cmbSelJefe.setFocusable(false);
		
		cmbDpto.setBackground(new Color(1, 35, 80));
		cmbDpto.setForeground(Color.WHITE);
		cmbDpto.setUI(new BasicComboBoxUI());
		cmbDpto.setBorder(new LineBorder(new Color(1, 35, 80)));
		cmbDpto.setFocusable(false);
			
		chbEsJefe.setBackground(new Color(136, 136, 207));
		chbEsJefe.setForeground(new Color(255,255,255));
		chbEsJefe.setFocusPainted(false);
		chbEsJefe.setFont(new Font("Dialog", Font.PLAIN, 17));
	
		btnRegistrar.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnRegistrar.setBackground(new Color(1, 35, 80));
		btnRegistrar.setForeground(new Color(255,255,255));
		
		
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblCodEmple.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNomEmple.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblDpto.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblApellidos.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblSalario.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblCargo.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblSelJefe.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		lblTitulo.setForeground(Color.WHITE);
		lblCodEmple.setForeground(Color.WHITE);
		lblNomEmple.setForeground(Color.WHITE);
		lblDpto.setForeground(Color.WHITE);
		lblApellidos.setForeground(Color.WHITE);
		lblSalario.setForeground(Color.WHITE);
		lblCargo.setForeground(Color.WHITE);
		lblSelJefe.setForeground(Color.WHITE);
	}
}
