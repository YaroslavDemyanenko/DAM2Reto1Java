package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.objetos.Centro;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

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
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTitulo.setBounds(233, 45, 533, 77);
		add(lblTitulo);
		
		lblCodigoDpto = new JLabel("C\u00F3digo de departamento");
		lblCodigoDpto.setForeground(Color.WHITE);
		lblCodigoDpto.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblCodigoDpto.setBounds(233, 223, 212, 20);
		add(lblCodigoDpto);
		
		txtCodigoDpto = new JTextField();
		txtCodigoDpto.setForeground(Color.WHITE);
		txtCodigoDpto.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtCodigoDpto.setBounds(532, 219, 268, 30);
		add(txtCodigoDpto);
		txtCodigoDpto.setColumns(10);
		
		lblNombreDpto = new JLabel("Nombre de departamento");
		lblNombreDpto.setForeground(Color.WHITE);
		lblNombreDpto.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNombreDpto.setBounds(233, 254, 212, 20);
		add(lblNombreDpto);
		
		txtNombreDpto = new JTextField();
		txtNombreDpto.setForeground(Color.WHITE);
		txtNombreDpto.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtNombreDpto.setBounds(532, 250, 268, 30);
		add(txtNombreDpto);
		txtNombreDpto.setColumns(10);
		
		lblCentro = new JLabel("Centro");
		lblCentro.setForeground(Color.WHITE);
		lblCentro.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblCentro.setBounds(233, 283, 212, 20);
		add(lblCentro);
		
		modeloCmbCentro=new DefaultComboBoxModel<Centro>();
		
		cmbCentro = new JComboBox<Centro>(modeloCmbCentro);
		cmbCentro.setBounds(532, 281, 268, 30);
		add(cmbCentro);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(532, 362, 268, 30);
		add(btnRegistrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnVolver.setBounds(46, 667, 130, 38);
		btnVolver.setBackground(new Color(1,35,80));
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFocusPainted(false);
		add(btnVolver);
		
		
		cmbCentro.setBackground(new Color(1, 35, 80));
		cmbCentro.setForeground(Color.WHITE);
		cmbCentro.setUI(new BasicComboBoxUI());
		cmbCentro.setBorder(new LineBorder(new Color(1, 35, 80)));
		cmbCentro.setFocusable(false);
	}
}
