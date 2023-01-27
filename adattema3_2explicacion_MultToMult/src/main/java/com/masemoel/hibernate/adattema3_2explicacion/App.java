package com.masemoel.hibernate.adattema3_2explicacion;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Personaje perj1 = new Personaje();
		perj1.setId(1);
		perj1.setNombre("Manolo");
		perj1.setVida(10);
		perj1.setPuntos(0);

		Personaje perj2 = new Personaje();
		perj2.setId(2);
		perj2.setNombre("Doraemon");
		perj2.setVida(1000);
		perj2.setPuntos(0);

		Arma arma1 = new Arma();
		arma1.setId(1);
		arma1.setNombre("Cañón");
		arma1.setDescripcion("Destruye fortalezas.");
		arma1.setDano(50);

		Arma arma2 = new Arma();
		arma2.setId(2);
		arma2.setNombre("Revolver");
		arma2.setDescripcion("Dispara.");
		arma2.setDano(5);

		perj1.addArma(arma1, "Para el trabajo");
		perj1.addArma(arma2, "Para cazar");
		perj2.addArma(arma2, "Para tiro al plato");

		Session sesion = HibernateUtil.getCurrentSesion();
		sesion.beginTransaction();
		sesion.persist(arma1);
		sesion.persist(arma2);
		sesion.persist(perj1);
		sesion.persist(perj2);

		Query query = HibernateUtil.getCurrentSesion().createQuery("FROM Personaje per");
		ArrayList<Personaje> lista_p = (ArrayList) query.list();
		for (Personaje p: lista_p) {
			System.out.println(p);
		}
		
		sesion.getTransaction().commit();
		sesion.close();
		HibernateUtil.closeSessionFactory();
	}
}