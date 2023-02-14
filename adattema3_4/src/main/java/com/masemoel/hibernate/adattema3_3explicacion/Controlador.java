package com.masemoel.hibernate.adattema3_3explicacion;

import javax.swing.JOptionPane;

public class Controlador {
	AutorDAOHibernate audao = AutorDAOHibernate.getInstance();
	LibroDAOHibernate lidao = LibroDAOHibernate.getInstance();
	VistaAutores vistaau = new VistaAutores();
	VistaLibros vistali = new VistaLibros();
	
	public void insertarAu() {
		Autor au = vistaau.pideDatos();
		audao.insert(au);
		vistaau.mostrarAutores();
	}
	
	public void actualizarAu() {
		Autor au = null;
		vistaau.mostrarAutores();
		String dni = vistaau.pideDni();
		au = audao.findByPk(dni);
		if (au == null) {
			System.out.println("No se ha encontrado un autor con código "+dni);
		} else {
			Autor au2 = vistaau.pideDatos();
			au2.setDni(dni);
			audao.update(au2);
			vistaau.mostrarAutores();
		}
	}
	
	public void eliminarAu() {
		Autor au = null;
		vistaau.mostrarAutores();
		String dni = vistaau.pideDni();
		au = audao.findByPk(dni);
		if (au == null) {
			System.out.println("No se ha encontrado un autor con código "+dni);
		} else {
			String conf = JOptionPane.showInputDialog("¿Estás seguro de eliminar dicho autor? 'S' / 'N'");
			if (conf.equalsIgnoreCase("s")) {
				audao.delete(au);
				vistaau.mostrarAutores();
			}
		}
	}
	
	public void muestraAutores() {
		vistaau.mostrarAutores();
	}
	
	public void muestraAutor() {
		Autor au = null;
		vistaau.mostrarAutores();
		String dni = vistaau.pideDni();
		au = audao.findByPk(dni);
		if (au == null) {
			System.out.println("No se ha encontrado un autor con código "+dni);
		} else {
			vistaau.mostrarAutor(au);
		}
	}
	
	public void insertarLi() {
		Autor au = null;
		vistaau.mostrarAutores();
		String dni = vistaau.pideDni();
		au = audao.findByPk(dni);
		if (au == null) {
			System.out.println("No se ha encontrado un autor con código "+dni);
		} else {
			Libro li = vistali.pideDatos();
			au.addLibro(li);
			audao.insert(au);
			vistaau.mostrarAutores();
		}
	}
	
	public void actualizarLi() {
		Libro li = null;
		vistaau.mostrarAutores();
		int isbn = vistali.pideISBN();
		li = lidao.findByPk(isbn);
		if (li == null) {
			System.out.println("No se ha encontrado un libro con ISBN "+isbn);
		} else {
			Libro li2 = vistali.pideDatos();
			li2.setIsbn(isbn);
			li2.setAutor(li.getAutor());
			lidao.update(li2);
			vistaau.mostrarAutor(li2.getAutor());
		}
	}
	
	public void eliminarLi() {
		Libro li = null;
		vistaau.mostrarAutores();
		int isbn = vistali.pideISBN();
		li = lidao.findByPk(isbn);
		if (li == null) {
			System.out.println("No se ha encontrado un libro con ISBN "+isbn);
		} else {
			String conf = JOptionPane.showInputDialog("¿Estás seguro de eliminar dicho libro? 'S' / 'N'");
			if (conf.equalsIgnoreCase("s")) {
				Autor au = li.getAutor();
				au.removeLibro(li);
				lidao.delete(li);
				vistaau.mostrarAutor(au);
			}
		}
	}
	
	public void muestraLibros() {
		vistali.mostrarLibros();
	}
	
	public void muestraLibro() {
		Libro li = null;
		int isbn = vistali.pideISBN();
		li = lidao.findByPk(isbn);
		if (li == null) {
			System.out.println("No se ha encontrado un libro con código "+isbn);
		} else {
			vistali.mostrarLibro(li);
		}
	}
	
	public void finalizarPrograma() {
		try {
			lidao.closeDAO();
			audao.closeDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Gracias. ¡Hasta pronto!");
	}
}