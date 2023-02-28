package modelos;

import java.util.List;

public class Persona {
	private String dni, nombre, apellidos;
	private int edad;
	private List<String> aficciones;
	private List<Amigo> amigos;
	
	public Persona() {
		
	}

	public Persona(String dni, String nombre, String apellidos, int edad, List<String> aficciones, List<Amigo> amigos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.aficciones = aficciones;
		this.amigos = amigos;
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

	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<String> getAficciones() {
		return aficciones;
	}
	public void setAficciones(List<String> aficciones) {
		this.aficciones = aficciones;
	}

	public List<Amigo> getAmigos() {
		return amigos;
	}
	public void setAmigos(List<Amigo> amigos) {
		this.amigos = amigos;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", aficciones=" + aficciones + " y " + amigos + "]";
	}
}