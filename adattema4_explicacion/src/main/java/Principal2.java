package main.java;

import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Principal2 {
	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongo = crearConexion();
		if (mongo != null) {
			System.out.println("Conexión establecida correctamente con Mongo.");
			DB db = mongo.getDB("bd-ejemplo");
//			insertarTrabajador(db, "trabajadores", "José", "López Pérez", 35);
//			insertarTrabajador(db, "trabajadores", "María", "Martínez Aguilar", 32);
//			insertarTrabajador(db, "trabajadores", "Juan", "Robles Navarro", 59);
//			actualizarNombreTrabajador(db, "trabajadores", "José", 46);
//			eliminarTrabajadorPorNombre(db, "trabajadores", "José");
			eliminarTrabajadorPorEdadMayorQue(db, "trabajadores", 40);
			
		} else {
			System.out.println("E: Conexión no establecida.");
		}
	}
	
	private static MongoClient crearConexion() throws UnknownHostException {
		MongoClient mongo = null;
		mongo = new MongoClient("localhost", 27017);
		return mongo;
	}

	private static void insertarTrabajador(DB db, String tabla, String nombre, String apellidos, int annos) {
		DBCollection table = db.getCollection(tabla);
		BasicDBObject document = new BasicDBObject();
		document.put("nombre", nombre);
		document.put("apellidos", apellidos);
		document.put("años", annos);
		document.put("fecha", new Date());
		table.insert(document);
	}
	
	private static void actualizarNombreTrabajador(DB db, String tabla, String nombre, int nannos) {
		DBCollection table = db.getCollection(tabla);
		BasicDBObject updateAnnos = new BasicDBObject();
		updateAnnos.append("$set", new BasicDBObject().append("años", nannos));
		BasicDBObject searchByNombre = new BasicDBObject();
		searchByNombre.append("nombre", nombre);
		table.updateMulti(searchByNombre, updateAnnos);
	}
	
	private static void eliminarTrabajadorPorNombre(DB db, String tabla, String nombre) {
		DBCollection table = db.getCollection(tabla);
		table.remove(new BasicDBObject().append("nombre", nombre));
	}
	
	private static void eliminarTrabajadorPorEdadMayorQue(DB db, String tabla, int annos) {
		DBCollection table = db.getCollection(tabla);
		BasicDBObject query = new BasicDBObject();
		query.put("años", new BasicDBObject("$gt", annos));
		table.remove(query);
	}
}