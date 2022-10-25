package videojuegos;

import java.io.Serializable;

public class Videojuegos implements Serializable{
	// Variables
	private String nombre;
	private String genero;
	private String plataforma;
	private String descripcion;
	private String anyo;
	
	// Constructor
	public Videojuegos(String nombre, String genero, String plataforma, String descripcion, String anyo) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.plataforma = plataforma;
		this.descripcion = descripcion;
		this.anyo = anyo;
	}
	
	// Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAnyo() {
		return anyo;
	}
	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}
	
	// Métodos generales
	@Override
	public String toString() {
		return "Nombre= " + nombre + ", género=" + genero + ", plataforma= " + plataforma + ", descripción= " + descripcion + ", año= " + anyo + "]";
	}
}