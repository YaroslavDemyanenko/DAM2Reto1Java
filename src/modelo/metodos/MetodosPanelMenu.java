package modelo.metodos;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import baseDatos.ConsultaBD;
import modelo.Modelo;
import modelo.objetos.Empleado;
import vista.VentanaPpal;

public class MetodosPanelMenu {
	private ConsultaBD bd;
	private Modelo mod;
	private Gson gson = new Gson();
	
	public MetodosPanelMenu(Modelo mod, ConsultaBD bd) {
		this.bd = bd;
		this.mod = mod;
	}
	
	public ConsultaBD getBd() {
		return bd;
	}

	public void setBd(ConsultaBD bd) {
		this.bd = bd;
	}

	public Modelo getMod() {
		return mod;
	}

	public void setMod(Modelo mod) {
		this.mod = mod;
	}
	
	public void mostrarListaDptos(int posicion,VentanaPpal vis) {		
		if(mod.departamentos != null) {
			if(posicion < mod.departamentos.length && posicion >= 0) {
				vis.pCenter.pMenuDpto.lblNombreDpto.setText(mod.departamentos[posicion].getNombre());
			}
		}else {
			JOptionPane.showMessageDialog(vis, "Error en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
			vis.dispose();
		}	
	}
	
	public void mostrarListaEmpleadosXDpto(int idDepartamento, VentanaPpal vis) {
		Empleado[] empleados = mod.mPEmple.cargarEmpleados(idDepartamento);
		vis.pCenter.pMenuDpto.modeloListaEmple.removeAllElements();		
		if(empleados != null) {
			for(int i=0; i<empleados.length; i++) {
				vis.pCenter.pMenuDpto.modeloListaEmple.addElement(empleados[i]);
			}
		}
	}
}
