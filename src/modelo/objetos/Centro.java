package modelo.objetos;

public class Centro {
	
	int id;
	String nombre;		
	
	public Centro() {
		super();
		this.id = 0;
		this.nombre = "";
	}
	
	public Centro(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
	@Override
	public String toString() {
		return nombre;
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

	public Object[] toObjectArray() {
		Object[] objetos =  {id,nombre};
		return objetos;
	}
	
}
