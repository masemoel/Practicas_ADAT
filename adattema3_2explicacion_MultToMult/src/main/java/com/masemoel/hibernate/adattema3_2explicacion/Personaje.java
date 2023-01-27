package com.masemoel.hibernate.adattema3_2explicacion;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="personajes")
public class Personaje {
	@Id
	private int id;
	
	private String nombre;
	private int vida, puntos;
	
	@OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PersonajeArma> armas = new ArrayList<>();
	
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

	public List<PersonajeArma> getArmas() {
		return armas;
	}
	public void setArmas(List<PersonajeArma> armas) {
		this.armas = armas;
	}

	@Override
	public String toString() {
		return "Personaje [ID=" + id + ", nombre=" + nombre + ", vida=" + vida + ", puntos=" + puntos + " y "+ armas + "]";
	}
	
	public void addArma(Arma arma, String uso_arma) {		
		PersonajeArma personajeArma = new PersonajeArma(this, arma, uso_arma);
		armas.add(personajeArma);
		arma.getPersonajes().add(personajeArma);
	}
	
	public void removeArma(Arma arma) {		
		PersonajeArma personajeArma = new PersonajeArma(this, arma);
		arma.getPersonajes().remove(personajeArma);
		armas.remove(personajeArma);
	}
}