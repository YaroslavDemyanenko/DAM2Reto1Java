package modelo.metodos;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import baseDatos.ConsultaBD;
import modelo.Modelo;
import modelo.objetos.Empleado;

public class MetodosPanelMenuEmple {
	private ConsultaBD bd;
	private Modelo mod;

	private Gson gson = new Gson();
	
	
	

	public Empleado buscarPorNombreODni(String campoTexto) {
		Empleado[] empleado;
		if(mod.mPEmple.validarDNI(campoTexto)) {
			String json = mod.bd.consultarToGson("select `idDni` 'dni' from `empleado` where `idDni`='"+campoTexto+"'");
			empleado = gson.fromJson(json, Empleado[].class);
		}else {
			String json = mod.bd.consultarToGson("select `nombre` 'nombre' from `empleado` where `nombre`='"+campoTexto+"'");
			empleado = gson.fromJson(json, Empleado[].class);
		}
		
		if(empleado == null) {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado", null, JOptionPane.WARNING_MESSAGE);
			return null;
		}else {
			return empleado[0];
		}
	}
	
	
	public MetodosPanelMenuEmple(Modelo mod, ConsultaBD bd) {
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
}
