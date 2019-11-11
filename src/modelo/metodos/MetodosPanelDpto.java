package modelo.metodos;

import com.google.gson.Gson;
import baseDatos.ConsultaBD;
import modelo.Modelo;
import modelo.objetos.Centro;
import modelo.objetos.Departamento;

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
	private boolean comprobarDtpo(int id) {
		String json = mod.bd.consultarToGson("select `idDepartamento` 'id',`nombre` 'nombre' from `departamento` where `idDepartamento`='" + id + "'");
		if (json.equals("")) {
			return false;
		} else {
			return true;
		}
	}
	private boolean comprobarDtpoCentro(int idDpto,int idCentro) {
		String json = mod.bd.consultarToGson("select `idDepartamento`,`idCentro` from `tdepartcentro` where `idDepartamento`='" + idDpto + "' and `idCentro`='"+idCentro+"'");
		if (json.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public Centro[] buscarCentros() {
		String aux = bd.consultarToGson("SELECT `idCentro` 'id', `nombre` 'nombre' FROM `centro`");
		Centro[] centros = gson.fromJson(aux, Centro[].class);
		return centros;
	}
	public boolean insertarDptoNuevo(Departamento depart) {
		if(!comprobarDtpo(depart.getId())) {
			bd.insertGenerico(depart.toObjectArray(), "departamento");
		}
		if(!comprobarDtpoCentro(depart.getId(),depart.getCentro().getId())) {
			bd.insertGenerico(depart.dptoCentro(), "tdepartcentro");
		}else {
			return true;
		}
		return false;
	}
}
