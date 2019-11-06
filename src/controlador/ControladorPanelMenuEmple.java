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
	@SuppressWarnings("unused")
	private Controlador controlador;

	public ControladorPanelMenuEmple(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;

		initListeners();
	}

	private void initListeners() {
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
				buscarEmpleado(vis.pCenter.pMenuEmple.txtBuscarEmple.getText());
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

	public void buscarEmpleado(String nombre) {
		Empleado emple = mod.mPMEmple.buscarPorNombreODni(nombre);
		if (emple != null) {
			llenarListaConInformacion(emple);
		}

	}

	private void llenarListaConInformacion(Empleado emple) {
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("DNI: " + emple.getDni());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Nombre: " + emple.getNombre());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Apellido: " + emple.getApellidos());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Salario: " + emple.getSueldo());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Departamento: " + emple.getDepartamento().getNombre());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Cargo: " + emple.getCargo().getNombre());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Superior: " + emple.getEmpleJefe().getNombre() + " | "+emple.getEmpleJefe().getDni());
	}
}
