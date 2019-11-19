package launcher;

import controlador.Controlador;
import logs.Logger;
import modelo.Modelo;
import vista.VentanaPpal;

public class Launcher {

	/**
	 * Main del programa
	 * @param args parametros de la aplicacion
	 */
	public static void main(String[] args) {
		VentanaPpal vista = new VentanaPpal();
		Modelo modelo = new Modelo();		
		Logger log = Logger.getInstance();
		
		log.loggear("[Nueva ejecución]",Launcher.class, 1);
		
		vista.pCenter.nextPanel();
		vista.pCenter.prevPanel();
		
		@SuppressWarnings("unused")
		Controlador controlador = new Controlador(vista, modelo);
	}
}