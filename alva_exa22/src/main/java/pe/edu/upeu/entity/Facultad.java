package pe.edu.upeu.entity;

public class Facultad {
	private int idfacultad;
	private String nombre;

	public Facultad() {
		super();
	}

	public Facultad(int idfacultad, String nombre) {
		super();
		this.idfacultad = idfacultad;
		this.nombre = nombre;
	}

	public int getIdfacultad() {
		return idfacultad;
	}

	public void setIdfacultad(int idfacultad) {
		this.idfacultad = idfacultad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
