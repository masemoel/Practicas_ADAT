package com.masemoel.hibernate.adattema3_3explicacion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.Query;

public class ClienteDAOHibernate {
	private static ClienteDAOHibernate instance = null;
	
	public ClienteDAOHibernate() {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
	}
	
	public static ClienteDAOHibernate getInstance() {
		if (instance == null) {
			instance = new ClienteDAOHibernate();
		}
		return instance;
	}
	
	public void insert (Cliente cliente) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.persist(cliente);
		ses.getTransaction().commit();
	}
	
	public List<Cliente> findAll() {
		Query query = HibernateUtil.getCurrentSesion().createQuery("FROM Cliente");
		ArrayList<Cliente> lista_c = (ArrayList) query.getResultList();
		return lista_c;
	}
	
	public Cliente findByPk(int id) {
		Cliente cliente = HibernateUtil.getCurrentSesion().get(Cliente.class, id);
		return cliente;
	}
	
	public void update(Cliente cliente) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.merge(cliente);
		ses.getTransaction().commit();
	}
	
	public void delete(Cliente cliente) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.remove(cliente);
		ses.getTransaction().commit();
	}
	
	public void closeDAO() {
		HibernateUtil.closeSessionFactory();
	}
}