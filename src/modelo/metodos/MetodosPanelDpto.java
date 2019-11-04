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

public class MetodosPanelDpto {
	private ConsultaBD bd;
	private Modelo mod;

	private Gson gson = new Gson();

	public MetodosPanelDpto(Modelo mod, ConsultaBD bd) {
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
			departamentos[i] = cargarDepartamento((String) relaciones[i].getAuxiliar1());
			departamentos[i].setCentro(cargarCentroEnDepartamento((String) relaciones[i].getAuxiliar2()));
		}
		return departamentos;
	}

	private Departamento cargarDepartamento(String id) {
		String json = mod.bd.consultarToGson("select `idDepartamento` 'id',`nombre` 'nombre' from `departamento` where `idDepartamento`='" + id + "'");
		Departamento[] departs = gson.fromJson(json, Departamento[].class);
		return departs[0];
	}

	private Centro cargarCentroEnDepartamento(String id) {
		String json = mod.bd.consultarToGson("select `idCentro` 'id',`nombre` 'nombre' from `departamento` where `idCentro`='" + id + "'");
		Centro[] centros = gson.fromJson(json, Centro[].class);
		return centros[0];
	}

	public Centro[] buscarCentros() {
		String aux = bd.consultarToGson("SELECT `idCentro` 'id', `nombre` 'nombre' FROM `centro`");
		Centro[] centros = gson.fromJson(aux, Centro[].class);
		return centros;
	}
}
