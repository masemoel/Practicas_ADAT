package com.masemoel.hibernate.adattema3_2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="seguro")
public class Seguro {
	@Id
	private int idSeguro;
	
	private String nif, nombre, ape1, ape2;
	private int edad, numHijos;
	private Date fechaCreacion;
	
	@OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AsistenciaMedica> asistencias = new ArrayList<>();
	
	public Seguro() {
		
	}

	public Seguro(int idSeguro, String nif, String nombre, String ape1, String ape2, int edad, int numHijos, Date fechaCreacion) {
		this.idSeguro = idSeguro;
		this.nif = nif;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.edad = edad;
		this.numHijos = numHijos;
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}
	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}
	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNumHijos() {
		return numHijos;
	}
	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<AsistenciaMedica> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<AsistenciaMedica> asistencias) {
		this.asistencias = asistencias;
	}

	@Override
	public String toString() {
		return "Seguro [Id seguro=" + idSeguro + ", NIF=" + nif + ", nombre=" + nombre + ", apellido 1=" + ape1 + ", apellido 2=" + ape2 + ", edad=" + edad + ", número de hijos=" + numHijos + ", fecha de creación=" + fechaCreacion + " y " + asistencias + "]";
	}
	
	public void addAsistencia(AsistenciaMedica asistencia) {
		asistencias.add(asistencia);
		asistencia.setSeguro(this);
	}
	
	public void removeAsistencia(AsistenciaMedica asistencia) {
		if (asistencias != null) {
			asistencias.remove(asistencia);
			asistencia.setSeguro(null);
		}
	}
}