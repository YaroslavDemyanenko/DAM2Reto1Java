package logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {

	private static Logger logger;
	private String ruta = "logs/logs.txt";
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

	public void loggear(String lineas,Class<?> clase, int nivel) {
		File archivo = new File(this.ruta);
		
		try {
			txtWriter = new FileWriter(archivo, true);
			txtWriter.append(new Date().toString() + " | " +  clase.getSimpleName() + " [" + nivel + "] | " + lineas + "\n");
			txtWriter.flush();
			txtWriter.close();
		} catch (IOException e) {
		}
	}
}
