package com.masemoel.hibernate.adattema3_3explicacion;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro implements Serializable {
	@Id
	private int isbn;
	
	private String titulo, editorial;
	private int edicion;
	
	@ManyToOne
	private Autor autor;
	
	public Libro() {
		
	}

	public Libro(int isbn, String titulo, String editorial, int edicion) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.edicion = edicion;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getEdicion() {
		return edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [ISBN=" + isbn + ", título=" + titulo + ", editorial=" + editorial + " y edición=" + edicion + "]";
	}
}