package vista;

import java.util.List;

import modelo.Curso;

public class VistaCurso {
	public void verCurso(Curso c) {
		System.out.println("Datos del curso: "+c);
	}
	
	public void verTodosCursos(List<Curso> cursos) {
		for (Curso curso: cursos) {
			System.out.println("Datos del curso: "+curso);
		}
	}
}