package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMenu extends JPanel {
	private static final long serialVersionUID = 2384139865371691563L;
	
	public JLabel lblTitulo;
	public JButton btnGestionDpto, btnGestionEmple, btnGenInforme;
	
	public PanelMenu() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		//setPreferredSize(new Dimension(1024, 588));
		setLayout(null);
	}
	
	private void instanciarObjetos() {
		lblTitulo = new JLabel("BIENVENIDA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 1004, 77);
		add(lblTitulo);
		
		btnGestionDpto = new JButton("GESTIONAR DEPARTAMENTOS");
		btnGestionDpto.setBounds(411, 165, 201, 23);
		add(btnGestionDpto);
		
		btnGestionEmple = new JButton("GESTION DE EMPLEADOS");
		btnGestionEmple.setBounds(411, 229, 201, 23);
		add(btnGestionEmple);
		
		btnGenInforme = new JButton("GENERAR INFORME");
		btnGenInforme.setBounds(411, 302, 201, 23);
		add(btnGenInforme);
	}

}
