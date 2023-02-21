package com.masemoel.hibernate.adattema3_3explicacion;

import javax.swing.JOptionPane;

public class Controlador {
	ProductosDAOHibernate prodao = ProductosDAOHibernate.getInstance();
	VentasDAOHibernate vendao = VentasDAOHibernate.getInstance();
	VistaProductos vistapro = new VistaProductos();
	VistaVentas vistaven = new VistaVentas();
	
	public void insertarVen() {
		Ventas ven = vistaven.pideDatos();
		vendao.insert(ven);
		vistaven.mostrarVentas();
	}
	
	public void actualizarVen() {
		Ventas ven = null;
		vistaven.mostrarVentas();
		int id = vistaven.pideCodigo();
		ven = vendao.findByPk(id);
		if (ven == null) {
			System.out.println("No se ha encontrado una venta con código "+id);
		} else {
			Ventas ven2 = vistaven.pideDatos();
			ven2.setN_venta(id);
			vendao.update(ven2);
			vistaven.mostrarVentas();
		}
	}
	
	public void eliminarVen() {
		Ventas ven = null;
		vistaven.mostrarVentas();
		int id = vistaven.pideCodigo();
		ven = vendao.findByPk(id);
		if (ven == null) {
			System.out.println("No se ha encontrado una venta con código "+id);
		} else {
			String conf = JOptionPane.showInputDialog("¿Estás seguro de eliminar dicha venta? 'S' / 'N'");
			if (conf.equalsIgnoreCase("s")) {
				vendao.delete(ven);
				vistaven.mostrarVentas();
			}
		}
	}
	
	public void muestraVentas() {
		vistaven.mostrarVentas();
	}
	
	public void muestraVenta() {
		Ventas ven = null;
		vistaven.mostrarVentas();
		int id = vistaven.pideCodigo();
		ven = vendao.findByPk(id);
		if (ven == null) {
			System.out.println("No se ha encontrado una venta con código "+id);
		} else {
			vistaven.mostrarVenta(ven);
		}
	}
	
	public void insertarPro() {
		Ventas ven = null;
		vistaven.mostrarVentas();
		int id = vistaven.pideCodigo();
		ven = vendao.findByPk(id);
		if (ven == null) {
			System.out.println("No se ha encontrado una venta con código "+id);
		} else {
			Productos p = vistapro.pideDatos();
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad"));
			ven.addProducto(p, cantidad);
			vendao.insert(ven);
			vistaven.mostrarVenta(ven);
		}
	}
	
	public void actualizarPro() {
		Productos pro = null;
		vistaven.mostrarVentas();
		int id = vistaven.pideCodigo();
		pro = prodao.findByPk(id);
		if (pro == null) {
			System.out.println("No se ha encontrado un producto con id "+id);
		} else {
			Productos pro2 = vistapro.pideDatos();
			pro2.setN_producto(id);
			pro2.setVentas(pro.getVentas());
			prodao.update(pro2);
			vistaven.mostrarVentas();
		}
	}
	
	public void eliminarPro() { // WIP
		Productos pro = null;
		vistaven.mostrarVentas();
		int id = vistaven.pideCodigo();
		pro = prodao.findByPk(id);
		if (pro == null) {
			System.out.println("No se ha encontrado un producto con id "+id);
		} else {
			String conf = JOptionPane.showInputDialog("¿Estás seguro de eliminar dicho producto? 'S' / 'N'");
			if (conf.equalsIgnoreCase("s")) {
				Ventas ven; // pro.getVentas()
				//ven.removeProducto(pro); // TODO: should send a list instead of a single pro object
				prodao.delete(pro);
				vistaven.mostrarVentas();
			}
		}
	}
	
	public void muestraProductos() {
		vistapro.mostrarProductos();
	}
	
	public void muestraProducto() {
		Productos pro = null;
		int id = vistapro.pideCodigo();
		pro = prodao.findByPk(id);
		if (pro == null) {
			System.out.println("No se ha encontrado un producto con código "+id);
		} else {
			vistapro.mostrarProducto(pro);
		}
	}
	
	public void finalizarPrograma() {
		try {
			prodao.closeDAO();
			vendao.closeDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Gracias. ¡Hasta pronto!");
	}
}