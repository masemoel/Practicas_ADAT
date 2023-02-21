package com.masemoel.hibernate.adattema3_3explicacion;

import java.util.ArrayList;

import org.hibernate.Session;

import jakarta.persistence.Query;

public class ProductosDAOHibernate {
	private static ProductosDAOHibernate instance = null;
	
	public ProductosDAOHibernate() {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
	}
	
	public static ProductosDAOHibernate getInstance() {
		if (instance == null) {
			instance = new ProductosDAOHibernate();
		}
		return instance;
	}
	
	public void insert (Productos producto) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.persist(producto);
		ses.getTransaction().commit();
	}
	
	public ArrayList<Productos> findAll() {
		Query query = HibernateUtil.getCurrentSesion().createQuery("FROM Productos");
		ArrayList<Productos> lista_p = (ArrayList) query.getResultList();
		return lista_p;
	}
	
	public Productos findByPk(int id) {
		Productos producto = HibernateUtil.getCurrentSesion().get(Productos.class, id);
		return producto;
	}
	
	public void update(Productos producto) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.merge(producto);
		ses.getTransaction().commit();
	}
	
	public void delete(Productos producto) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.remove(producto);
		ses.getTransaction().commit();
	}
	
	public void closeDAO() {
		HibernateUtil.closeSessionFactory();
	}
}