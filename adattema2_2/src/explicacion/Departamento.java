package explicacion;

public class Departamento {
	// Variables
	private int numero;
	private String nombre;
	private String localidad;
	
	// Constructores
	public Departamento() {
		
	}
	
	public Departamento(int numero, String nombre, String localidad) {
		this.numero = numero;
		this.nombre = nombre;
		this.localidad = localidad;
	}

	// Getters y setters
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	
	// Métodos generales
	@Override
	public String toString() {
		return "Departamento [numero=" + numero + ", nombre=" + nombre + ", localidad=" + localidad + "]";
	}
}