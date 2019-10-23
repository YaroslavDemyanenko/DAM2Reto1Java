package vista;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class PanelMenuEmple extends JPanel {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7408961551255605320L;
	
	public JLabel lblTitulo;
	public JButton btnIngresarEmple, btnVolver;
	public JList listDatosEmple;
	private JLabel lblBuscarEmple;
	private JTextField txtBuscarEmple;
	
	/**
	 * Create the panel.
	 */
	
	public PanelMenuEmple() {
		setBorder(new CompoundBorder(null, new EmptyBorder(0, 5, 0, 0)));
		setParametros();
		
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(1024, 588));
	}
	
	private void instanciarObjetos() {
		setLayout(null);
		
		lblTitulo = new JLabel("MEN\u00DA GESTI\u00D3N EMPLEADO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 1004, 77);
		add(lblTitulo);
		
		btnIngresarEmple = new JButton("INGRESAR NUEVO EMPLEADO");
		btnIngresarEmple.setBounds(393, 156, 226, 23);
		add(btnIngresarEmple);
		
		lblBuscarEmple = new JLabel("BUSCAR EMPLEADO");
		lblBuscarEmple.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarEmple.setBounds(393, 281, 226, 23);
		add(lblBuscarEmple);
		
		txtBuscarEmple = new JTextField();
		txtBuscarEmple.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscarEmple.setText("Ingresar nombre o ID");
		txtBuscarEmple.setColumns(10);
		txtBuscarEmple.setBounds(393, 315, 226, 20);
		add(txtBuscarEmple);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(509, 346, 110, 23);
		add(btnBuscar);
		
		listDatosEmple = new JList();
		listDatosEmple.setBorder(new LineBorder(new Color(0, 0, 0)));
		listDatosEmple.setBackground(Color.LIGHT_GRAY);
		listDatosEmple.setBounds(320, 532, 398, -150);
		add(listDatosEmple);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(54, 516, 89, 23);
		add(btnVolver);
	}
}