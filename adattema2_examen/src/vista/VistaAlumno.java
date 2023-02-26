package vista;

import java.util.List;

import modelo.Alumno;

public class VistaAlumno {
	public void verAlumno(Alumno a) {
		System.out.println("Datos del alumno: "+a);
	}
	
	public void verTodosAlumnos(List<Alumno> alumnos) {
		for (Alumno alumno: alumnos) {
			System.out.println("Datos del alumno: "+alumno);
		}
	}
}