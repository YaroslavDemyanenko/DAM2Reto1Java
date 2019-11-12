package lecturaFicheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import baseDatos.ConsultaBD;
import logs.Logger;
import modelo.Modelo;
import modelo.objetos.Cargo;
import modelo.objetos.Departamento;
import modelo.objetos.Empleado;

public class LeerCsv {

	private ConsultaBD bd;
	private Modelo mod;
	
	private List<Empleado> elementos;

	public LeerCsv(Modelo mod, ConsultaBD bd) {
		this.bd = bd;
		this.mod = mod;
		elementos = new ArrayList<>();
	}


	public List<Empleado> cargarCsv(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				Empleado empleadoAux= toEmpleado(values);
				elementos.add(empleadoAux);
			}
		} catch (FileNotFoundException e) {
//			Logger.getInstance().escribirArchivo("Error, archivo no encontrado");
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
//			Logger.getInstance().escribirArchivo("Error, no es posible leer/escribir el archivo");
			System.out.println("No es posible leer/escribir el archivo");
		}
		return elementos;
	}

	public Empleado toEmpleado(String[] valores) {
		int sueldo = Integer.valueOf(valores[3]);
		
		int jefe = 0;
		if (Integer.valueOf(valores[4]) == 1) {
			jefe = 1;
		}
		
		Cargo cargo= mod.cargaDatos.buscarCargo(valores[6]);
		Departamento departamento= mod.cargaDatos.buscarDepartamento(valores[7]);
		Empleado emple = new Empleado(valores[0], valores[1], valores[2], sueldo, jefe, new Date(), cargo, departamento);
		return emple;
	}
	
	
	public List<Empleado> getElementos() {
		return elementos;
	}

	public void setElementos(List<Empleado> elementos) {
		this.elementos = elementos;
	}	
}
