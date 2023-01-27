package com.masemoel.hibernate.adattema3_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static void buildSessionFactory() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
	}
	
	public static void openSession() {
		session = sessionFactory.openSession();
	}
	
	public static Session getCurrentSesion() {
		if (!session.isOpen( )) {
			openSession();
		}
		return session;
	}
	
	public static void closeSessionFactory() {
		if (session != null) {
			session.close();
		}
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}