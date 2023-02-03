package com.masemoel.hibernate.adattema3_2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.TypedQuery;

public class App {
	public static void main(String[] args) {
		// Comenzar la sesión
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		// Inicializar los objetos
		Seguro seg1 = new Seguro();
		seg1.setIdSeguro(1);
		seg1.setNif("12345678S");
		seg1.setNombre("Manuel José");
		seg1.setApe1("Primero");
		seg1.setApe2("Segundo");
		seg1.setEdad(88);
		seg1.setNumHijos(0);
		seg1.setAlergia("Polen del olivo");
		seg1.setFechaCreacion(new java.util.Date());

		Seguro seg2 = new Seguro();
		seg2.setIdSeguro(2);
		seg2.setNif("17769116T");
		seg2.setNombre("Pepe");
		seg2.setApe1("Ramírez");
		seg2.setApe2("Tango");
		seg2.setEdad(18);
		seg2.setNumHijos(4);
		seg2.setAlergia(null);
		seg2.setFechaCreacion(new java.util.Date());

		AsistenciaMedica asis1 = new AsistenciaMedica();
		asis1.setIdAsistenciaMedica(1);
		asis1.setLugar("Jaén");
		asis1.setBreveDescripcion("Seguro para personas de tercera edad.");
		asis1.setImporte(15000);

		AsistenciaMedica asis2 = new AsistenciaMedica();
		asis2.setIdAsistenciaMedica(2);
		asis2.setLugar("Andalucía");
		asis2.setBreveDescripcion("Seguro para personas con hijos.");
		asis2.setImporte(4000);

		seg1.addAsistencia(asis1);
		seg1.addAsistencia(asis2);
		seg2.addAsistencia(asis2);

		Session sesion = HibernateUtil.getCurrentSesion();
		sesion.beginTransaction();
		sesion.persist(seg1);
		sesion.persist(seg2);
		
		//// TAREA 3
		// 1. Listado de todos los seguros almaceandos
		Query query = sesion.createQuery("SELECT s FROM Seguro s");
		ArrayList<Seguro> lista_s = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 1...");
		System.out.println("LISTADO DE TODOS LOS SEGUROS:");
		System.out.println("=============================");
		for (Seguro s: lista_s) {
			System.out.println(s);
		}
		
		// 2. Listado de todos los seguros con las columnas NIF y nombre
		query = HibernateUtil.getCurrentSesion().createQuery("SELECT s.nif, s.nombre FROM Seguro s");
		ArrayList<Object[]> lista_o = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 2...");
		System.out.println("LISTADO DE TODOS LOS SEGUROS:");
		System.out.println("=============================");
		for (Object[] o: lista_o) {
			System.out.println(o[0] + ", " + o[1]);
		}
		
		// 3. Listado de todos los seguros con la columna NIF
		query = sesion.createQuery("SELECT s.nif FROM Seguro s");
		ArrayList<String> lista_st = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 3...");
		System.out.println("LISTADO DE TODOS LOS SEGUROS:");
		System.out.println("=============================");
		for (String o: lista_st) {
			System.out.println(o);
		}
		
		// 4. Listado del NIF del seguro a nombre, apellido1 y apellido2
		query = sesion.createQuery("SELECT s.nif FROM Seguro s WHERE s.nombre= :nom AND ape1 = :ape1 AND ape2 = :ape2"); 
		query.setParameter("nom", "Pepe");
		query.setParameter("ape1", "Ramírez");
		query.setParameter("ape2", "Tango");
		lista_st = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 4...");
		System.out.println("LISTADO DE TODOS LOS SEGUROS A NOMBRE DE MARCOS:");
		System.out.println("================================================");
		for (String o: lista_st) {
			System.out.println(o);
		}
		
		// 5. Listado con las asistencias médicas cuyo importe > 10.000€
		query = sesion.createQuery("SELECT a FROM AsistenciaMedica a WHERE a.importe >= 10000"); 
		ArrayList<AsistenciaMedica> lista_a = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 5...");
		System.out.println("LISTADO DE TODAS LAS ASISTENCIAS > 10000€:");
		System.out.println("==========================================");
		for (AsistenciaMedica a: lista_a) {
			System.out.println(a);
		}
		
		// 6. Listado del importe de las asistencias médicas cuyo importe > 10.000€
		query = sesion.createQuery("SELECT a.importe FROM AsistenciaMedica a WHERE a.importe >= 10000"); 
		ArrayList<Integer> lista_i = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 6...");
		System.out.println("LISTADO DE TODAS LAS ASISTENCIAS > 10000€:");
		System.out.println("==========================================");
		for (Integer i: lista_i) {
			System.out.println(i);
		}
		
		// 7. Listado del id de las asistencias médicas cuyo importe entre 2000 y 5000
		query = sesion.createQuery("SELECT a.idAsistenciaMedica FROM AsistenciaMedica a WHERE a.importe BETWEEN 2000 AND 5000"); 
		lista_i = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 7...");
		System.out.println("LISTADO DE TODAS LAS ASISTENCIAS entre 2000 y 5000€:");
		System.out.println("====================================================");
		for (Integer i: lista_i) {
			System.out.println(i);
		}
		
		// 8. Suma del importe de todas las asistencias médicas
		query = sesion.createQuery("SELECT SUM(a.importe) FROM AsistenciaMedica a"); 
		long resultado = (long) query.getSingleResult();
		System.out.println("\nConsulta 8...");
		System.out.println("SUMA DEL IMPORTE DE TODAS LAS ASISTENCIAS MÉDICAS:");
		System.out.println("==================================================");
		System.out.println(resultado);
		
		// 9. Media del importe de todas las asistencias médicas
		query = sesion.createQuery("SELECT AVG(a.importe) FROM AsistenciaMedica a"); 
		double resultado2 = (double) query.getSingleResult();
		System.out.println("\nConsulta 9...");
		System.out.println("MEDIA DEL IMPORTE DE TODAS LAS ASISTENCIAS MÉDICAS:");
		System.out.println("===================================================");
		System.out.println(resultado2);
		
		// 10. Número de seguros almacenados en total
		query = sesion.createQuery("SELECT COUNT(s.idSeguro) FROM Seguro s");
		resultado = (long) query.getSingleResult();
		System.out.println("\nConsulta 10...");
		System.out.println("NÚMERO DE SEGUROS ALMACENADOS:");
		System.out.println("==============================");
		System.out.println(resultado);
		
		// 11. Número de asistencias asociadas a cada seguro
		query = sesion.createQuery("SELECT a.seguro, COUNT(a.seguro) FROM AsistenciaMedica a JOIN a.seguro GROUP BY a.seguro");
		lista_o = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 11...");
		System.out.println("NÚMERO DE ASISTENCIAS POR SEGURO:");
		System.out.println("=================================");
		for (Object[] o: lista_o) {
			System.out.println(o[1] + ", " + o[0]);
		}
		
		// 12. Listado de alergias de cada seguro
		query = sesion.createQuery("SELECT s2.nif, s2.alergia FROM Seguro s2");
		lista_o = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 12...");
		System.out.println("LISTADO DE ALERGIAS DE CADA SEGURO:");
		System.out.println("===================================");
		for (Object[] o: lista_o) {
			System.out.println(o[0] + ": " + o[1]);
		}
		 
		// 13. Listado de seguros con un número de hijos parametrizado
		query = sesion.createQuery("SELECT s.id FROM Seguro s WHERE s.numHijos= :hijosnum");
		query.setParameter("hijosnum", 4);
		lista_i = (ArrayList) query.getResultList();
		System.out.println("\nConsulta 13...");
		System.out.println("LISTADO DE ID DE SEGUROS CON UN NÚMERO DE HIJOS PARAMETRIZADO:");
		System.out.println("==============================================================");
		for (Integer i: lista_i) {
			System.out.println(i);
		}
		
		// 14. Listado de NIF de seguros cuya edad > 40
		lista_st = (ArrayList) sesion.createNativeQuery("SELECT s.nif FROM Seguro s WHERE s.edad > 40").getResultList();
		System.out.println("\nConsulta 14...");
		System.out.println("LISTADO DE NIF DE SEGUROS CUYA EDAD > 40:");
		System.out.println("=========================================");
		for (String s: lista_st) {
			System.out.println(s);
		}
				
		// Finalizar la sesión
		sesion.getTransaction().commit();
		sesion.close();
		HibernateUtil.closeSessionFactory();
	}
}