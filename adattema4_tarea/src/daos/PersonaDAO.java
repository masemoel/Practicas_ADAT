package daos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import modelos.Persona;

public class PersonaDAO {
	private static PersonaDAO instance = null;
	private MongoDatabase db;
	private MongoCollection<Document> collection;
	private Gson gson;
	
	protected PersonaDAO() {
		gson = new Gson();
		db = MongoUtil.getDatabase();
		collection = db.getCollection("personas");
	}
	
	public static PersonaDAO getInstance() {
		if (instance == null) {
			instance = new PersonaDAO();
		}
		return instance;
	}
	
	public Persona deserializar(String json) {
		return gson.fromJson(json, Persona.class);
	}
	
	public List<Persona> findAll() {
		List<Persona> lista = new ArrayList<Persona>();
		FindIterable<Document> fi = collection.find();
		MongoCursor<Document> cursor = fi.iterator();
		try {
			while (cursor.hasNext()) {
				lista.add(deserializar(cursor.next().toJson()));
			}
		} finally {
			cursor.close();
		}
		return lista;
	}
	
	public Persona findByPk(String dni) {
		Persona persona = null;
		String json = ("{dni: '"+dni+"'}");
		BSONObject bson = (BSONObject) com.mongodb.util.JSON.parse(json);
		FindIterable<Document> traido = collection.find((Bson) bson);
		if (traido == null) {
			JOptionPane.showInputDialog("No se ha encontrado ninguna persona con dni "+dni);
		} else {
			MongoCursor<Document> cursor = traido.iterator();
			if (cursor.hasNext()) {
				persona = deserializar(cursor.next().toJson());
				cursor.close();
			}
		}
		return persona;
	}
	
	public void agregar(Persona persona) {
		String json = gson.toJson(persona);
		Document doc = Document.parse(json);
		collection.insertOne(doc);
	}
	
	public void modificar(Persona persona) {
		BasicDBObject query = new BasicDBObject();
		query.put("dni", persona.getDni());
		BasicDBObject newDoc = new BasicDBObject();
		String json = gson.toJson(persona);
		BSONObject bson = MongoUtil.jsonToBSONObject(json);
		newDoc.putAll(bson);
		BasicDBObject updater = new BasicDBObject();
		updater.put("$set", newDoc);
		collection.updateOne(query, updater);
	}
	
	public long eliminar(Persona persona) {
		String json = "{dni: '"+persona.getDni()+"'}";
		BSONObject bson = MongoUtil.jsonToBSONObject(json);
		DeleteResult result = collection.deleteOne((Bson) bson);
		return result.getDeletedCount();
	}
}