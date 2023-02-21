package com.masemoel.hibernate.adattema3_3explicacion;

import java.io.Serializable;

public class Lineas_ventasId implements Serializable {
	private int productos;
	private int ventas;
	
	public Lineas_ventasId() {
		
	}

	public int getProductos() {
		return productos;
	}

	public void setProductos(int productos) {
		this.productos = productos;
	}

	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "Lineas_ventasId [producto=" + productos + ", venta=" + ventas + "]";
	}
}