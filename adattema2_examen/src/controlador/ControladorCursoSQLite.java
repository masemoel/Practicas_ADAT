package controlador;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import bbdd.CursoDAOSQLite;
import modelo.Curso;
import modelo.PideDatosCurso;
import vista.VistaCurso;

public class ControladorCursoSQLite {
	// Variable
	private CursoDAOSQLite daocs;
		
	// Constructor
	public ControladorCursoSQLite() {
		try {
			daocs = CursoDAOSQLite.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	// Métodos
	public void nuevoCurso() {
		Curso c;
		Curso c2 = null;
		int codigo;
		PideDatosCurso datos_cur = new PideDatosCurso();
		VistaCurso mostrar = new VistaCurso();
		codigo = datos_cur.pideCodigo();
		try {
			c2 = daocs.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (c2 != null) {
			System.out.println("El código del curso introducido ya existe en la base de datos.");
		} else {
			try {
				c = datos_cur.pideOtrosDatosCurso(codigo);
				daocs.insert(c);
				mostrar.verTodosCursos(daocs.findAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void actualizarCurso() {
		Curso c = null;
		int codigo;
		PideDatosCurso datos_cur = new PideDatosCurso();
		VistaCurso mostrar = new VistaCurso();
		codigo = datos_cur.pideCodigo();
		try {
			c = daocs.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (c == null) {
			System.out.println("El código del curso introducido ya existe en la base de datos.");
		} else {
			try {
				c = datos_cur.pideOtrosDatosCurso(codigo);
				daocs.update(c);
				mostrar.verTodosCursos(daocs.findAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarCurso() {
		Curso c = null;
		int codigo;
		PideDatosCurso datos_cur = new PideDatosCurso();
		VistaCurso mostrar = new VistaCurso();
		codigo = datos_cur.pideCodigo();
		try {
			c = daocs.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (c == null) {
			System.out.println("El código del curso introducido ya existe en la base de datos.");
		} else {
			String confirmacion = JOptionPane.showInputDialog("¿Está seguro que desea eliminar este curso? (Responde 'S'");
			if (confirmacion.equalsIgnoreCase("S")) {
				try {
					daocs.delete(codigo);
					mostrar.verTodosCursos(daocs.findAll());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void mostrarCursos() {
		VistaCurso mostrar = new VistaCurso();
		try {
			mostrar.verTodosCursos(daocs.findAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarCurso() {
		Curso c = null;
		int codigo;
		PideDatosCurso datos_cur = new PideDatosCurso();
		VistaCurso mostrar = new VistaCurso();
		codigo = datos_cur.pideCodigo();
		try {
			c = daocs.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (c == null) {
			System.out.println("El código del curso introducido ya existe en la base de datos.");
		} else {
			mostrar.verCurso(c);
		}
	}
	
	public void acabarPrograma() {
		System.out.println("Gracias, hasta luego.");
		try {
			daocs.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}