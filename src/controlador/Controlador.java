package controlador;

import modelo.Modelo;
import vista.VentanaPpal;


public class Controlador {

	private VentanaPpal vis;
	private Modelo mod;
	private ControladorPanelMenu cMenu;



	public Controlador(VentanaPpal vista, Modelo modelo) {
		this.vis = vista;
		this.mod = modelo;
		addControladores();
		initListeners();
	}


	private void addControladores() {
		mod.cargaDatos.cargarCsv("ficheros/empleados.csv");
		mod.cargaDatos.cargarXml("ficheros/departamentos.xml");
		
		cMenu = new ControladorPanelMenu(vis, this, mod);
		
		
	}

	private void initListeners() {
		
	}
	
	
	
	
}
