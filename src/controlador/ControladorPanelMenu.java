package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Modelo;
import vista.VentanaPpal;

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
				mod.mPMenu.mostrarListaDptos(0, vis);
				mod.mPMenu.mostrarListaEmpleadosXDpto(0, vis);
				vis.pCenter.changePanel("2");
				break;
				
			case "GESTION DE EMPLEADOS":
				vis.pCenter.changePanel("4");
				break;
				
  			case "GENERAR PDF":
  				//metodo generarPDF()
  				String[] opcionPDF = {"Empleados","Departamentos"};
  				String respuesta = (String) JOptionPane.showInputDialog(null, "Seleccione archivo a generar", "Archivos", JOptionPane.DEFAULT_OPTION, null, opcionPDF, opcionPDF[0]);
  				
  				switch(respuesta) {
  					case "Empleados":
  						break;
  					case "Departamentos":
  						break;
  				}
//				vis.pCenter.changePanel("");
  				break;
//			case "GENERAR TXT":
//				//metodo generarTXT()
//				vis.pCenter.changePanel("");
				
			}
			
		}
		
	}	
}
