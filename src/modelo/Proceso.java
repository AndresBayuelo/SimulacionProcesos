package modelo;

public class Proceso {
	
	private int servicios;
	private String id;
	
	public Proceso(int servicios, String id) {
		this.servicios = servicios;
		this.id = id;
	}

	public int getServicios() {
		return servicios;
	}

	public void setServicios(int servicios) {
		this.servicios = servicios;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
		return id;
	}
	
}
