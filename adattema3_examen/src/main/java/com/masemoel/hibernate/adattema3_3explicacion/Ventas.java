package com.masemoel.hibernate.adattema3_3explicacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ventas {
	@Id
	private int n_venta;
	
	private int n_emple, n_cliente;
	private Date fecha;
	
	@OneToMany(mappedBy = "ventas", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Lineas_ventas> productos = new ArrayList<>();
	
	public Ventas() {
		
	}

	public Ventas(int n_venta, int n_emple, int n_cliente, Date fecha, List<Lineas_ventas> productos) {
		this.n_venta = n_venta;
		this.n_emple = n_emple;
		this.n_cliente = n_cliente;
		this.fecha = fecha;
		this.productos = productos;
	}

	public int getN_venta() {
		return n_venta;
	}
	public void setN_venta(int n_venta) {
		this.n_venta = n_venta;
	}

	public int getN_emple() {
		return n_emple;
	}
	public void setN_emple(int n_emple) {
		this.n_emple = n_emple;
	}

	public int getN_cliente() {
		return n_cliente;
	}
	public void setN_cliente(int n_cliente) {
		this.n_cliente = n_cliente;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Lineas_ventas> getProductos() {
		return productos;
	}
	public void setProductos(List<Lineas_ventas> productos) {
		this.productos = productos;
	}

//  TODO: figure out why this toString throws StackOverFlow error
//	@Override
//	public String toString() {
//		return "Ventas [n_venta=" + n_venta + ", n_emple=" + n_emple + ", n_cliente=" + n_cliente + ", fecha=" + fecha + ", productos=" + productos + "]";
//	}

	public void addProducto(Productos producto, int cantidad) {		
		Lineas_ventas lv = new Lineas_ventas(this, producto, cantidad);
		productos.add(lv);
		producto.getVentas().add(lv);
	}
	
	public void removeProducto(Productos producto) {
		Lineas_ventas lv = new Lineas_ventas(this, producto);
		producto.getVentas().remove(lv);
		productos.remove(lv);
	}
}