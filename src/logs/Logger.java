package logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	private static Logger logger;
	private String ruta = "/logs/logs.txt";
	private FileWriter txtWriter;

	private Logger() {
	}

	private static void createInstance() {
		logger = new Logger();
	}

	public static Logger getInstance() {
		if (logger == null)
			createInstance();
		return logger;
	}

	private void abrirArchivo() throws IOException {
		txtWriter = new FileWriter(new File(this.ruta), true);
	}

	private void cerrarArchivo() throws IOException {
		txtWriter.flush();
		txtWriter.close();
	}

	public void escribirArchivo(String lineas) {
		try {
			abrirArchivo();
			txtWriter.append("\n" + lineas);
			cerrarArchivo();
		} catch (IOException e) {
		}

	}
}
