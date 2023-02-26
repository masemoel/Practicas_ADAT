package explicacionMVC;

public class Jugador {
	// Variables
	private int codigo;
	private String nombre;
	private String nombre_equipo;
	private String procedencia;
	private String altura;
	private String posicion;
	private int peso;
	
	// Constructores
	public Jugador() {
		
	}

	public Jugador(int codigo, String nombre, String nombre_equipo, String procedencia, String altura, String posicion, int peso) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nombre_equipo = nombre_equipo;
		this.procedencia = procedencia;
		this.altura = altura;
		this.posicion = posicion;
		this.peso = peso;
	}

	// Getters y setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_equipo() {
		return nombre_equipo;
	}
	public void setNombre_equipo(String nombre_equipo) {
		this.nombre_equipo = nombre_equipo;
	}

	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	// Métodos generales
	@Override
	public String toString() {
		return "Jugador [codigo=" + codigo + ", nombre=" + nombre + ", nombre_equipo=" + nombre_equipo
				+ ", procedencia=" + procedencia + ", altura=" + altura + ", posicion=" + posicion + ", peso=" + peso
				+ "]";
	}
}