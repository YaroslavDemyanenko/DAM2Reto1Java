package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import launcher.Launcher;
import logs.Logger;
import modelo.Modelo;
import modelo.objetos.Centro;
import modelo.objetos.Departamento;
import vista.VentanaPpal;

public class ControladorPanelDpto {

	private VentanaPpal vis;
	private Modelo mod;
	@SuppressWarnings("unused")
	private Controlador controlador;

	public ControladorPanelDpto(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;

		mostrarListaCentros();
		initListeners();
	}

	private void initListeners() {
		vis.pCenter.pDpto.btnVolver.addActionListener(new ListenerBotones());
		vis.pCenter.pDpto.btnRegistrar.addActionListener(new ListenerBotones());
	}

	private class ListenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			switch (accion) {
			case "Volver":
				vis.pCenter.changePanel("2");
				break;
			case "Registrar":
				boolean repetido = insertarDepartamento();
				if (repetido) {
					vis.pCenter.changePanel("2");
				}
				resetText();
				break;
			}
		}
	}

	private void mostrarListaCentros() {
		vis.pCenter.pDpto.cmbCentro.removeAllItems();
		Centro[] listaCentro = mod.mPDpto.buscarCentros();
		if (listaCentro != null) {
			for (int i = 0; i < listaCentro.length; i++) {
				vis.pCenter.pDpto.cmbCentro.addItem(listaCentro[i]);
			}
		} else {
			JOptionPane.showMessageDialog(vis, "Error en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
			vis.dispose();
		}
	}

	private boolean insertarDepartamento() {
		int codDpto = 0;
		try {
			codDpto = Integer.parseInt(vis.pCenter.pDpto.txtCodigoDpto.getText());
		}catch(NumberFormatException e) {
			Logger.getInstance().loggear("Error al obtener el código de departamento",Launcher.class, 3);
		}
		String nombre = vis.pCenter.pDpto.txtNombreDpto.getText();
		Centro codCentro = (Centro) vis.pCenter.pDpto.cmbCentro.getSelectedItem();

		if (codDpto != 0 && !nombre.equals(null)) {
			Departamento depart = new Departamento(codDpto, nombre, codCentro);
			boolean repetido = mod.mPDpto.insertarDptoNuevo(depart);
			if (!repetido) {
				JOptionPane.showMessageDialog(vis.pCenter, "Departamento insertado", "Atencion!", JOptionPane.WARNING_MESSAGE);
				return true;
			} else {
				JOptionPane.showMessageDialog(vis.pCenter, "Departamento ya existente", "Atencion!", JOptionPane.WARNING_MESSAGE);
			}
		} else {

			JOptionPane.showMessageDialog(vis.pCenter, "Debe rellenar los campos", "Atencion!", JOptionPane.WARNING_MESSAGE);
		}
		return false;

	}

	private void resetText() {
		vis.pCenter.pDpto.txtCodigoDpto.setText("");
		vis.pCenter.pDpto.txtNombreDpto.setText("");
		vis.pCenter.pDpto.cmbCentro.setSelectedItem(1);
	}
}
