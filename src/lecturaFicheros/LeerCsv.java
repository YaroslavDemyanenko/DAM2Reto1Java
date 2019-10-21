package lecturaFicheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Empleado;

public class LeerCsv {

	private List<Empleado> elementos;

	public LeerCsv() {
		elementos = new ArrayList<>();
	}

	public List<Empleado> cargarCsv(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				elementos.add(Empleado.toEmpleado(values));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Algo ha fallado a la hora de escribir o leer tu archivo");
		}
		return elementos;
	}

	

	
}
