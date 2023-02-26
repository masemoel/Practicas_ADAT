package controlador;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import bbdd.AlumnoDAOMySQL;
import modelo.Alumno;
import modelo.PideDatosAlumno;
import vista.VistaAlumno;

public class ControladorAlumnoMySQL {
	// Variable
	private AlumnoDAOMySQL daoam;
		
	// Constructor
	public ControladorAlumnoMySQL() {
		try {
			daoam = AlumnoDAOMySQL.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	// Métodos
	public void nuevoAlumno() {
		Alumno a;
		Alumno a2 = null;
		String dni;
		PideDatosAlumno datos_al = new PideDatosAlumno();
		VistaAlumno mostrar = new VistaAlumno();
		dni = datos_al.pideDNI();
		try {
			a2 = daoam.findByPk(dni);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (a2 != null) {
			System.out.println("El DNI del alumno introducido ya existe en la base de datos.");
		} else {
			try {
				a = datos_al.pideOtrosDatosAlumno(dni);
				daoam.insert(a);
				mostrar.verTodosAlumnos(daoam.findAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void actualizarAlumno() {
		String dni;
		Alumno a = null;
		PideDatosAlumno datos_al = new PideDatosAlumno();
		VistaAlumno mostrar = new VistaAlumno();
		dni = datos_al.pideDNI();
		try {
			a = daoam.findByPk(dni);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (a == null) {
			System.out.println("El DNI del alumno a modificar no existe en la base de datos.");
		} else {
			try {
				a = datos_al.pideOtrosDatosAlumno(dni);
				daoam.update(a);
				mostrar.verTodosAlumnos(daoam.findAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarAlumno() {
		String dni;
		Alumno a = null;
		PideDatosAlumno datos_al = new PideDatosAlumno();
		VistaAlumno mostrar = new VistaAlumno();
		dni = datos_al.pideDNI();
		try {
			a = daoam.findByPk(dni);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (a == null) {
			System.out.println("El DNI del alumno a modificar no existe en la base de datos.");
		} else {
			String confirmacion = JOptionPane.showInputDialog("¿Está seguro que desea eliminar este alumno? (Responde 'S'");
			if (confirmacion.equalsIgnoreCase("S")) {
				try {
					daoam.delete(dni);
					mostrar.verTodosAlumnos(daoam.findAll());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void mostrarAlumnos() {
		VistaAlumno mostrar = new VistaAlumno();
		try {
			mostrar.verTodosAlumnos(daoam.findAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarAlumno() {
		String dni;
		Alumno a = null;
		PideDatosAlumno datos_al = new PideDatosAlumno();
		VistaAlumno mostrar = new VistaAlumno();
		dni = datos_al.pideDNI();
		try {
			a = daoam.findByPk(dni);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (a == null) {
			System.out.println("El código del alumno a modificar no existe en la base de datos.");
		} else {
			mostrar.verAlumno(a);
		}
	}
	
	public void acabarPrograma() {
		System.out.println("Gracias, hasta luego.");
		try {
			daoam.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}