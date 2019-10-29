package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.VentanaPpal;

public class ControladotPanelMenuDpto {
	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;
	
	public ControladotPanelMenuDpto(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		
		initListeners();
	}
	
	private void initListeners() {
		//public JButton btnGestionDpto, btnGestionEmple, btnGenPdf, btnGenTxt;
		vis.pCenter.pMenuDpto.btnVolver.addActionListener(new ListenerBotones());
		vis.pCenter.pMenuDpto.btnIngresarDpto.addActionListener(new ListenerBotones());
		vis.pCenter.pMenuDpto.btnSiguiente.addActionListener(new ListenerBotones());
		vis.pCenter.pMenuDpto.btnUltimo.addActionListener(new ListenerBotones());
		vis.pCenter.pMenuDpto.btnAnterior.addActionListener(new ListenerBotones());
		vis.pCenter.pMenuDpto.btnPrimero.addActionListener(new ListenerBotones());
	}
	
	private class ListenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			
			switch (accion) {
			
			case "Volver":
				vis.pCenter.changePanel("1");
				break;
				
			case "INGRESAR NUEVO DEPARTAMENTO":
				vis.pCenter.changePanel("3");
				break;
				
			case "Siguiente":
				//Metodo mostrar siguiente empleado
				vis.pCenter.changePanel("2");
				break;
				
			case "Ultimo":
				//Metodo mostrar siguiente empleado
				vis.pCenter.changePanel("2");
				break;
				
			case "Anterior":
				//Metodo mostrar siguiente empleado
				vis.pCenter.changePanel("2");
				break;
				
			case "Primero":
				//Metodo mostrar siguiente empleado
				vis.pCenter.changePanel("2");
				break;
				
			}
		}
	}
}
