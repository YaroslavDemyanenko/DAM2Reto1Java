package vista;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMenu extends JPanel {
	private static final long serialVersionUID = -132735883135705085L;
	public JLabel lblTitulo, lblGenInforme;
	public JButton btnGestionDpto, btnGestionEmple, btnGenPdf, btnGenTxt;
	private JLabel lblInformeDebeSer;
	
	public PanelMenu() {		
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setBorder(null);
		setPreferredSize(new Dimension(1024,768));
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
		
		lblGenInforme = new JLabel("GENERAR INFORME");
		lblGenInforme.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenInforme.setBounds(411, 263, 200, 50);
		add(lblGenInforme);
		
		btnGenPdf = new JButton("GENERAR PDF");
		btnGenPdf.setBounds(411, 311, 110, 23);
		add(btnGenPdf);
		
		btnGenTxt = new JButton("GENERAR TXT");
		btnGenTxt.setBounds(531, 311, 110, 23);
		add(btnGenTxt);
		
		lblInformeDebeSer = new JLabel("INFORME DEBE SER: DEPARTAMENTOS O EMPLEADOS!!!!!");
		lblInformeDebeSer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformeDebeSer.setBounds(288, 353, 514, 92);
		add(lblInformeDebeSer);		
	}
}
