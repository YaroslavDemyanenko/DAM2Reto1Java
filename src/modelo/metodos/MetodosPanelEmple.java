package modelo.metodos;

import java.util.Date;
import com.google.gson.Gson;
import baseDatos.ConsultaBD;
import modelo.Modelo;
import modelo.objetos.Cargo;
import modelo.objetos.Centro;
import modelo.objetos.Departamento;
import modelo.objetos.Empleado;
import modelo.objetos.Global;

public class MetodosPanelEmple {
	private ConsultaBD bd;
	private Modelo mod;

	private Gson gson = new Gson();

	public MetodosPanelEmple(Modelo mod, ConsultaBD bd) {
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
	
	public Departamento[] cargarDepartamentos() {
		String json = mod.bd.consultarToGson("select `idDepartamento` 'auxiliar1',`idCentro` 'auxiliar2' from `tdepartcentro`");
		Global[] relaciones = gson.fromJson(json, Global[].class);

		Departamento[] departamentos = new Departamento[relaciones.length];
		for (int i = 0; i < relaciones.length; i++) {
			departamentos[i] = cargarDepartamento(Double.toString((double) relaciones[i].getAuxiliar1()));
			departamentos[i].setCentro(cargarCentroEnDepartamento(Double.toString((double) relaciones[i].getAuxiliar2())));
		}
		return departamentos;
	}
	

	private Departamento cargarDepartamento(String id) {
		String json = mod.bd.consultarToGson("select `idDepartamento` 'id',`nombre` 'nombre' from `departamento` where `idDepartamento`='" + id + "'");
		Departamento[] departs = gson.fromJson(json, Departamento[].class);
		return departs[0];
	}

	private Centro cargarCentroEnDepartamento(String id) {
		String json = mod.bd.consultarToGson("select `idCentro` 'id',`nombre` 'nombre' from `centro` where `idCentro`='" + id + "'");
		Centro[] centros = gson.fromJson(json, Centro[].class);
		return centros[0];
	}

	public Cargo[] cargarCargos() {
		String json = mod.bd.consultarToGson("select `idCargo` 'id',`nombre` 'nombre' from `cargo`");
		Cargo[] cargos = gson.fromJson(json, Cargo[].class);
		return cargos;
	}

	public Empleado[] cargarJefes() {
		String json = mod.bd.consultarToGson("select `idDni` 'dni',`nombre` 'nombre',`apellidos` 'apellidos',`sueldo` 'sueldo',`esJefe` 'esJefe', `fechaAlta` 'fechaString' from `empleado` where `esJefe`=1");
		Empleado[] jefes = gson.fromJson(json, Empleado[].class);
		for(Empleado jefe:jefes) {
			jefe.convertirFecha();
		}
		return jefes;
	}
	
	public Empleado[] cargarEmpleados(int idDepartamento) {
		String json = mod.bd.consultarToGson("select `idDni` 'dni',`nombre` 'nombre',`apellidos` 'apellidos',`sueldo` 'sueldo',`esJefe` 'esJefe', `fechaAlta` 'fechaString' from `empleado` where `idDepartamento`='" + idDepartamento + "'" );
		Empleado[] empleados = gson.fromJson(json, Empleado[].class);
		if(empleados != null) {
			for(Empleado empleado:empleados) {
				empleado.convertirFecha();
			}
		}
		return empleados;
	}
}
