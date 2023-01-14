package com.masemoel.hibernate.adattema3_explicacion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		/* SUSTITUÍDO POR MÉTODOS
		 * 
		 * StandardServiceRegistry sr = new
		 * StandardServiceRegistryBuilder().configure().build(); SessionFactory sf = new
		 * MetadataSources(sr).buildMetadata().buildSessionFactory(); Session session =
		 * sf.openSession();
		 * 
		 * Usuario usuario = new Usuario(); usuario.setId(10);
		 * usuario.setNombre("Paco"); usuario.setApellido("García");
		 * usuario.setEdad(34);
		 * 
		 * session.getTransaction().begin(); session.persist(usuario); // session.save
		 * is deprecated session.getTransaction().commit();
		 * 
		 * session.close(); sr.close();
		 */
		
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		
		Usuario usuario = new Usuario(); usuario.setId(10);
		usuario.setNombre("Paco"); usuario.setApellido("Zamora");
		usuario.setEdad(34);
		insert(usuario);

		List<Usuario> busq = findAll();
		for (Usuario us: busq) {
			System.out.println(us);
		}

		HibernateUtil.closeSessionFactory();
	}
	
	public static void insert(Usuario usuario) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.persist(usuario);
		ses.getTransaction().commit();
	}
	
	public static List<Usuario> findAll() {
		Query query = HibernateUtil.getCurrentSesion().createQuery("FROM Usuario");
		ArrayList<Usuario> lista_us = (ArrayList<Usuario>) query.list();
		return lista_us;
	}
	
	public static void update(Usuario usuario) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.update(usuario);
		ses.getTransaction().commit();
	}
	
	public static void delete(Usuario usuario) {
		Session ses = HibernateUtil.getCurrentSesion();
		ses.beginTransaction();
		ses.delete(usuario);
		ses.getTransaction().commit();
	}
}