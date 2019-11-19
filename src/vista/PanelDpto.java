package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.objetos.Centro;

public class PanelDpto extends JPanel {
	
	private static final long serialVersionUID = 8913709538637781966L;
	
	public JTextField txtCodigoDpto, txtNombreDpto;
	public JLabel lblTitulo, lblCodigoDpto, lblNombreDpto, lblCentro;
	public JButton btnVolver, btnRegistrar;
	public JComboBox<Centro> cmbCentro;
	public DefaultComboBoxModel<Centro> modeloCmbCentro;
	
	public PanelDpto() {
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
		lblTitulo = new JLabel("INGRESO DE DEPARTAMENTO");
		lblTitulo.setBounds(10, 11, 1004, 77);
		add(lblTitulo);
		
		lblCodigoDpto = new JLabel("C\u00F3digo de departamento");
		lblCodigoDpto.setBounds(297, 219, 152, 20);
		add(lblCodigoDpto);
		
		txtCodigoDpto = new JTextField();
		txtCodigoDpto.setBounds(532, 219, 152, 20);
		add(txtCodigoDpto);
		txtCodigoDpto.setColumns(10);
		
		lblNombreDpto = new JLabel("Nombre de departamento");
		lblNombreDpto.setBounds(297, 250, 152, 20);
		add(lblNombreDpto);
		
		txtNombreDpto = new JTextField();
		txtNombreDpto.setBounds(532, 250, 152, 20);
		add(txtNombreDpto);
		txtNombreDpto.setColumns(10);
		
		lblCentro = new JLabel("Centro");
		lblCentro.setBounds(297, 281, 152, 20);
		add(lblCentro);
		
		modeloCmbCentro=new DefaultComboBoxModel<Centro>();
		
		cmbCentro = new JComboBox<Centro>(modeloCmbCentro);
		cmbCentro.setBounds(532, 281, 152, 20);
		add(cmbCentro);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(532, 312, 152, 23);
		add(btnRegistrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(54, 516, 89, 23);
		add(btnVolver);
	}
}
