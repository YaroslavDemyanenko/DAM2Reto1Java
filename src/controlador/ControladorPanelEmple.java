package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import com.google.gson.Gson;
import modelo.Modelo;
import modelo.objetos.Cargo;
import modelo.objetos.Departamento;
import modelo.objetos.Empleado;
import vista.VentanaPpal;

public class ControladorPanelEmple {

	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;
	private Gson gson = new Gson();
	
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
				break;
				
			case "Registrar":
				if(validarDatos()) {
					mod.bd.insertGenerico(crearEmpleado().toObjectArray(), "empleado");
				}				
				vis.pCenter.changePanel("4");
				break;
			}
		}
	}	
	
	private Empleado crearEmpleado() {
		String dni = vis.pCenter.pEmple.txtCodEmple.getText();
		String nombre = vis.pCenter.pEmple.txtNomEmple.getText();
		String apellidos = vis.pCenter.pEmple.txtApellidos.getText();
		int salario = Integer.valueOf(vis.pCenter.pEmple.txtSalario.getText());
		Departamento depart = (Departamento) vis.pCenter.pEmple.modeloDpto.getSelectedItem();
		Cargo cargo = (Cargo) vis.pCenter.pEmple.modeloCargo.getSelectedItem();
		Empleado superior = (Empleado) vis.pCenter.pEmple.modeloSelJefe.getSelectedItem();

		int esJefe;
		if (vis.pCenter.pEmple.chbEsJefe.isSelected())
			esJefe = 1;
		else
			esJefe = 0;
		return new Empleado(dni, nombre, apellidos, salario, esJefe, new Date(), cargo, depart,superior);
	}
	
	public void limpiarPanel() {
		vis.pCenter.pEmple.txtCodEmple.setText("");
		vis.pCenter.pEmple.txtApellidos.setText("");
		vis.pCenter.pEmple.txtNomEmple.setText("");
		vis.pCenter.pEmple.txtSalario.setText("");
		
		vis.pCenter.pEmple.modeloCargo.removeAllElements();
		vis.pCenter.pEmple.modeloDpto.removeAllElements();
		vis.pCenter.pEmple.modeloSelJefe.removeAllElements();
	}
	
	public boolean validarDatos() {
		for(boolean validacion:validarCampos()) {
			if (validacion=false) {
				return false;
			}
		}
		return true;
	}
	
	private boolean[] validarCampos() {
		boolean[] validaciones = {false,false,false,false,false};
		validaciones[0] = mod.mPEmple.validarDNI(vis.pCenter.pEmple.txtCodEmple.getText());
		validaciones[1] = mod.mPEmple.validarSoloLetras(vis.pCenter.pEmple.txtNomEmple.getText(), "Nombre");
		validaciones[2] = mod.mPEmple.validarSoloLetras(vis.pCenter.pEmple.txtApellidos.getText(), "Apellidos");
		validaciones[3] = mod.mPEmple.validarSoloNumeros(vis.pCenter.pEmple.txtSalario.getText(), "Salario");
		validaciones[4] = mod.mPEmple.validarRegistroPrevio(vis.pCenter.pEmple.txtCodEmple.getText());
		return validaciones;
	}
}
