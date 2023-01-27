package com.masemoel.hibernate.adattema3_2explicacion;

import java.io.Serializable;

public class PersonajeArmaId implements Serializable {
	private int arma;
	private int personaje;
	
	public PersonajeArmaId() {
		
	}

	public int getArma() {
		return arma;
	}

	public void setArma(int arma) {
		this.arma = arma;
	}

	public int getPersonaje() {
		return personaje;
	}

	public void setPersonaje(int personaje) {
		this.personaje = personaje;
	}

	@Override
	public String toString() {
		return "PersonajeArmaId [arma=" + arma + ", personaje=" + personaje + "]";
	}
}