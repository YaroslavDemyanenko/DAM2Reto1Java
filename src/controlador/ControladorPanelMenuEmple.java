package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.ComboBox;
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
		vis.pCenter.pMenuEmple.cmbEmpleados.addItemListener(new listenerCambioIndex());
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
				limpiarPanelRegistroEmpleado();
				cargarInterfazRegistroEmpleado();
				vis.pCenter.changePanel("5");
				break;

			case "Buscar":
				buscarEmpleado(vis.pCenter.pMenuEmple.txtBuscarEmple.getText());
				break;
			}
		}
	}
	
	private class listenerCambioIndex implements ItemListener{

		@Override
	    public void itemStateChanged(ItemEvent event) {
	       if (event.getStateChange() == ItemEvent.SELECTED) {
	          llenarListaConInformacion((Empleado) vis.pCenter.pMenuEmple.modeloCmbEmpleados.getSelectedItem());	          
	       }
	    } 
		
	}
	
	public void limpiarPanelRegistroEmpleado() {
		vis.pCenter.pEmple.txtCodEmple.setText("");
		vis.pCenter.pEmple.txtApellidos.setText("");
		vis.pCenter.pEmple.txtNomEmple.setText("");
		vis.pCenter.pEmple.txtSalario.setText("");
		
		vis.pCenter.pEmple.modeloCargo.removeAllElements();
		vis.pCenter.pEmple.modeloDpto.removeAllElements();
		vis.pCenter.pEmple.modeloSelJefe.removeAllElements();
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
		Empleado[] empleados = mod.mPMEmple.buscarPorNombreODni(nombre);
		if (empleados != null) {
			for (Empleado emple:empleados) {
				llenarListaConInformacion(emple);
			}
			meterEmpleadosEnComboBox(empleados);
			llenarListaConInformacion(empleados[0]);
		}
	}

	public void meterEmpleadosEnComboBox(Empleado[] empleados) {
		vis.pCenter.pMenuEmple.modeloCmbEmpleados.removeAllElements();
		for (Empleado emple:empleados) {
			vis.pCenter.pMenuEmple.modeloCmbEmpleados.addElement(emple);
		}	
	}


	private void llenarListaConInformacion(Empleado emple) {
		vis.pCenter.pMenuEmple.modeloListDatosEmple.removeAllElements();
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("DNI: " + emple.getDni());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Nombre: " + emple.getNombre());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Apellido: " + emple.getApellidos());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Salario: " + emple.getSueldo());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Departamento: " + emple.getDepartamento().getNombre());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Cargo: " + emple.getCargo().getNombre());
		vis.pCenter.pMenuEmple.modeloListDatosEmple.addElement("Superior: " + emple.getEmpleJefe().getNombre() + " | "+emple.getEmpleJefe().getDni());
	}
}
