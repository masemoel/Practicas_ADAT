package com.masemoel.hibernate.adattema3_3explicacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class VistaAutores {
	VistaLibros vistali;
	
	public void mostrarAutores() {
		AutorDAOHibernate audao = AutorDAOHibernate.getInstance();
		List<Autor> lista_au = audao.findAll();
		for (Autor a: lista_au) {
			mostrarAutor(a);
		}
	}
	
	public void mostrarAutor(Autor a) {
		System.out.println(a);
	}
	
	public String pideDni() {
		String dni = null;
		dni = JOptionPane.showInputDialog("DNI");
		return dni;
	}
	
	public Autor pideDatos() {
		Autor autor = new Autor();
		String dni, nombre, apellidos;
		try {
			dni = JOptionPane.showInputDialog("DNI");
			nombre = JOptionPane.showInputDialog("Nombre");
			apellidos = JOptionPane.showInputDialog("Apellidos");			
		} catch (Exception e) {
			System.out.println("Datos incorrectos.");
			e.printStackTrace();
			return autor;
		}
		String fechas = JOptionPane.showInputDialog("Fecha de nacimiento (dd/MM/yyyy)");
		Date fechaNac = null;
		try {
			fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(fechas);
		} catch (Exception e) {
			System.out.println("Fecha incorrecta. Introdúcela con el formato dd/MM/yyyy");
			e.printStackTrace();
			return autor;
		}
		autor.setDni(dni);
		autor.setNombre(nombre);
		autor.setApellidos(apellidos);
		autor.setFechaNacimiento(fechaNac);
		return autor;
	}
}