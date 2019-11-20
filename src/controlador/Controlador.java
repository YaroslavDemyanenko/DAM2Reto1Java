package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Controlador {

	private VentanaPpal vis;
	private Modelo mod;
	@SuppressWarnings("unused")
	private ControladorPanelMenu cMenu;
	@SuppressWarnings("unused")
	private ControladorPanelMenuEmple cMenuEmple;
	@SuppressWarnings("unused")
	private ControladotPanelMenuDpto cMenuDpto;
	@SuppressWarnings("unused")
	private ControladorPanelEmple cEmple;
	@SuppressWarnings("unused")
	private ControladorPanelDpto cDpto;



	public Controlador(VentanaPpal vista, Modelo modelo) {
		this.vis = vista;
		this.mod = modelo;
		addControladores();
	}


	private void addControladores() {
		mod.cargaDatos.cargarCsv("ficheros/empleados.csv");
		mod.cargaDatos.cargarXml("ficheros/departamentos.xml");
		
		cMenu = new ControladorPanelMenu(vis, this, mod);
		cMenuEmple = new ControladorPanelMenuEmple(vis, this, mod);
		cMenuDpto = new ControladotPanelMenuDpto(vis, this, mod);
		cEmple = new ControladorPanelEmple(vis, this, mod);
		cDpto = new ControladorPanelDpto(vis, this, mod);
		
		mod.departamentos = mod.mPEmple.cargarDepartamentos();

	}	
}
