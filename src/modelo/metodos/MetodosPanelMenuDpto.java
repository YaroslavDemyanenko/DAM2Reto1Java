package modelo.metodos;

import com.google.gson.Gson;

import baseDatos.ConsultaBD;
import modelo.Modelo;
import modelo.objetos.Global;

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
	public int numeroPropuestoDpto() {
		String json = mod.bd.consultarToGson("Select max(idDepartamento) 'auxiliar1' from `departamento`");
		Global[] global = gson.fromJson(json, Global[].class);
		return ((Double) global[0].getAuxiliar1()).intValue();
	}
}
