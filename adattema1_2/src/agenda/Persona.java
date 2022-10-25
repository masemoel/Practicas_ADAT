package agenda;

import java.io.Serializable;
import java.util.Scanner;

public class Persona implements Serializable {
	// Variables
	private String nombre;
	private String mail;
	private String anonacim;
	private String dni;
	
	// Constructor
	public Persona(String nombre, String mail, String anonacim, String dni) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.anonacim = anonacim;
		this.dni = dni;
	}
	
	// Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getAnonacim() {
		return anonacim;
	}
	public void setAnonacim(String anonacim) {
		this.anonacim = anonacim;
	}
	
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
		@Override
	public String toString() {
		return "Nombre= " + nombre + ", DNI= " + dni + ", correo= " + mail + ", año de nacimiento= " + anonacim;
	}
}