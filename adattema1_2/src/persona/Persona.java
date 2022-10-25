package persona;

import java.io.Serializable;

public class Persona implements Serializable {
	// Variables
	private String nombre;
	private String mail;
	private String anonacim;
	
	// Constructor
	public Persona(String nombre, String mail, String anonacim) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.anonacim = anonacim;
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

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", mail=" + mail + ", anonacim=" + anonacim + "]";
	}
}