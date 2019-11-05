package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelMenuEmple extends JPanel {

	private static final long serialVersionUID = 2656417989723357437L;
	public JLabel lblTitulo;
	public JButton btnIngresarEmple, btnVolver, btnBuscar;
	public JList<String> listDatosEmple;
	public DefaultListModel<String> modeloListDatosEmple;
	public JLabel lblBuscarEmple;
	public JTextField txtBuscarEmple;
	
	public PanelMenuEmple() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setBorder(null);
		setPreferredSize(new Dimension(1024, 768));
		setLayout(null);
	}
	
	private void instanciarObjetos() {
		lblTitulo = new JLabel("MEN\u00DA GESTI\u00D3N EMPLEADO");
		lblTitulo.setBounds(10, 11, 1004, 77);
		add(lblTitulo);
		
		btnIngresarEmple = new JButton("INGRESAR NUEVO EMPLEADO");
		btnIngresarEmple.setBounds(393, 156, 226, 23);
		add(btnIngresarEmple);
		
		lblBuscarEmple = new JLabel("BUSCAR EMPLEADO");
		lblBuscarEmple.setBounds(393, 240, 226, 23);
		add(lblBuscarEmple);
		
		txtBuscarEmple = new JTextField();
		//txtBuscarEmple.setText("Ingresar nombre o ID");
		txtBuscarEmple.setToolTipText("Ingresar nombre o ID");
		txtBuscarEmple.setColumns(10);
		txtBuscarEmple.setBounds(393, 276, 226, 20);
		add(txtBuscarEmple);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(509, 318, 110, 23);
		add(btnBuscar);
		
		modeloListDatosEmple = new DefaultListModel<String>();
		
		listDatosEmple = new JList<String>(modeloListDatosEmple);
		listDatosEmple.setBackground(Color.LIGHT_GRAY);
		listDatosEmple.setBounds(320, 357, 398, 150);
		add(listDatosEmple);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(54, 516, 89, 23);
		add(btnVolver);
	}
}