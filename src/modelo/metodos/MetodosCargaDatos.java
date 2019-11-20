package modelo.metodos;

import com.google.gson.Gson;
import baseDatos.ConsultaBD;
import logs.Logger;
import modelo.Modelo;
import modelo.objetos.Cargo;
import modelo.objetos.Centro;
import modelo.objetos.Departamento;
import modelo.objetos.Empleado;

public class MetodosCargaDatos {
	
	private ConsultaBD bd;
	private Modelo mod;
	private Gson gson = new Gson();

	public MetodosCargaDatos(Modelo mod, ConsultaBD bd) {
		this.bd = bd;
		this.mod = mod;
	}

	public void cargarCsv(String path) {
		mod.lectorCsv.cargarCsv(path);
		for (Empleado emple : mod.lectorCsv.getElementos()) {
			if (comprobarEmpleado(emple)) {
				bd.insertGenerico(emple.toObjectArray(), "empleado");
			}
		}
	}

	private boolean comprobarEmpleado(Empleado emple) {
		String json = bd.consultarToGson("SELECT `idDni` 'id' FROM `empleado` WHERE `idDni` ='" + emple.getDni() + "'");
		return json.equals("");
	}

	public Departamento buscarDepartamento(String id) {
		String json = bd.consultarToGson("SELECT `idDepartamento` 'id',`nombre` 'nombre' FROM `departamento` WHERE `idDepartamento` ='" + id + "'");
		Departamento[] departamento = gson.fromJson(json, Departamento[].class);
		if (departamento != null) {
			return departamento[0];
		} else {
			Logger.getInstance().loggear("Error en la búsqueda de departamento",this.getClass(), 3);
			return new Departamento();
		}
	}

	public Cargo buscarCargo(String id) {
		String json = bd.consultarToGson("SELECT `idCargo` 'id',`nombre` 'nombre' FROM `cargo` WHERE `idCargo` ='" + id + "'");
		Cargo[] departamento = gson.fromJson(json, Cargo[].class);
		if (departamento != null) {
			return departamento[0];
		} else {
			Logger.getInstance().loggear("Error en la búsqueda de cargo",this.getClass(), 3);
			return new Cargo();
		}
	}

	public void cargarXml(String path) {
		mod.lectorXml.leerXml(path);
		for (Departamento depar : mod.lectorXml.getDepartamentos()) {
			bd.insertGenerico(depar.getCentro().toObjectArray(), "centro");
			bd.insertGenerico(depar.toObjectArray(), "departamento");
			Object[] ids = {depar.getId(),depar.getCentro().getId()};
			bd.insertGenerico(ids, "tdepartcentro");
		}
	}

	public Centro buscarCentro(String id) {
		String json = bd.consultarToGson("SELECT `idCentro` 'id',`nombre` 'nombre' FROM `centro` WHERE `idCentro` ='" + id + "'");
		Centro[] centro = gson.fromJson(json, Centro[].class);
		if (centro != null) {
			return centro[0];
		} else {
			Logger.getInstance().loggear("Error en la búsqueda de departamento",this.getClass(), 3);
			return new Centro();
		}
	}
}
