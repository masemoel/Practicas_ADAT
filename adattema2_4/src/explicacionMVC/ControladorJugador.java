package explicacionMVC;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ControladorJugador {
	// Variable
	private JugadorDAOMySQL daoj;
	
	// Constructor
	public ControladorJugador() {
		try {
			daoj = JugadorDAOMySQL.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Métodos
	public void nuevoJugador() {
		Jugador j;
		Jugador j2 = null;
		int codigo;
		PideDatosJugador datos_jug = new PideDatosJugador();
		VistaJugador mostrar = new VistaJugador();
		codigo = datos_jug.pideCodigo();
		try {
			j2 = daoj.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (j2 == null) {
			System.out.println("El código del jugador introducido ya existe en la base de datos.");
		} else {
			try {
				j = datos_jug.pideOtrosDatosJugador(codigo);
				daoj.insert(j);
				mostrar.verTodosJugadores(daoj.findAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void actualizarJugador() {
		int codigo;
		Jugador j = null;
		PideDatosJugador datos_jug = new PideDatosJugador();
		VistaJugador mostrar = new VistaJugador();
		codigo = datos_jug.pideCodigo();
		try {
			j = daoj.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (j == null) {
			System.out.println("El código del jugador a modificar no existe en la base de datos.");
		} else {
			try {
				j = datos_jug.pideOtrosDatosJugador(codigo);
				daoj.update(j);
				mostrar.verTodosJugadores(daoj.findAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarJugador() {
		int codigo;
		Jugador j = null;
		PideDatosJugador datos_jug = new PideDatosJugador();
		VistaJugador mostrar = new VistaJugador();
		codigo = datos_jug.pideCodigo();
		try {
			j = daoj.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (j == null) {
			System.out.println("El código del jugador a eliminar no existe en la base de datos.");
		} else {
			String confirmacion = JOptionPane.showInputDialog("¿Está seguro que desea eliminar este jugador? (Responde 'S'");
			if (confirmacion.equalsIgnoreCase("S")) {
				try {
					daoj.delete(codigo);
					mostrar.verTodosJugadores(daoj.findAll());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void mostrarJugadores() {
		VistaJugador mostrar = new VistaJugador();
		try {
			mostrar.verTodosJugadores(daoj.findAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarJugador() {
		int codigo;
		Jugador j = null;
		PideDatosJugador datos_jug = new PideDatosJugador();
		VistaJugador mostrar = new VistaJugador();
		codigo = datos_jug.pideCodigo();
		try {
			j = daoj.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (j == null) {
			System.out.println("El código del jugador a modificar no existe en la base de datos.");
		} else {
			mostrar.verJugador(j);
		}
	}
	
	public void acabarPrograma() {
		System.out.println("Gracias, hasta luego.");
		try {
			daoj.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}