package main.java;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Principal {
	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongo = crearConexion();
		if (mongo != null) {
			System.out.println("Conexión establecida correctamente con Mongo.");
			System.out.println("Bases de datos existentes:");
			printDatabases(mongo);
			DB db = mongo.getDB("dam");
			System.out.println("\nColecciones existentes:");
			printCollections(db);
		} else {
			System.out.println("E: Conexión no establecida.");
		}
	}
	
	private static MongoClient crearConexion() throws UnknownHostException {
		MongoClient mongo = null;
		mongo = new MongoClient("localhost", 27017);
		return mongo;
	}
	
	private static void printDatabases(MongoClient mongo) {
		List<String> basesDeDatos = mongo.getDatabaseNames();
		for (String n: basesDeDatos) {
			System.out.println(n);
		}
	}
	
	private static void printCollections(DB db) {
		Set<String> tables = db.getCollectionNames();
		for (String c: tables) {
			System.out.println(c);
		}
	}
}