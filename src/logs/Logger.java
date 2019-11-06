package logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	
	private static Logger logger;
	private File ruta = new File("/logs/logs.txt");
	
	private Logger() {}
	
	private static void createInstance() {
        if (logger == null) { 
        	logger = new Logger();
        }
    }

    public static Logger getInstance() {
        if (logger == null) createInstance();
        return logger;
    }
    
    private void abrirArchivo() {
    	
    }
    
    private void cerrarArchivo() {
    	
    }
    
    public void escribirArchivo(String lineas) {
    	
		try {
			FileWriter txtWriter = new FileWriter(this.ruta,true);
			txtWriter.append("\n");
			txtWriter.append(lineas);
			txtWriter.flush();
			txtWriter.close();
			
		} catch (IOException e) {
			
			System.out.println("Es posible que otro usuario esté editando el archivo");
		}
	}
}

