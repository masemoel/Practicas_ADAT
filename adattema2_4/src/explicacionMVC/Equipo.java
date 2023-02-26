package explicacionMVC;

public class Equipo {
	// Variables
	private String nombre;
	private String ciudad;
	private String conferencia;
	private String division;
	
	// Constructores
	public Equipo() {
		
	}

	public Equipo(String nombre, String ciudad, String conferencia, String division) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.conferencia = conferencia;
		this.division = division;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getConferencia() {
		return conferencia;
	}
	public void setConferencia(String conferencia) {
		this.conferencia = conferencia;
	}

	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}

	// Métodos generales
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", ciudad=" + ciudad + ", conferencia=" + conferencia + ", division=" + division + "]";
	}
}