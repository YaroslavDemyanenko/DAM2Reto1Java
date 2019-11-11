package logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	public static Logger logger;
	private File ruta = new File("/logs/logs.txt");
	private FileWriter txtWriter;

	public Logger() {
	}

	private static void createInstance() {
		if (logger == null) {
			logger = new Logger();
		}
	}

	public static Logger getInstance() {
		if (logger == null)
			createInstance();
		return logger;
	}

	private void abrirArchivo() throws IOException {
		txtWriter = new FileWriter(this.ruta, true);
	}

	private void cerrarArchivo() throws IOException {
		txtWriter.flush();
		txtWriter.close();
		txtWriter = null;
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
