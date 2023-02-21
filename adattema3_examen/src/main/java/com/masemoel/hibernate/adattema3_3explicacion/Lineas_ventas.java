package com.masemoel.hibernate.adattema3_3explicacion;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(Lineas_ventasId.class)
public class Lineas_ventas {
	@Id
	@ManyToOne
	@JoinColumn(name="n_venta", insertable = false, updatable = false)
	private Ventas ventas;
	
	@Id
	@ManyToOne
	@JoinColumn(name="n_producto", insertable = false, updatable = false)
	private Productos productos;
	
	private int cantidad;
	
	public Lineas_ventas() {
		
	}

	public Lineas_ventas(Ventas ventas, Productos productos) {
		this.ventas = ventas;
		this.productos = productos;
	}

	public Lineas_ventas(Ventas ventas, Productos productos, int cantidad) {
		this.ventas = ventas;
		this.productos = productos;
		this.cantidad = cantidad;
	}

	public Ventas getVentas() {
		return ventas;
	}
	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}

	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Lineas_ventas [ventas=" + ventas + ", productos=" + productos + ", cantidad=" + cantidad + "]";
	}
}