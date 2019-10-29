package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
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
				vis.pCenter.changePanel("3");
				
			case "GESTION DE EMPLEADOS":
				vis.pCenter.changePanel("4");
				
//			case "GENERAR PDF":
//				vis.pCenter.changePanel("");
//				
//			case "GENERAR TXT":
//				vis.pCenter.changePanel("");
				
			}
			
		}
		
	}
	
}
