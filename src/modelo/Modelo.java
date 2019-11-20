package modelo;

import baseDatos.ConsultaBD;
import lecturaFicheros.LectorXml;
import lecturaFicheros.LeerCsv;
import modelo.metodos.MetodosCargaDatos;
import modelo.metodos.MetodosGenerarPDF;
import modelo.metodos.MetodosPanelDpto;
import modelo.metodos.MetodosPanelEmple;
import modelo.metodos.MetodosPanelMenu;
import modelo.metodos.MetodosPanelMenuDpto;
import modelo.metodos.MetodosPanelMenuEmple;
import modelo.objetos.Departamento;


public class Modelo {

	public ConsultaBD bd;
	public LeerCsv lectorCsv;
	public LectorXml lectorXml;
	public MetodosCargaDatos cargaDatos;
	public MetodosPanelMenu mPMenu;
	public MetodosPanelEmple mPEmple;
	public MetodosPanelDpto mPDpto;
	public MetodosPanelMenuDpto mPMDpto;
	public MetodosPanelMenuEmple mPMEmple;
	public MetodosGenerarPDF mGenerarPDF;
	//public ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
	//public ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	public Departamento[] departamentos;
	
	
	public Modelo() {
		bd = new ConsultaBD();
		
		addMetodos();
	}

	public void addMetodos() {
		lectorCsv=new LeerCsv(this);
		lectorXml=new LectorXml();
		cargaDatos=new MetodosCargaDatos(this, bd);
		mPMenu=new MetodosPanelMenu(this,bd);
		mPDpto=new MetodosPanelDpto(this, bd);
		mPEmple = new MetodosPanelEmple(this, bd);
		mPMDpto = new MetodosPanelMenuDpto(this, bd);
		mPMEmple = new MetodosPanelMenuEmple(this, bd);
		mGenerarPDF = new MetodosGenerarPDF(this, bd);
	}
}
