package com.masemoel.hibernate.adattema3_3explicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class VistaPrestamos {
	public void mostrarPrestamos() {
		PrestamoDAOHibernate presdao = PrestamoDAOHibernate.getInstance();
		ArrayList<Prestamo> lista_p = presdao.findAll();
		for (Prestamo p: lista_p) {
			mostrarPrestamo(p);
		}
	}
	
	public void mostrarPrestamo(Prestamo p) {
		System.out.println(p);
	}
	
	public Prestamo pideDatos() {
		Prestamo p = new Prestamo();
		Date f;
		double monto, interes;
		int cant;
		try {
			monto = Double.parseDouble(JOptionPane.showInputDialog("Monto"));
			interes = Double.parseDouble(JOptionPane.showInputDialog("Interés"));
			cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de cuotas"));
		} catch (Exception e) {
			System.out.println("Datos incorrectos. Saliendo...");
			return p;
		}
		String fecha = JOptionPane.showInputDialog("Fecha del préstamo (dd/MM/yyyy)");
		
		try {
			f = new SimpleDateFormat ("dd/MM/yyyy").parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Fecha incorrecta. Saliendo...");
			return p;
		}
		p.setFecha(f);
		p.setMonto(monto);
		p.setInteres(interes);
		p.setCuotas(cant);
		return p;
	}
}