package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import com.google.gson.Gson;

import modelo.Modelo;
import modelo.objetos.Cargo;
import modelo.objetos.Centro;
import modelo.objetos.Departamento;
import modelo.objetos.Empleado;
import modelo.objetos.Global;
import vista.VentanaPpal;

public class ControladorPanelEmple {

	private VentanaPpal vis;
	private Controlador controlador;
	private Modelo mod;

	private Gson gson = new Gson();

	public ControladorPanelEmple(VentanaPpal vis, Controlador controlador, Modelo mod) {
		super();
		this.vis = vis;
		this.controlador = controlador;
		this.mod = mod;

		initListeners();
	}

	private void initListeners() {
		
	}

	public void cargarInterfaz() {
		Departamento[] departamentos = mod.mPEmple.cargarDepartamentos();
		for (Departamento dpto : departamentos) {
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
	
	
	private Empleado crearEmpleado() {
		String dni = vis.pCenter.pEmple.txtCodEmple.getText();
		String nombre = vis.pCenter.pEmple.txtNomEmple.getText();
		String apellidos = vis.pCenter.pEmple.txtApellidos.getText();
		int salario = Integer.valueOf(vis.pCenter.pEmple.txtSalario.getText());
		Departamento depart = vis.pCenter.pEmple.modeloDpto.getElementAt(vis.pCenter.pEmple.cmbDpto.getSelectedIndex());
		Cargo cargo = vis.pCenter.pEmple.modeloCargo.getElementAt(vis.pCenter.pEmple.cmbCargo.getSelectedIndex());
		Empleado superior = vis.pCenter.pEmple.modeloSelJefe.getElementAt(vis.pCenter.pEmple.cmbSelJefe.getSelectedIndex());

		boolean esJefe;
		if (vis.pCenter.pEmple.chbEsJefe.isSelected())
			esJefe = true;
		else
			esJefe = false;
		return new Empleado(dni, nombre, apellidos, salario, esJefe, new Date(), cargo, depart);
	}
	
	private class ListenerBotonRegistro implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	}
	
}
