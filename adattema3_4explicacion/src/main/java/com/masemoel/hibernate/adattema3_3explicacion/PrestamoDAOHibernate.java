package com.masemoel.hibernate.adattema3_3explicacion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.Query;

public class PrestamoDAOHibernate {
	private static PrestamoDAOHibernate instance = null;
	
	public PrestamoDAOHibernate() {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
	}
	
	public static PrestamoDAOHibernate getInstance() {
		if (instance == null) {
			instance = new PrestamoDAOHibernate();
		}
		return instance;
	}
	
	public void insert (Prestamo prestamo) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.persist(prestamo);
		ses.getTransaction().commit();
	}
	
	public ArrayList<Prestamo> findAll() {
		Query query = HibernateUtil.getCurrentSesion().createQuery("FROM Prestamo");
		ArrayList<Prestamo> lista_p = (ArrayList) query.getResultList();
		return lista_p;
	}
	
	public Prestamo findByPk(int id) {
		Prestamo prestamo = HibernateUtil.getCurrentSesion().get(Prestamo.class, id);
		return prestamo;
	}
	
	public void update(Prestamo prestamo) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.merge(prestamo);
		ses.getTransaction().commit();
	}
	
	public void delete(Prestamo prestamo) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.remove(prestamo);
		ses.getTransaction().commit();
	}
	
	public void closeDAO() {
		HibernateUtil.closeSessionFactory();
	}
}