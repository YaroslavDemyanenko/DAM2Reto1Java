package vista;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelDpto extends JPanel {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 7014951804218329907L;
	
	/**
	 * Create the panel.
	 */
	
	public JTextField txtCodigoDpto, txtNombreDpto;
	public JLabel lblTitulo, lblCodigoDpto, lblNombreDpto, lblCentro;
	public JButton btnVolver, btnRegistrar;
	public JComboBox cmbCentro;
	
	public PanelDpto() {
		
		setBorder(new CompoundBorder(null, new EmptyBorder(0, 5, 0, 0)));
		setParametros();
	}
	
	private void setParametros() {
		
		setPreferredSize(new Dimension(1024, 588));
		
	}
	
	private void instanciarObjetos() {
		setLayout(null);
		
		lblTitulo = new JLabel("INGRESO DE DEPARTAMENTO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		cmbCentro = new JComboBox();
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
