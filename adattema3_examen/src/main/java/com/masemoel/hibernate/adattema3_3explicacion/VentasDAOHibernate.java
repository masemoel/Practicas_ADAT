package com.masemoel.hibernate.adattema3_3explicacion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.Query;

public class VentasDAOHibernate {
private static VentasDAOHibernate instance = null;
	
	public VentasDAOHibernate() {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
	}
	
	public static VentasDAOHibernate getInstance() {
		if (instance == null) {
			instance = new VentasDAOHibernate();
		}
		return instance;
	}
	
	public void insert (Ventas venta) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.persist(venta);
		ses.getTransaction().commit();
	}
	
	public List<Ventas> findAll() {
		Query query = HibernateUtil.getCurrentSesion().createQuery("FROM Ventas");
		ArrayList<Ventas> lista_v = (ArrayList) query.getResultList();
		return lista_v;
	}
	
	public Ventas findByPk(int id) {
		Ventas venta = HibernateUtil.getCurrentSesion().get(Ventas.class, id);
		return venta;
	}
	
	public void update(Ventas venta) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.merge(venta);
		ses.getTransaction().commit();
	}
	
	public void delete(Ventas venta) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.remove(venta);
		ses.getTransaction().commit();
	}
	
	public void closeDAO() {
		HibernateUtil.closeSessionFactory();
	}
}