package modelo;

import java.util.ArrayList;

import baseDatos.ConsultaBD;
import lecturaFicheros.*;
import modelo.metodos.MetodosCargaDatos;


public class Modelo {

	public ConsultaBD bd;
	public LeerCsv lectorCsv;
	public LectorXml lectorXml;
	public MetodosCargaDatos cargaDatos;
	//public ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
	//public ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	
	public Modelo() {
		bd = new ConsultaBD();
		lectorCsv=new LeerCsv(this,bd);
		lectorXml=new LectorXml(this,bd);
		cargaDatos=new MetodosCargaDatos(this, bd);
		addMetodos();
	}

	public void addMetodos() {
		
	}
}
