package modelo;

import javax.swing.JOptionPane;

public class PideDatosCurso {
	public int pideCodigo() {
		System.out.print("Introduzca el código del curso: ");
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código"));
		return codigo;
	}
	
	public Curso pideOtrosDatosCurso(int codigo) {
		Curso c = null;
		int curso = Integer.parseInt(JOptionPane.showInputDialog("Curso"));
		String nombre = JOptionPane.showInputDialog("Nombre");
		String nivel = JOptionPane.showInputDialog("Nivel");
		String fpdualS = JOptionPane.showInputDialog("¿Es FP dual? 'S' / 'N'");
		boolean fpdual;
		if (fpdualS == "S") {
			fpdual = true;
		} else {
			fpdual = false;
		}
		int clase = Integer.parseInt(JOptionPane.showInputDialog("Clase"));
		c = new Curso(codigo, curso, nombre, nivel, fpdual, clase);
		return c;
	}
}