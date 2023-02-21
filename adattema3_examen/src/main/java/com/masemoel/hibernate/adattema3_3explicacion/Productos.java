package com.masemoel.hibernate.adattema3_3explicacion;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Productos {
	@Id
	private int n_producto;
	
	private String descripcion;
	private double precio_unidad;
	private int n_proveedor, stock;
	
	@OneToMany(mappedBy = "productos", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Lineas_ventas> ventas = new ArrayList<>();
	
	public Productos() {
		
	}

	public Productos(int n_producto, String descripcion, double precio_unidad, int n_proveedor, int stock) {
		this.n_producto = n_producto;
		this.descripcion = descripcion;
		this.precio_unidad = precio_unidad;
		this.n_proveedor = n_proveedor;
		this.stock = stock;
	}

	public int getN_producto() {
		return n_producto;
	}
	public void setN_producto(int n_producto) {
		this.n_producto = n_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio_unidad() {
		return precio_unidad;
	}
	public void setPrecio_unidad(double precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

	public int getN_proveedor() {
		return n_proveedor;
	}
	public void setN_proveedor(int n_proveedor) {
		this.n_proveedor = n_proveedor;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Lineas_ventas> getVentas() {
		return ventas;
	}
	public void setVentas(List<Lineas_ventas> ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "Productos [n_producto=" + n_producto + ", descripcion=" + descripcion + ", precio_unidad=" + precio_unidad + ", n_proveedor=" + n_proveedor + ", stock=" + stock + "]";
	}
}