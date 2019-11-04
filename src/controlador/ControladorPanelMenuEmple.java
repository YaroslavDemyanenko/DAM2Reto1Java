package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import modelo.objetos.Cargo;
import modelo.objetos.Departamento;
import modelo.objetos.Empleado;
import vista.VentanaPpal;

public class ControladorPanelMenuEmple {
	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;
	
	public ControladorPanelMenuEmple(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		
		initListeners();
	}
	
	private void initListeners() {
		//public JButton btnGestionDpto, btnGestionEmple, btnGenPdf, btnGenTxt;
		vis.pCenter.pMenuEmple.btnVolver.addActionListener(new ListenerBotones());
		vis.pCenter.pMenuEmple.btnIngresarEmple.addActionListener(new ListenerBotones());
		vis.pCenter.pMenuEmple.btnBuscar.addActionListener(new ListenerBotones());
	}
	
	
	private class ListenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			
			switch (accion) {
			
			case "Volver":
				vis.pCenter.changePanel("1");
				break;
				
			case "INGRESAR NUEVO EMPLEADO":
				cargarInterfazRegistroEmpleado();
				vis.pCenter.changePanel("5");
				break;
				
			case "Buscar":
				//Metodo mostrar siguiente empleado
				vis.pCenter.changePanel("4");
				break;
				
			}
		}
	}
	
	
	public void cargarInterfazRegistroEmpleado() {
		for (Departamento dpto : mod.departamentos) {
			vis.pCenter.pEmple.modeloDpto.addElement(dpto);
		}
		Cargo[] cargos = mod.mPEmple.cargarCargos();
		for (Cargo cargo : cargos) {
			vis.pCenter.pEmple.modeloCargo.addElement(cargo);
		}
		
		Empleado[] jefes = mod.mPEmple.cargarJefes();
		for (Empleado jefe : jefes) {
			vis.pCenter.pEmple.modeloSelJefe.addElement(jefe);
		}				
	}
}
