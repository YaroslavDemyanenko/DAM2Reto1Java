package launcher;

import modelo.Modelo;
import vista.VentanaPpal;


public class Controlador {

	private VentanaPpal vis;
	private Modelo mod;



	public Controlador(VentanaPpal vista, Modelo modelo) {
		this.vis = vista;
		this.mod = modelo;
		addControladores();
		initListeners();
	}


	private void addControladores() {
		mod.cargaDatos.cargarCsv("ficheros/empleados.csv");
		mod.cargaDatos.cargarXml("ficheros/departamentos.xml");
	}

	private void initListeners() {
		
	}
	
	
}
