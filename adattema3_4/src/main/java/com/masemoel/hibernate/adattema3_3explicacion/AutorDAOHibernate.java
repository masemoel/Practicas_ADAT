package com.masemoel.hibernate.adattema3_3explicacion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.Query;

public class AutorDAOHibernate {
	private static AutorDAOHibernate instance = null;
	
	public AutorDAOHibernate() {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
	}
	
	public static AutorDAOHibernate getInstance() {
		if (instance == null) {
			instance = new AutorDAOHibernate();
		}
		return instance;
	}
	
	public void insert (Autor autor) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.persist(autor);
		ses.getTransaction().commit();
	}
	
	public List<Autor> findAll() {
		Query query = HibernateUtil.getCurrentSesion().createQuery("FROM Autor");
		ArrayList<Autor> lista_a = (ArrayList) query.getResultList();
		return lista_a;
	}
	
	public Autor findByPk(String dni) {
		Autor autor = HibernateUtil.getCurrentSesion().get(Autor.class, dni);
		return autor;
	}
	
	public void update(Autor autor) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.merge(autor);
		ses.getTransaction().commit();
	}
	
	public void delete(Autor autor) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.remove(autor);
		ses.getTransaction().commit();
	}
	
	public void closeDAO() {
		HibernateUtil.closeSessionFactory();
	}
}