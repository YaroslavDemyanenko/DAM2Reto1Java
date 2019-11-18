package modelo.metodos;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.gson.Gson;
import com.itextpdf.kernel.pdf.PdfWriter;
import baseDatos.ConsultaBD;
import lecturaFicheros.GenerarPDF;
import modelo.Modelo;
import modelo.objetos.Cargo;
import modelo.objetos.Centro;
import modelo.objetos.Departamento;
import modelo.objetos.Empleado;
import modelo.objetos.Global;

public class MetodosGenerarPDF {
	private ConsultaBD bd;
	private Modelo mod;

	private Gson gson = new Gson();

	public MetodosGenerarPDF(Modelo mod, ConsultaBD bd) {
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

	public boolean generarPDFdepartamentos() {

		Departamento[] departamentos = cargarDepartamentos();

		GenerarPDF generarPDF = new GenerarPDF();
		PdfWriter writer = null;
		try {
			writer = new PdfWriter("ficheros/Informe_departamentos.pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generarPDF.crearPDF(writer, null, departamentos);
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean generarPDFempleados() {

		Empleado[] empleados = cargarEmpleados();

		GenerarPDF generarPDF = new GenerarPDF();
		PdfWriter writer = null;
		try {
			writer = new PdfWriter("ficheros/Informe_empleados.pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generarPDF.crearPDF(writer, empleados, null);
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Departamento[] cargarDepartamentos() {
		String json = mod.bd
				.consultarToGson("select `idDepartamento` 'auxiliar1',`idCentro` 'auxiliar2' from `tdepartcentro`");
		Global[] relaciones = gson.fromJson(json, Global[].class);

		Departamento[] departamentos = new Departamento[relaciones.length];
		for (int i = 0; i < relaciones.length; i++) {
			departamentos[i] = cargarDepartamento(Double.toString((double) relaciones[i].getAuxiliar1()));
			departamentos[i]
					.setCentro(cargarCentroEnDepartamento(Double.toString((double) relaciones[i].getAuxiliar2())));
		}
		return departamentos;
	}

	private Departamento cargarDepartamento(String id) {
		String json = mod.bd.consultarToGson(
				"select `idDepartamento` 'id',`nombre` 'nombre' from `departamento` where `idDepartamento`='" + id
						+ "'");
		Departamento[] departs = gson.fromJson(json, Departamento[].class);
		return departs[0];
	}

	private Centro cargarCentroEnDepartamento(String id) {
		String json = mod.bd.consultarToGson(
				"select `idCentro` 'id',`nombre` 'nombre' from `centro` where `idCentro`='" + id + "'");
		Centro[] centros = gson.fromJson(json, Centro[].class);
		return centros[0];
	}
	
	private Departamento cargarDepartamentoEmple(String idDni) {
		String json = mod.bd.consultarToGson(
				"select `idDepartamento` 'id',`nombre` 'nombre' from `departamento` where `idDepartamento`=(select idDepartamento from empleado where idDni='"+ idDni +"')");
		Departamento[] departs = gson.fromJson(json, Departamento[].class);
		return departs[0];
	}

	public Cargo cargarCargo(String idDni) {
		String json = mod.bd.consultarToGson("select `idCargo` 'id',`nombre` 'nombre' from `cargo` where idCargo=(select idCargo from empleado where idDni='"+ idDni +"')");
		Cargo[] cargos = gson.fromJson(json, Cargo[].class);
		return cargos[0];
	}

	public Empleado cargarJefes(String idDni) {
		String json = mod.bd.consultarToGson(
				"select empleado.idDni 'dni',nombre 'nombre',apellidos 'apellidos',sueldo 'sueldo',esJefe 'esJefe', fechaAlta 'fechaString' from empleado, templejefe  WHERE empleado.idDni = templejefe.idJefe and templejefe.idDni = '"
						+ idDni + "'");
		Empleado[] jefes = gson.fromJson(json, Empleado[].class);
		if (jefes == null) {
			return null;
		} else {
			return jefes[0];
		}
	}

	public Empleado[] cargarEmpleados() {
		String json = mod.bd.consultarToGson(
				"select `idDni` 'dni',`nombre` 'nombre',`apellidos` 'apellidos',`sueldo` 'sueldo',`esJefe` 'esJefe', `fechaAlta` 'fechaString' from `empleado`");
		Empleado[] empleados = gson.fromJson(json, Empleado[].class);
		if (empleados != null) {
			for (int i = 0; i < empleados.length; i++) {
				empleados[i].convertirFecha();
				Empleado jefe = cargarJefes(empleados[i].getDni());
				if (jefe != null) {
					empleados[i].setEmpleJefe(jefe);
				}
				empleados[i].setCargo(cargarCargo(empleados[i].getDni()));
				empleados[i].setDepartamento(cargarDepartamentoEmple(empleados[i].getDni()));
			}
		}
		return empleados;
	}
}
