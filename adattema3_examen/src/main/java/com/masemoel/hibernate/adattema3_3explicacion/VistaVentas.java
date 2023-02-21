package com.masemoel.hibernate.adattema3_3explicacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class VistaVentas {
	VistaProductos vistapro;
	
	public void mostrarVentas() {
		VentasDAOHibernate audao = VentasDAOHibernate.getInstance();
		List<Ventas> lista_v = audao.findAll();
		for (Ventas v: lista_v) {
			mostrarVenta(v);
		}
	}
	
	public void mostrarVenta(Ventas v) {
		System.out.println(v);
	}
	
	public int pideCodigo() {
		int id = 0;
		id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el id de la venta"));
		return id;
	}
	
	public Ventas pideDatos() {
		Ventas venta = new Ventas();
		int n_venta, n_emple, n_cliente;
		Date fecha;
		try {
			n_venta = Integer.parseInt(JOptionPane.showInputDialog("Número de venta"));
			n_emple = Integer.parseInt(JOptionPane.showInputDialog("Número de empleado"));
			n_cliente = Integer.parseInt(JOptionPane.showInputDialog("Número de cliente"));			
		} catch (Exception e) {
			System.out.println("Datos incorrectos.");
			e.printStackTrace();
			return venta;
		}
		String fechas = JOptionPane.showInputDialog("Fecha de venta (dd/MM/yyyy)");
		try {
			fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechas);
		} catch (Exception e) {
			System.out.println("Fecha incorrecta. Introdúcela con el formato dd/MM/yyyy");
			e.printStackTrace();
			return venta;
		}
		venta.setN_venta(n_venta);
		venta.setN_emple(n_emple);
		venta.setFecha(fecha);
		venta.setN_cliente(n_cliente);
		return venta;
	}
}