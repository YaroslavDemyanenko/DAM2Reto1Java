package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorPanelEmple {

	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;
	
	public ControladorPanelEmple(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		
		initListeners();
	}
	
	private void initListeners() {
		//public JButton btnGestionDpto, btnGestionEmple, btnGenPdf, btnGenTxt;
		vis.pCenter.pEmple.btnVolver.addActionListener(new ListenerBotones());
		vis.pCenter.pEmple.btnRegistrar.addActionListener(new ListenerBotones());
	}
	
	private class ListenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			
			switch (accion) {
			
			case "Volver":
				vis.pCenter.changePanel("1");
				
			case "Registrar":
				//Metodo registrar()
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
