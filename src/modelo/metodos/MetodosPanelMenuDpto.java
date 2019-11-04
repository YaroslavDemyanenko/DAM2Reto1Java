package modelo.metodos;

import com.google.gson.Gson;
import baseDatos.ConsultaBD;
import modelo.Modelo;
import modelo.objetos.Departamento;
import modelo.objetos.Empleado;

public class MetodosPanelMenuDpto {
	private ConsultaBD bd;
	private Modelo mod;
	
	private Gson gson = new Gson();
	
	public MetodosPanelMenuDpto(Modelo mod, ConsultaBD bd) {
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
	
//	public Departamento[] cargarDepartamentos() {
//		String json = mod.bd.consultarToGson("select `idDepartamento` 'auxiliar1',`idCentro` 'auxiliar2' from `tdepartcentro`");
//		Global[] relaciones = gson.fromJson(json, Global[].class);
//
//		Departamento[] departamentos = new Departamento[relaciones.length];
//		for (int i = 0; i < relaciones.length; i++) {
//			departamentos[i] = cargarDepartamento((String) relaciones[i].getAuxiliar1());
//			departamentos[i].setCentro(cargarCentroEnDepartamento((String) relaciones[i].getAuxiliar2()));
//		}
//		return departamentos;
//	}
	
	public Departamento[] cargarDepartamento() {
		String json = mod.bd.consultarToGson(
				"SELECT `idDepartamento` 'id',`nombre` 'nombre' FROM `departamento`");
		Departamento[] departs = gson.fromJson(json, Departamento[].class);
		return departs;
	}
	
	public Empleado[] cargarEmpleadosPorId(String id) {
		String json = mod.bd.consultarToGson(
				"SELECT `idDni` 'dni',"
				+ "`nombre` 'nombre',"
				+ "`apellidos` 'apellidos',"
//				+ "`idCargo` 'idCargo',"				
				+ "`esJefe` 'esJefe',"
				+ "`sueldo` 'sueldo,"
				+ "`fechaAlta` 'fechaAlta' "
				+ " FROM `empleado` WHERE idDepartamento IN (SELECT idDepartamento FROM departamento WHERE idDepartamento="+id+")");
		Empleado[] empleado = gson.fromJson(json, Empleado[].class);
		
		return empleado;
	}
}
