package com.masemoel.hibernate.adattema3_2explicacion;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(PersonajeArmaId.class)
public class PersonajeArma {
	@Id
	@ManyToOne
	@JoinColumn(name="personaje_id", insertable = false, updatable = false)
	private Personaje personaje;
	
	@Id
	@ManyToOne
	@JoinColumn(name="arma_id", insertable = false, updatable = false)
	private Arma arma;
	
	private String uso_arma;
	
	public PersonajeArma() {
		
	}

	public PersonajeArma(Personaje personaje, Arma arma) {
		this.personaje = personaje;
		this.arma = arma;
	}
	
	public PersonajeArma(Personaje personaje, Arma arma, String uso_arma) {
		this.personaje = personaje;
		this.arma = arma;
		this.uso_arma = uso_arma;
	}

	public Personaje getPersonaje() {
		return personaje;
	}
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public String getUso_arma() {
		return uso_arma;
	}
	public void setUso_arma(String uso_arma) {
		this.uso_arma = uso_arma;
	}

	@Override
	public String toString() {
		return "PersonajeArma [" + arma + ", uso_arma=" + uso_arma + "]";
	}
}