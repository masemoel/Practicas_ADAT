package com.masemoel.hibernate.adattema3_3explicacion;

import java.util.ArrayList;

import org.hibernate.Session;

import jakarta.persistence.Query;

public class LibroDAOHibernate {
private static LibroDAOHibernate instance = null;
	
	public LibroDAOHibernate() {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
	}
	
	public static LibroDAOHibernate getInstance() {
		if (instance == null) {
			instance = new LibroDAOHibernate();
		}
		return instance;
	}
	
	public void insert (Libro libro) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.persist(libro);
		ses.getTransaction().commit();
	}
	
	public ArrayList<Libro> findAll() {
		Query query = HibernateUtil.getCurrentSesion().createQuery("FROM Libro");
		ArrayList<Libro> lista_l = (ArrayList) query.getResultList();
		return lista_l;
	}
	
	public Libro findByPk(int id) {
		Libro libro = HibernateUtil.getCurrentSesion().get(Libro.class, id);
		return libro;
	}
	
	public void update(Libro libro) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.merge(libro);
		ses.getTransaction().commit();
	}
	
	public void delete(Libro libro) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.remove(libro);
		ses.getTransaction().commit();
	}
	
	public void closeDAO() {
		HibernateUtil.closeSessionFactory();
	}
}