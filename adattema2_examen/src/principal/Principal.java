package principal;

import java.util.Scanner;

import javax.swing.JOptionPane;

import controlador.ControladorAlumnoMySQL;
import controlador.ControladorAlumnoSQLite;
import controlador.ControladorCursoMySQL;
import controlador.ControladorCursoSQLite;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el gestor de bases de datos que quieres utilizar:");
		System.out.println("1. MySQL.");
		System.out.println("2. SQLite");
		int choice = sc.nextInt();
		if (choice == 1) {
			ControladorAlumnoMySQL cam = new ControladorAlumnoMySQL();
			ControladorCursoMySQL ccm = new ControladorCursoMySQL();
			int opcion;
			System.out.println("MySQL...");
			do {
				menu();
				opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					cam.mostrarAlumnos();
					break;
				case 2:
					cam.mostrarAlumno();
					break;
				case 3:
					cam.nuevoAlumno();
					break;
				case 4:
					cam.actualizarAlumno();
					break;
				case 5:
					cam.eliminarAlumno();
					break;
				case 6:
					ccm.mostrarCursos();
					break;
				case 7:
					ccm.mostrarCurso();
					break;
				case 8:
					ccm.nuevoCurso();
					break;
				case 9:
					ccm.actualizarCurso();
					break;
				case 10:
					ccm.eliminarCurso();
					break;
				case 0:
					cam.acabarPrograma();
					ccm.acabarPrograma();
					sc.close();
					break;
				}
			} while (opcion != 0);
		} else if (choice == 2) {
			ControladorAlumnoSQLite cas = new ControladorAlumnoSQLite();
			ControladorCursoSQLite ccs = new ControladorCursoSQLite();
			int opcion;
			System.out.println("SQLite...");
			do {
				menu();
				opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					cas.mostrarAlumnos();
					break;
				case 2:
					cas.mostrarAlumno();
					break;
				case 3:
					cas.nuevoAlumno();
					break;
				case 4:
					cas.actualizarAlumno();
					break;
				case 5:
					cas.eliminarAlumno();
					break;
				case 6:
					ccs.mostrarCursos();
					break;
				case 7:
					ccs.mostrarCurso();
					break;
				case 8:
					ccs.nuevoCurso();
					break;
				case 9:
					ccs.actualizarCurso();
					break;
				case 10:
					ccs.eliminarCurso();
					break;
				case 0:
					cas.acabarPrograma();
					ccs.acabarPrograma();
					sc.close();
					break;
				}
			} while (opcion != 0);			
		}
	}
	
	public static void menu() {
		System.out.println("------ GESTIÓN DE INSTITUTO ------");
		System.out.println("1. Mostrar todos los alumnos.");
		System.out.println("2. Mostrar un alumno específico.");
		System.out.println("3. Crear un nuevo alumno.");
		System.out.println("4. Actualizar los datos de un alumno.");
		System.out.println("5. Eliminar un alumno.");
		System.out.println("6. Mostrar todos los cursos.");
		System.out.println("7. Mostrar un curso específico.");
		System.out.println("8. Crear un nuevo curso.");
		System.out.println("9. Actualizar los datos de un curso.");
		System.out.println("10. Eliminar un curso.");
		System.out.println("0. Salir.");
	}
}