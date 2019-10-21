package lecturaFicheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class EditorCsv {

	private List<Libro> registro;
	private String[] campos;
	private String ruta;

	public EditorCsv() {
		registro = new ArrayList<>();
	}

	public List<Libro> cargarCsv(String path) {
		ruta = path;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			campos = line.split(",");
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				registro.add(Libro.toLibro(values));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Algo ha fallado a la hora de escribir o leer tu archivo");
		}
		return registro;
	}

	

	
}
