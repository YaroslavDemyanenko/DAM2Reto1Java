package modelo.objetos;

import java.util.Date;

public class Empleado {
	private String dni;
	private String nombre;
	private String apellidos;
	private int sueldo;
	private boolean esJefe;
	private Date fechaAlta;
	private Cargo cargo;
	private Departamento departamento;

	public Empleado(String dni, String nombre, String apellidos, int sueldo, boolean esJefe, Date fechaAlta, Cargo cargo, Departamento departamento) {
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

	public Empleado(String dni, String nombre, String apellidos, int sueldo, boolean esJefe, int fechaAlta, Cargo cargo, Departamento departamento) {
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

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public boolean isEsJefe() {
		return esJefe;
	}

	public void setEsJefe(boolean esJefe) {
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
}
