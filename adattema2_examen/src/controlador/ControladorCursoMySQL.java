package controlador;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import bbdd.CursoDAOMySQL;
import modelo.Curso;
import modelo.PideDatosCurso;
import vista.VistaCurso;

public class ControladorCursoMySQL {
	// Variable
	private CursoDAOMySQL daocm;
		
	// Constructor
	public ControladorCursoMySQL() {
		try {
			daocm = CursoDAOMySQL.getInstance();
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
			c2 = daocm.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (c2 != null) {
			System.out.println("El código del curso introducido ya existe en la base de datos.");
		} else {
			try {
				c = datos_cur.pideOtrosDatosCurso(codigo);
				daocm.insert(c);
				mostrar.verTodosCursos(daocm.findAll());
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
			c = daocm.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (c == null) {
			System.out.println("El código del curso introducido ya existe en la base de datos.");
		} else {
			try {
				c = datos_cur.pideOtrosDatosCurso(codigo);
				daocm.update(c);
				mostrar.verTodosCursos(daocm.findAll());
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
			c = daocm.findByPk(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (c == null) {
			System.out.println("El código del curso introducido ya existe en la base de datos.");
		} else {
			String confirmacion = JOptionPane.showInputDialog("¿Está seguro que desea eliminar este curso? (Responde 'S'");
			if (confirmacion.equalsIgnoreCase("S")) {
				try {
					daocm.delete(codigo);
					mostrar.verTodosCursos(daocm.findAll());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void mostrarCursos() {
		VistaCurso mostrar = new VistaCurso();
		try {
			mostrar.verTodosCursos(daocm.findAll());
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
			c = daocm.findByPk(codigo);
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
			daocm.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}