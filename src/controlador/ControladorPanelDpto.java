package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import baseDatos.ConsultaBD;
import modelo.Modelo;
import modelo.metodos.MetodosPanelEmple;
import modelo.objetos.Centro;
import vista.VentanaPpal;

public class ControladorPanelDpto {

	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;
	
	public ControladorPanelDpto(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		
		mostrarListaCentros();
		initListeners();
	}
	
	private void initListeners() {
		//public JButton btnGestionDpto, btnGestionEmple, btnGenPdf, btnGenTxt;
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
				//Metodo registrar()
				vis.pCenter.changePanel("2");
				break;				
			}
		}
	}
	
	public void mostrarListaCentros() {
		vis.pCenter.pDpto.cmbCentro.removeAllItems();
		Centro[] listaCentro = mod.mPDpto.buscarCentros();
		if (listaCentro != null) {
			for(int i = 0; i < listaCentro.length; i++) {
				vis.pCenter.pDpto.cmbCentro.addItem(listaCentro[i].getNombre());
			}
		} else {
			JOptionPane.showMessageDialog(vis, "Error en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
			vis.dispose();
		}
		
	}
	
}
