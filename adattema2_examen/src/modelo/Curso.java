package modelo;

public class Curso {
	// Variables
	private int codigo;
	private int curso;
	private String nombre;
	private String nivel;
	private boolean fpdual;
	private int clase;
	
	// Constructor
	public Curso() {
		
	}

	public Curso(int codigo, int curso, String nombre, String nivel, boolean fpdual, int clase) {
		super();
		this.codigo = codigo;
		this.curso = curso;
		this.nombre = nombre;
		this.nivel = nivel;
		this.fpdual = fpdual;
		this.clase = clase;
	}

	// Getters y setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public boolean isFpdual() {
		return fpdual;
	}
	public void setFpdual(boolean fpdual) {
		this.fpdual = fpdual;
	}

	public int getClase() {
		return clase;
	}
	public void setClase(int clase) {
		this.clase = clase;
	}

	// Métodos generales
	@Override
	public String toString() {
		return "Curso [código=" + codigo + ", curso=" + curso + ", nombre=" + nombre + ", nivel=" + nivel + ", enseñanza dual="
				+ fpdual + ", clase=" + clase + "]";
	}
}