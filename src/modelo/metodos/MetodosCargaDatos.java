package modelo.metodos;

import com.google.gson.Gson;

import baseDatos.ConsultaBD;
import modelo.Modelo;
import modelo.objetos.Cargo;
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
		if (json.equals("")) {
			return true;
		} else
			return false;
	}

	public Departamento buscarDepartamento(String id) {
		String json = bd.consultarToGson("SELECT `idDepartamento` 'id',`nombre` 'nombre' FROM `departamento` WHERE `idDepartamento` ='" + id + "'");
		Departamento[] departamento = gson.fromJson(json, Departamento[].class);
		if (departamento != null) {
			return departamento[0];
		} else {
			// LOG
			return new Departamento();
		}
	}

	public Cargo buscarCargo(String id) {
		String json = bd.consultarToGson("SELECT `idCargo` 'id',`nombre` 'nombre' FROM `cargo` WHERE `idCargo` ='" + id + "'");
		Cargo[] departamento = gson.fromJson(json, Cargo[].class);
		if (departamento != null) {
			return departamento[0];
		} else {
			// LOG
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
}
