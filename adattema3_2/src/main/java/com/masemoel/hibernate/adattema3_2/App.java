package com.masemoel.hibernate.adattema3_2;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Seguro seg1 = new Seguro();
		seg1.setIdSeguro(1);
		seg1.setNif("12345678S");
		seg1.setNombre("Manuel José");
		seg1.setApe1("Primero");
		seg1.setApe2("Segundo");
		seg1.setEdad(88);
		seg1.setNumHijos(0);
		seg1.setFechaCreacion(new java.util.Date());

		AsistenciaMedica asis1 = new AsistenciaMedica();
		asis1.setIdAsistenciaMedica(1);
		asis1.setLugar("Jaén");
		asis1.setBreveDescripcion("Seguro para personas de tercera edad.");

		AsistenciaMedica asis2 = new AsistenciaMedica();
		asis2.setIdAsistenciaMedica(2);
		asis2.setLugar("Andalucía");
		asis2.setBreveDescripcion("Seguro para personas con hijos.");

		seg1.addAsistencia(asis1);
		seg1.addAsistencia(asis2);

		Session sesion = HibernateUtil.getCurrentSesion();
		sesion.beginTransaction();
		sesion.persist(seg1);
		//sesion.delete(seg1);

		Query query = HibernateUtil.getCurrentSesion().createQuery("FROM Seguro seg");
		ArrayList<Seguro> lista_s = (ArrayList) query.list();
		for (Seguro s: lista_s) {
			System.out.println(s);
		}
		
		sesion.getTransaction().commit();
		sesion.close();
		HibernateUtil.closeSessionFactory();
	}
}