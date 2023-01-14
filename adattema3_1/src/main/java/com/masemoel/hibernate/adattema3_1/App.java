package com.masemoel.hibernate.adattema3_1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		
		Seguro seguro = new Seguro();
		seguro.setIdSeguro(1);
		seguro.setNif("77691163S");
		seguro.setNombre("Manuel José");
		seguro.setApe1("Moral");
		seguro.setApe2("Eliche");
		seguro.setEdad(19);
		seguro.setNumHijos(0);
		seguro.setFechaCreacion(new java.util.Date());
		
		insert(seguro);

		List<Seguro> busq = findAll();
		for (Seguro se: busq) {
			System.out.println(se);
		}

		HibernateUtil.closeSessionFactory();
	}
	
	public static void insert(Seguro seguro) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.persist(seguro);
		ses.getTransaction().commit();
	}
	
	public static List<Seguro> findAll() {
		Query query = HibernateUtil.getCurrentSesion().createQuery("FROM Seguro");
		ArrayList<Seguro> lista_se = (ArrayList<Seguro>) query.list();
		return lista_se;
	}
	
	public static void update(Seguro seguro) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.update(seguro);
		ses.getTransaction().commit();
	}
	
	public static void delete(Seguro seguro) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.delete(seguro);
		ses.getTransaction().commit();
	}
}