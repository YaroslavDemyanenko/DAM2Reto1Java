package modelo.objetos;

public class Departamento {
	
	int id;
	String nombre;
	Centro centro;
		
	public Departamento() {
		super();
		this.id = 0;
		this.nombre = "";
		this.centro = null;
	}
	public Departamento(int id, String nombre, Centro centro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.centro = centro;
	}
	
	public Object[] toObjectArray() {
		Object[] objetos= {this.id,this.nombre};
		return objetos;
	}
	public Object[] dptoCentro() {
		Object[] objetos= {id,centro.getId()};
		return objetos;
	}
	@Override
	public String toString() {
		if (centro.nombre != null) {
			return centro.nombre+" - "+ nombre;	
		}else {
			return nombre;
		}
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Centro getCentro() {
		return centro;
	}
	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	
	
}
