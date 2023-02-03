package com.masemoel.hibernate.adattema3_3explicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.TypedQuery;

public class App {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Cliente cli1 = new Cliente();
		cli1.setDni(11111111);
		cli1.setNombre("Pepe");
		cli1.setApellido("García");
		cli1.setBaja(false);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, 2, 22);
		cli1.setFechaNacimiento(calendar.getTime());

		Cliente cli2 = new Cliente();
		cli2.setDni(22222222);
		cli2.setNombre("María");
		cli2.setApellido("Hernández");
		cli2.setBaja(true);
		calendar.set(1995, 9, 25);
		cli2.setFechaNacimiento(calendar.getTime());

		Prestamo pres1 = new Prestamo();
		Date date;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse("27/01/2022");
			pres1.setFecha(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pres1.setMonto(20000);
		pres1.setInteres(3);
		pres1.setCuotas(20);

		Prestamo pres2 = new Prestamo();
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse("02/01/2023");
			pres2.setFecha(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pres2.setMonto(44000);
		pres2.setInteres(2);
		pres2.setCuotas(44);

		cli1.addPrestamo(pres1);
		cli2.addPrestamo(pres2);

		Session sesion = HibernateUtil.getCurrentSesion();
		sesion.beginTransaction();
		sesion.persist(cli1);
		sesion.persist(cli2);
		//sesion.delete(seg1);
		sesion.getTransaction().commit();
		
		//// Ejemplo 1: consultas sencillas
		// Consulta 1 - consulta básica
		Query query = HibernateUtil.getCurrentSesion().createQuery("SELECT cli FROM Cliente cli");
		ArrayList<Cliente> lista_c = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 1...");
		System.out.println("LISTADO DE TODOS LOS CLIENTES:");
		System.out.println("==============================");
		for (Cliente c: lista_c) {
			System.out.println(c);
		}
		
		// Consulta 2 - selección de algunas propiedades
		query = HibernateUtil.getCurrentSesion().createQuery("SELECT cli.dni, cli.nombre, cli.apellido FROM Cliente cli");
		ArrayList<Object[]> listacampos= (ArrayList) query.getResultList();
		System.out.println("\nConsulta 2...");
		System.out.println("LISTADO DE TODOS LOS CLIENTES:");
		System.out.println("==============================");
		for (Object[] o: listacampos) {
			System.out.println(o[0] + ", " + o[1] + ", " +o[2]);
		}
		
		//// Ejemplo 2: consultas sencillas con condiciones
		// Consulta 3 - consulta con condiciones
		Query query2 = HibernateUtil.getCurrentSesion().createQuery("SELECT cli FROM Cliente cli WHERE cli.baja=true");
		lista_c = (ArrayList) query2.getResultList();
		System.out.println("\nConsulta 3...");
		System.out.println("LISTADO DE TODOS LOS CLIENTES CON baja=true:");
		System.out.println("============================================");
		for (Cliente c: lista_c) {
			System.out.println(c);
		}
		
		//// Ejemplo 3: consultas con parámetros dinámicos
		// Consulta 4 - consulta con parámetros dinámicos
		Query query3 = sesion.createQuery("SELECT cli FROM Cliente cli WHERE cli.dni= :userdni");
		query3.setParameter("userdni", 22222222);
		lista_c = (ArrayList) query3.getResultList();
		System.out.println("\nConsulta 4...");
		System.out.println("LISTADO DE TODOS LOS CLIENTES CON dni=22222222:");
		System.out.println("===============================================");
		for (Cliente c: lista_c) {
			System.out.println(c);
		}
		
		//// Ejemplo 4: consulta con parámetros dinámicos y ordenación
		// Consulta 5 - consulta con parámetros dinámicos y ordenación
		query3 = HibernateUtil.getCurrentSesion().createQuery("SELECT p FROM Prestamo p WHERE p.monto BETWEEN ?1 and ?2 ORDER BY p.fecha DESC");
		query3.setParameter(1, 30000);
		query3.setParameter(2, 50000);
		ArrayList<Prestamo> lista_p = (ArrayList) query3.getResultList();
		System.out.println("\nConsulta 5...");
		System.out.println("LISTADO DE TODOS LOS PRÉSTAMOS CON monto entre 30000 y 50000");
		System.out.println("============================================================");
		for (Prestamo p: lista_p) {
			System.out.println(p);
		}
		
		//// Ejemplo 5: consulta con un único resultado
		// Consulta 6 - consulta con un único resultado
		Query query4 = HibernateUtil.getCurrentSesion().createQuery("SELECT COUNT(c) FROM Cliente c");
		long count = (long) query4.getSingleResult();
		System.out.println("\nConsulta 6...");
		System.out.println("CANTIDAD DE CLIENTES DE LA BASE DE DATOS");
		System.out.println("========================================");
		System.out.println(count);
		
		// Consulta 7 - consulta con el valor más alto
		query4 = HibernateUtil.getCurrentSesion().createQuery("SELECT MAX(p.monto) FROM Prestamo p");
		double maxAmount = (double) query4.getSingleResult();
		System.out.println("\nConsulta 7...");
		System.out.println("MONTO MÁS ALTO DE TODA LA BASE DE DATOS");
		System.out.println("=======================================");
		System.out.println(maxAmount);
		
		//// Ejemplo 6: selección con subconsultas
		// Consulta 8 - selección con subconsultas
		Query query5 = HibernateUtil.getCurrentSesion().createQuery("SELECT p2.id, p2.monto FROM Prestamo p2 WHERE p2.monto > (SELECT MIN(p.monto) FROM Prestamo p)");
		List<Object[]> lista6 = (ArrayList) query5.getResultList();
		System.out.println("\nConsulta 8...");
		System.out.println("LISTADO MONTOS CON VALORES SUPERIORES AL MÍNIMO");
		System.out.println("===============================================");
		for (Object[] o: lista6) {
			System.out.println(o[0] + ", " + o[1]);
		}
		
		//// Ejemplo 7: join
		// Consulta 9 - join (clientes con sus préstamos)
		Query query6 = sesion.createQuery("SELECT c FROM Cliente c LEFT JOIN FETCH c.prestamos");
		lista_c = (ArrayList) query6.getResultList();
		System.out.println("\nConsulta 9...");
		System.out.println("LISTADO DE CLIENTES Y SUS PRÉSTAMOS");
		System.out.println("===================================");
		for (Cliente c: lista_c) {
			System.out.println(c);
		}
		
		// Consulta 10 - join (clientes con sus préstamos + parámetros)
		TypedQuery<Cliente> query7 = sesion.createQuery("SELECT c FROM Cliente as c INNER JOIN FETCH c.prestamos AS p where p.idPrestamo = :prestamo", Cliente.class);
		query7.setParameter("prestamo", 2);
		lista_c = (ArrayList) query7.getResultList();
		System.out.println("\nConsulta 10...");
		System.out.println("LISTADO DE CLIENTES Y EL PRÉSTAMO DEL PARÁMETRO");
		System.out.println("===============================================");
		for (Cliente c: lista_c) {
			System.out.println(c);
		}
		
		//// Ejemplo 8: consulta nativa
		// Consulta 11 - consulta nativa
		List<Object[]> lista8 = (List) sesion.createNativeQuery("SELECT dni, nombre, apellido FROM Cliente").getResultList();
		System.out.println("\nConsulta 11...");
		System.out.println("LISTADO DE DNI, NOMBRE Y APELLIDOS DE LOS CLIENTES");
		System.out.println("==================================================");
		for (Object[] o: lista8) {
			System.out.println(o[0] + ", " + o[1] + ", " + o[2]);
		}
		
		//// Ejemplo 9: DML
		// Consulta 12 - DML
		//// UPDATE
		// Incrementamos un 10% el monto de los préstamos
		sesion.beginTransaction();
		int numUpdateResult = (int) sesion.createQuery("UPDATE Prestamo p SET p.monto = p.monto * 1.1").executeUpdate();
		sesion.getTransaction().commit();
		System.out.println("\nConsulta 12...");
		System.out.println("NÚMERO DE REGISTROS AFECTADOS (monto * 1.1");
		System.out.println("==========================================");
		System.out.println(numUpdateResult);
		//// DELETE
		// Incrementamos un 10% el monto de todos los préstamos
		sesion.beginTransaction();
		numUpdateResult = (int) sesion.createQuery("DELETE FROM Prestamo p WHERE p.idPrestamo = :idpr").setParameter("idpr", 2).executeUpdate();
		sesion.getTransaction().commit();
		System.out.println("\nConsulta 13...");
		System.out.println("NÚMERO DE REGISTROS AFECTADOS (prestamo eliminado con id=1)");
		System.out.println("===========================================================");
		System.out.println(numUpdateResult);
		
		//// Ejemplo 10: consultas con nombre
		// Consulta 14 - consultas con nombre
		Query query8 = sesion.createNamedQuery("Cliente.findByNombre");
		query8.setParameter("name", "%a");
		lista_c = (ArrayList) query8.getResultList();
		System.out.println("\nConsulta 14...");
		System.out.println("LISTADO DE CLIENTES CUYO NOMBRE TERMINE EN a");
		System.out.println("============================================");
		for (Cliente c: lista_c) {
			System.out.println(c);
		}
		
		sesion.close();
		HibernateUtil.closeSessionFactory();
	}
}