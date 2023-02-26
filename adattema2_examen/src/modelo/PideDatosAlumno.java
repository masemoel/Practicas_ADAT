package modelo;

import javax.swing.JOptionPane;

public class PideDatosAlumno {
	public String pideDNI() {
		System.out.print("Introduzca el dni del alumno: ");
		String dni = JOptionPane.showInputDialog("DNI del alumno");
		return dni;
	}
	
	public Alumno pideOtrosDatosAlumno(String dni) {
		Alumno a = null;
		String nombre = JOptionPane.showInputDialog("Nombre");
		String apellido1 = JOptionPane.showInputDialog("Primer apellido");
		String apellido2 = JOptionPane.showInputDialog("Segundo apellido");
		String repetidorS = JOptionPane.showInputDialog("¿Es repetidor? 'S' / 'N'");
		boolean repetidor;
		if (repetidorS == "S") {
			repetidor = true;
		} else {
			repetidor = false;
		}
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad"));
		int cod_curso = Integer.parseInt(JOptionPane.showInputDialog("Código del curso"));
		a = new Alumno(dni, nombre, apellido1, apellido2, repetidor, edad, cod_curso);
		return a;
	}
}