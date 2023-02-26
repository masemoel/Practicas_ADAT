package modelo;

public class Alumno {
	// Variables
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private boolean repetidor;
	private int edad;
	private int cod_curso;
	
	// Constructor
	public Alumno() {
		
	}

	public Alumno(String dni, String nombre, String apellido1, String apellido2, boolean repetidor, int edad, int cod_curso) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.repetidor = repetidor;
		this.edad = edad;
		this.cod_curso = cod_curso;
	}
	
	// Getters y setters
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

	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public boolean isRepetidor() {
		return repetidor;
	}
	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCod_curso() {
		return cod_curso;
	}
	public void setCod_curso(int cod_curso) {
		this.cod_curso = cod_curso;
	}
	
	// Métodos generales
	@Override
	public String toString() {
		return "Alumno [DNI=" + dni + ", nombre=" + nombre + ", primer apellido=" + apellido1 + ", segundo apellido=" + apellido2
				+ ", es repetidor=" + repetidor + ", edad=" + edad + ", código del curso=" + cod_curso + "]";
	}
}