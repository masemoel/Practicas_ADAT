package com.masemoel.hibernate.adattema3_2explicacion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
//@Table (name="personajes")
public class Personaje {
	@Id
	private int id;

	private String nombre;
	private int vida, puntos;
	
	@OneToOne(mappedBy = "personaje", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Arma arma;
	
	public Personaje() {
		
	}

	public Personaje(int id, String nombre, int vida, int puntos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.vida = vida;
		this.puntos = puntos;
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

	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}

	@Override
	public String toString() {
		return "Personaje [ID=" + id + ", nombre=" + nombre + ", vida=" + vida + ", puntos=" + puntos + " y "+ arma + "]";
	}
	
	public void addArma(Arma arma) {
		arma.setPersonaje(this);
		this.arma = arma;
	}
	
	public void removeArma() {
		if (arma != null) {
			arma.setPersonaje(null);
			this.arma = null;
		}
	}
}