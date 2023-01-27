package com.masemoel.hibernate.adattema3_2explicacion;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="armas")
public class Arma {
	@Id
	private int id;
	
	private String nombre, descripcion;
	private int dano;
	
	@OneToMany(mappedBy = "arma", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PersonajeArma> personajes = new ArrayList<>();
	
	public Arma() {
		
	}

	public Arma(int id, String nombre, String descripcion, int dano) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dano = dano;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}

	public List<PersonajeArma> getPersonajes() {
		return personajes;
	}
	public void setPersonajes(List<PersonajeArma> personajes) {
		this.personajes = personajes;
	}

	@Override
	public String toString() {
		return "Arma [id=" + id + ", nombre=" + nombre + ", descripción=" + descripcion + " y daño=" + dano + "]";
	}
}