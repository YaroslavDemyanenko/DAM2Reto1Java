package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.PanelDpto;
import vista.VentanaPpal;

public class ControladotPanelMenuDpto {
	private VentanaPpal vis;
	private Modelo mod;
	@SuppressWarnings("unused")
	private Controlador controlador;
	
	public ControladotPanelMenuDpto(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		
		initListeners();
	}
	
	private void initListeners() {
		ListenerBotones listener=new ListenerBotones();
		vis.pCenter.pMenuDpto.btnVolver.addActionListener(listener);
		vis.pCenter.pMenuDpto.btnIngresarDpto.addActionListener(listener);
		vis.pCenter.pMenuDpto.btnSiguiente.addActionListener(listener);
		vis.pCenter.pMenuDpto.btnUltimo.addActionListener(listener);
		vis.pCenter.pMenuDpto.btnAnterior.addActionListener(listener);
		vis.pCenter.pMenuDpto.btnPrimero.addActionListener(listener);
	}
	
	private class ListenerBotones implements ActionListener {
		
		private int posicion = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			
			switch (accion) {			
			case "Volver":
				vis.pCenter.changePanel("1");
				break;
				
			case "INGRESAR NUEVO DEPARTAMENTO":
				limpiarPanelDpto(vis.pCenter.pDpto);
				vis.pCenter.pDpto.txtCodigoDpto.setText(Integer.toString(mod.mPMDpto.numeroPropuestoDpto()+1));
				vis.pCenter.changePanel("3");
				break;				
			case "Siguiente":
				if(posicion < mod.departamentos.length-1) {
					posicion++;
				}
				vis.pCenter.pMenuDpto.modeloListaEmple.removeAllElements();	
				mod.mPMenu.mostrarListaDptos(posicion, vis);
				mod.mPMenu.mostrarListaEmpleadosXDpto(mod.departamentos[posicion].getId(),mod.departamentos[posicion].getCentro().getId(), vis);
				break;
				
			case "Ultimo":
				posicion = mod.departamentos.length-1;
				vis.pCenter.pMenuDpto.modeloListaEmple.removeAllElements();	
				mod.mPMenu.mostrarListaDptos(posicion, vis);
				mod.mPMenu.mostrarListaEmpleadosXDpto(mod.departamentos[posicion].getId(),mod.departamentos[posicion].getCentro().getId(), vis);
				break;
				
			case "Anterior":
				if(posicion > 0) {
					posicion--;
				}
				vis.pCenter.pMenuDpto.modeloListaEmple.removeAllElements();	
				mod.mPMenu.mostrarListaDptos(posicion, vis);
				mod.mPMenu.mostrarListaEmpleadosXDpto(mod.departamentos[posicion].getId(),mod.departamentos[posicion].getCentro().getId(), vis);
				break;
				
			case "Primero":				
				posicion=0;
				vis.pCenter.pMenuDpto.modeloListaEmple.removeAllElements();	
				mod.mPMenu.mostrarListaDptos(posicion, vis);
				mod.mPMenu.mostrarListaEmpleadosXDpto(mod.departamentos[posicion].getId(),mod.departamentos[posicion].getCentro().getId(), vis);
				break;
			}
		}
	}
	
	public void limpiarPanelDpto(PanelDpto panel) {
		panel.txtNombreDpto.setText("");
	}
}
