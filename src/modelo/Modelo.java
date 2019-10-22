package modelo;

import java.util.ArrayList;

import baseDatos.ConsultaBD;
import lecturaFicheros.LeerCsv;
import modelo.metodos.MetodosCargaDatos;


public class Modelo {

	public ConsultaBD bd;
	public LeerCsv lectorCsv;
	public MetodosCargaDatos cargaDatos;
	//public ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
	//public ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	
	public Modelo() {
		bd = new ConsultaBD();
		lectorCsv=new LeerCsv(this,bd);
		cargaDatos=new MetodosCargaDatos(this, bd);
		addMetodos();
	}

	public void addMetodos() {
		
	}
}
