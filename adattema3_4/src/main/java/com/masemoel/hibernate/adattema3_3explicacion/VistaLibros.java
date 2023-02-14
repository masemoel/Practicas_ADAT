package com.masemoel.hibernate.adattema3_3explicacion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class VistaLibros {
	public void mostrarLibros() {
		LibroDAOHibernate lidao = LibroDAOHibernate.getInstance();
		ArrayList<Libro> lista_l = lidao.findAll();
		for (Libro l: lista_l) {
			mostrarLibro(l);
		}
	}
	
	public void mostrarLibro(Libro l) {
		System.out.println(l);
	}
	
	public int pideISBN() {
		int isbn = 0;
		isbn = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el ISBN"));
		return isbn;
	}
	
	public Libro pideDatos() {
		Libro l = new Libro();
		int isbn, edicion;
		String titulo, editorial;
		try {
			isbn = Integer.parseInt(JOptionPane.showInputDialog("ISBN"));
			titulo = JOptionPane.showInputDialog("Título");
			editorial = JOptionPane.showInputDialog("Editorial");
			edicion = Integer.parseInt(JOptionPane.showInputDialog("Edición"));
		} catch (Exception e) {
			System.out.println("Datos incorrectos. Saliendo...");
			return l;
		}
		l.setIsbn(isbn);
		l.setTitulo(titulo);
		l.setEditorial(editorial);
		l.setEdicion(edicion);
		return l;
	}
}