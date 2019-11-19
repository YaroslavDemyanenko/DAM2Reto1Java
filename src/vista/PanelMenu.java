package vista;

import java.awt.Color;
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
	private Dimension arcs = new Dimension(20, 20);

	public PanelMenu() {
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
		lblTitulo = new JLabel("CENTER MANAGER");
		lblTitulo.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 36));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(290, 119, 420, 77);
		lblTitulo.setForeground(Color.WHITE);
		add(lblTitulo);

		btnGestionDpto = new JButton("GESTIONAR DEPARTAMENTOS");
		btnGestionDpto.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnGestionDpto.setBounds(317, 276, 365, 38);
		btnGestionDpto.setBackground(new Color(1, 35, 80));
		btnGestionDpto.setForeground(Color.WHITE);
		add(btnGestionDpto);

		btnGestionEmple = new JButton("GESTION DE EMPLEADOS");
		btnGestionEmple.setFont(new Font("Perpetua", Font.PLAIN, 20));
		btnGestionEmple.setBounds(317, 364, 365, 38);
		btnGestionEmple.setBackground(new Color(1, 35, 80));
		btnGestionEmple.setForeground(Color.WHITE);
		add(btnGestionEmple);

		lblGenInforme = new JLabel("GENERAR INFORME");
		lblGenInforme.setFont(new Font("Perpetua", Font.PLAIN, 18));
		lblGenInforme.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenInforme.setBounds(400, 437, 200, 50);
		lblGenInforme.setForeground(Color.WHITE);
		add(lblGenInforme);

		btnGenPdf = new JButton("GENERAR PDF");
		btnGenPdf.setFont(new Font("Perpetua", Font.PLAIN, 15));
		btnGenPdf.setBounds(317, 505, 365, 38);
		btnGenPdf.setBackground(new Color(1, 35, 80));
		btnGenPdf.setForeground(Color.WHITE);
		add(btnGenPdf);

		btnGenTxt = new JButton("GENERAR TXT");
		btnGenTxt.setVisible(false);
		btnGenTxt.setFont(new Font("Perpetua", Font.PLAIN, 15));
		btnGenTxt.setBounds(535, 505, 130, 38);
		btnGenTxt.setBackground(new Color(1, 35, 80));
		btnGenTxt.setForeground(Color.WHITE);
		add(btnGenTxt);

		btnGenPdf.setFocusPainted(false);
		btnGenTxt.setFocusPainted(false);
		btnGestionDpto.setFocusPainted(false);
		btnGestionEmple.setFocusPainted(false);
	}
}
