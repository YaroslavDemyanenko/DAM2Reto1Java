package modelo.objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

import baseDatos.ConsultaBD;

public class Empleado {
	private String dni;
	private String nombre;
	private String apellidos;
	private float sueldo;
	private int esJefe;
	private Date fechaAlta;
	private String fechaString;
	private Cargo cargo;
	private Departamento departamento;
	private Empleado empleJefe;

	public Empleado(String dni, String nombre, String apellidos, float sueldo, int esJefe, Date fechaAlta, Cargo cargo, Departamento departamento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.esJefe = esJefe;
		this.fechaAlta = fechaAlta;
		this.cargo = cargo;
		this.departamento = departamento;
	}
	
	
	@Override
	public String toString() {
		return nombre;
	}
	
	public void convertirFecha() {
		SimpleDateFormat formateador=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
		try {
			this.fechaAlta=formateador.parse(this.fechaString);
		} catch (ParseException e) {
			System.out.println("Error: parse fecha");
		}
	}
	
	public void cargarDatosComplementarios(ConsultaBD bd,Gson gson) {
		String json = bd.consultarToGson("select `idDepartamento` 'auxiliar1',`idCargo` 'auxiliar2' from `empleado` where 'idDni'='"+this.dni+"'");
		Global[] ids = gson.fromJson(json, Global[].class);
		
		
		json = bd.consultarToGson("select `idCargo` 'id',`nombre` 'nombre' from `cargo` where `ìdCargo`='"+ids[0].getAuxiliar2()+"'");
		Cargo[] cargos = gson.fromJson(json, Cargo[].class);
		this.cargo=cargos[0];
		
		json = bd.consultarToGson("select `idDni` 'dni',`nombre` 'nombre',`apellidos` 'apellidos',`sueldo` 'sueldo',`esJefe` 'esJefe', `fechaAlta` 'fechaString' from `empleado` where `esJefe`=1");
		Empleado[] jefes = gson.fromJson(json, Empleado[].class);
		for(Empleado jefe:jefes) {
			jefe.convertirFecha();
		}
		
		/**
		String json = mod.bd.consultarToGson("select `idDepartamento` 'id',`nombre` 'nombre' from `departamento` where `idDepartamento`='" + id + "'");
		Departamento[] departs = gson.fromJson(json, Departamento[].class);
		return departs[0];
		
		
		return jefes;
		**/
	}
	
	public Empleado(String dni, String nombre, String apellidos, int sueldo, int esJefe, Date fechaAlta, Cargo cargo, Departamento departamento,Empleado empleJefe) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.esJefe = esJefe;
		this.fechaAlta = fechaAlta;
		this.cargo = cargo;
		this.departamento = departamento;
		this.setEmpleJefe(empleJefe);
	}

	public Empleado(String dni, String nombre, String apellidos, int sueldo, int esJefe, int fechaAlta, Cargo cargo, Departamento departamento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.esJefe = esJefe;
		this.fechaAlta = new Date();
		this.cargo = cargo;
		this.departamento = departamento;
	}

	
	
	public Object[] toObjectArray() {
		Object[] objetos= {this.dni,this.nombre,this.apellidos,this.sueldo,this.esJefe,this.fechaAlta,this.cargo.id,this.departamento.id};
		return objetos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int isEsJefe() {
		return esJefe;
	}

	public void setEsJefe(int esJefe) {
		this.esJefe = esJefe;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public Empleado getEmpleJefe() {
		return empleJefe;
	}


	public void setEmpleJefe(Empleado empleJefe) {
		this.empleJefe = empleJefe;
	}
}
