package com.masemoel.hibernate.adattema3_3explicacion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class VistaProductos {
	public void mostrarProductos() {
		ProductosDAOHibernate prodao = ProductosDAOHibernate.getInstance();
		ArrayList<Productos> lista_p = prodao.findAll();
		for (Productos p: lista_p) {
			mostrarProducto(p);
		}
	}
	
	public void mostrarProducto(Productos p) {
		System.out.println(p);
	}
	
	public int pideCodigo() {
		int id = 0;
		id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el id de producto"));
		return id;
	}
	
	public Productos pideDatos() {
		Productos p = new Productos();		
		String descripcion;
		double precio_unidad;
		int n_producto, n_proveedor, stock;
		try {
			n_producto = Integer.parseInt(JOptionPane.showInputDialog("Id de producto"));
			descripcion = JOptionPane.showInputDialog("Descripcion");
			precio_unidad = Double.parseDouble(JOptionPane.showInputDialog("Precio por unidad"));
			n_proveedor = Integer.parseInt(JOptionPane.showInputDialog("Id del proveedor"));
			stock = Integer.parseInt(JOptionPane.showInputDialog("Stock"));
		} catch (Exception e) {
			System.out.println("Datos incorrectos. Saliendo...");
			return p;
		}
		p.setN_producto(n_producto);
		p.setDescripcion(descripcion);
		p.setPrecio_unidad(precio_unidad);
		p.setN_proveedor(n_proveedor);
		p.setStock(stock);		
		return p;
	}
}