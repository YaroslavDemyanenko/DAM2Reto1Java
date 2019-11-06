package vista;

import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import modelo.objetos.Cargo;
import modelo.objetos.Departamento;
import modelo.objetos.Empleado;

import java.awt.Font;
import javax.swing.JCheckBox;

public class PanelEmple extends JPanel {

	private static final long serialVersionUID = -7098264249065901850L;

	public JTextField txtCodEmple, txtNomEmple, txtApellidos, txtSalario;
	public JLabel lblTitulo, lblCodEmple, lblNomEmple, lblDpto, lblApellidos, lblSalario, lblCargo, lblGuardarFechaY, lblSelJefe;
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
		setPreferredSize(new Dimension(1024,768));
		setLayout(null);
	}
	
	private void instanciarObjetos() {
		lblTitulo = new JLabel("INGRESO DE EMPLEADO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 1004, 77);
		add(lblTitulo);
		
		lblCodEmple = new JLabel("DNI");
		lblCodEmple.setBounds(297, 219, 152, 20);
		add(lblCodEmple);
		
		txtCodEmple = new JTextField();
		txtCodEmple.setBounds(532, 219, 214, 20);
		add(txtCodEmple);
		txtCodEmple.setColumns(10);
		
		lblNomEmple = new JLabel("Nombre");
		lblNomEmple.setBounds(297, 250, 152, 20);
		add(lblNomEmple);
		
		txtNomEmple = new JTextField();
		txtNomEmple.setBounds(532, 250, 214, 20);
		add(txtNomEmple);
		txtNomEmple.setColumns(10);
		
		lblDpto = new JLabel("Departamento");
		lblDpto.setBounds(297, 343, 152, 20);
		add(lblDpto);
		
		cmbDpto = new JComboBox<Departamento>();
		modeloDpto=new DefaultComboBoxModel<Departamento>();
		cmbDpto.setModel(modeloDpto);
		cmbDpto.setBounds(532, 343, 214, 20);
		add(cmbDpto);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(532, 516, 152, 23);
		add(btnRegistrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(54, 516, 89, 23);
		add(btnVolver);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(297, 281, 152, 20);
		add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(532, 281, 214, 20);
		add(txtApellidos);
		
		lblSalario = new JLabel("Salario");
		lblSalario.setBounds(297, 312, 152, 20);
		add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(532, 312, 214, 20);
		add(txtSalario);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(297, 374, 152, 20);
		add(lblCargo);
		
		modeloCargo = new DefaultComboBoxModel<Cargo>();
		cmbCargo = new JComboBox<Cargo>();
		cmbCargo.setModel(modeloCargo);
		cmbCargo.setBounds(532, 374, 214, 20);
		add(cmbCargo);
		
		lblGuardarFechaY = new JLabel("GUARDAR FECHA Y HORA DE CREACI\u00D3N!!!!!!!");
		lblGuardarFechaY.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGuardarFechaY.setBounds(205, 124, 413, 48);
		add(lblGuardarFechaY);
		
		chbEsJefe = new JCheckBox("\u00BFEs jefe?");
		chbEsJefe.setBounds(532, 404, 152, 23);
		add(chbEsJefe);
		
		modeloSelJefe = new DefaultComboBoxModel<Empleado>();
		cmbSelJefe = new JComboBox<Empleado>();
		cmbSelJefe.setModel(modeloSelJefe);
		cmbSelJefe.setBounds(532, 434, 214, 20);
		add(cmbSelJefe);
		
		lblSelJefe = new JLabel("Seleccionar superior");
		lblSelJefe.setBounds(297, 434, 152, 20);
		add(lblSelJefe);
	}
}
