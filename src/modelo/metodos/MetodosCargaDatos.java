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
			if(true) {
			bd.insertGenerico(emple.toObjectArray(), "empleado");
			}else {
				continue;
			}
		}
	}

	public Departamento buscarDepartamento(String id) {
		String json = bd.consultarToGson("SELECT `idDepartamento` 'id',`nombre` 'nombre' FROM `departamento` WHERE `idDepartamento` ='" + id + "'");
		Departamento[] departamento = gson.fromJson(json, Departamento[].class);
		if (departamento != null) {
			return departamento[0];
		} else {
			//LOG
			return new Departamento();
		}
	}

	public Cargo buscarCargo(String id) {
		String json = bd.consultarToGson("SELECT `idCargo` 'id',`nombre` 'nombre' FROM `cargo` WHERE `idCargo` ='" + id + "'");
		Cargo[] departamento = gson.fromJson(json, Cargo[].class);
		if (departamento != null) {
			return departamento[0];
		} else {
			//LOG
			return new Cargo();
		}
	}

	/**
	 * public void cargarXml(String path) { mod.lectorCsv.cargarCsv(path);
	 * for(Empleado emple:mod.lectorCsv.getElementos()) {
	 * bd.insertGenerico(emple.toObjectArray(), "empleado"); } }
	 **/
}
