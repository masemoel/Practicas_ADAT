package com.masemoel.hibernate.adattema3_3explicacion;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Prestamo implements Serializable{
	@Id
	@GeneratedValue
	private int idPrestamo;
	
	private Date fecha;
	private double monto, interes;
	private int cuotas;
	
	@ManyToOne
	private Cliente cliente;
	
	public Prestamo() {
		
	}

	public Prestamo(int idPrestamo, Date fecha, double monto, double interes, int cuotas) {
		super();
		this.idPrestamo = idPrestamo;
		this.fecha = fecha;
		this.monto = monto;
		this.interes = interes;
		this.cuotas = cuotas;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Préstamo [Id préstamo=" + idPrestamo + ", fecha=" + fecha + ", monto=" + monto + ", interés=" + interes + " y cuotas=" + cuotas + "]";
	}
}