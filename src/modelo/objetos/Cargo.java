package modelo.objetos;

public class Cargo {
	int id;
	String nombre;
	
	public Cargo() {
		super();
		this.id = 0;
		this.nombre = "";
	}
	public Cargo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}	
	
	public Cargo getCargoById(Cargo[] cargos,int id) {
		for(Cargo carg:cargos) {
			if(carg.getId()==id)
				return carg;
		}
		return null;
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
}
