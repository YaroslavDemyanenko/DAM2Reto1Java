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
		String json;
		if (mod.mPEmple.validarDNI(campoTexto, false)) {
			json = mod.bd.consultarToGson("select `idDni` 'dni',`nombre` 'nombre',`apellidos` 'apellidos',`sueldo` 'sueldo',`esJefe` 'esJefe', `fechaAlta` 'fechaString' from `empleado` where `idDni`='" + campoTexto + "'");
		} else {
			if (campoTexto.contains(" ")) {
				json = mod.bd.consultarToGson("select `idDni` 'dni',`nombre` 'nombre',`apellidos` 'apellidos',`sueldo` 'sueldo',`esJefe` 'esJefe', `fechaAlta` 'fechaString' from `empleado` where upper(`nombre`)=upper('" + campoTexto.split(" ")[0] + "') and upper(`apellidos`)=upper('" + campoTexto.split(" ")[1] + "')");
			} else {
				json = mod.bd.consultarToGson("select `idDni` 'dni',`nombre` 'nombre',`apellidos` 'apellidos',`sueldo` 'sueldo',`esJefe` 'esJefe', `fechaAlta` 'fechaString' from `empleado` where upper(`nombre`)=upper('" + campoTexto + "')");
			}
		}
		if (!json.equals("")) {
			empleado = gson.fromJson(json, Empleado[].class);
			empleado[0].cargarDatosComplementarios(bd, gson);
			return empleado[0];
		} else {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado", null, JOptionPane.WARNING_MESSAGE);
			return null;
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
