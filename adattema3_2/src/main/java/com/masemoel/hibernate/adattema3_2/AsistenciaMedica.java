package com.masemoel.hibernate.adattema3_2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="asistenciamedica")
public class AsistenciaMedica {
	@Id
	private int idAsistenciaMedica;
	
	private String lugar, breveDescripcion;
	
	@ManyToOne
	private Seguro seguro;
	
	public AsistenciaMedica() {
		
	}

	public AsistenciaMedica(int idAsistenciaMedica, String lugar, String breveDescripcion) {
		super();
		this.idAsistenciaMedica = idAsistenciaMedica;
		this.lugar = lugar;
		this.breveDescripcion = breveDescripcion;
	}

	public int getIdAsistenciaMedica() {
		return idAsistenciaMedica;
	}
	public void setIdAsistenciaMedica(int idAsistenciaMedica) {
		this.idAsistenciaMedica = idAsistenciaMedica;
	}

	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getBreveDescripcion() {
		return breveDescripcion;
	}
	public void setBreveDescripcion(String breveDescripcion) {
		this.breveDescripcion = breveDescripcion;
	}

	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	@Override
	public String toString() {
		return "Asistencia médica [id asistencia médica=" + idAsistenciaMedica + ", lugar=" + lugar + " y breve descripción=" + breveDescripcion + "]";
	}
}