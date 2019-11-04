package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import modelo.objetos.Departamento;
import vista.*;

public class ControladorPanelMenu {

	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;
	
	public ControladorPanelMenu(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		
		initListeners();
	}
	
	private void initListeners() {
		//public JButton btnGestionDpto, btnGestionEmple, btnGenPdf, btnGenTxt;
		vis.pCenter.pMenuPrincipal.btnGestionDpto.addActionListener(new ListenerBotones());
		vis.pCenter.pMenuPrincipal.btnGestionEmple.addActionListener(new ListenerBotones());
		vis.pCenter.pMenuPrincipal.btnGenPdf.addActionListener(new ListenerBotones());
		vis.pCenter.pMenuPrincipal.btnGenTxt.addActionListener(new ListenerBotones());
	}
	
	private class ListenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			
			switch (accion) {
			
			case "GESTIONAR DEPARTAMENTOS":
				mostrarListaDptos();
				vis.pCenter.changePanel("2");
				break;
				
			case "GESTION DE EMPLEADOS":
				vis.pCenter.changePanel("4");
				break;
				
//			case "GENERAR PDF":
//				//metodo generarPDF()
//				vis.pCenter.changePanel("");
//				
//			case "GENERAR TXT":
//				//metodo generarTXT()
//				vis.pCenter.changePanel("");
				
			}
			
		}
		
	}
	
	public void mostrarListaDptos() {
		vis.pCenter.pMenuDpto.lblNombreDpto.setText("");
		
		if(mod.departamentos != null) {
			vis.pCenter.pMenuDpto.lblNombreDpto.setText(mod.departamentos[0].getNombre());
		}else {
			JOptionPane.showMessageDialog(vis, "Error en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
			vis.dispose();
		}	
	}	
}
