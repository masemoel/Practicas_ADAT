package com.masemoel.hibernate.adattema3_2explicacion;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="armas")
public class Arma {
	@Id
	private int id;

	private String nombre, descripcion;
	private int dano;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personaje_id")
	private Personaje personaje;
	
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

	public Personaje getPersonaje() {
		return personaje;
	}
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	@Override
	public String toString() {
		return "Arma [id=" + id + ", nombre=" + nombre + ", descripción=" + descripcion + " y daño=" + dano + "]";
	}
}