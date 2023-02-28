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

import modelos.Venta;

public class VentaDAO {
	private static VentaDAO instance = null;
	private MongoDatabase db;
	private MongoCollection<Document> collection;
	private Gson gson;
	
	protected VentaDAO() {
		gson = new Gson();
		db = MongoUtil.getDatabase();
		collection = db.getCollection("ventas");
	}
	
	public static VentaDAO getInstance() {
		if (instance == null) {
			instance = new VentaDAO();
		}
		return instance;
	}
	
	public Venta deserializar(String json) {
		return gson.fromJson(json, Venta.class);
	}
	
	public List<Venta> findAll() {
		List<Venta> lista = new ArrayList<Venta>();
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
	
	public Venta findByPk(String nroTicket) {
		Venta venta = null;
		String json = ("{nroTicket: '"+nroTicket+"'}");
		BSONObject bson = (BSONObject) com.mongodb.util.JSON.parse(json);
		FindIterable<Document> traido = collection.find((Bson) bson);
		if (traido == null) {
			JOptionPane.showInputDialog("No se ha encontrado ninguna venta con nº de ticket "+nroTicket);
		} else {
			MongoCursor<Document> cursor = traido.iterator();
			if (cursor.hasNext()) {
				venta = deserializar(cursor.next().toJson());
				cursor.close();
			}
		}
		return venta;
	}
	
	public void agregar(Venta venta) {
		String json = gson.toJson(venta);
		Document doc = Document.parse(json);
		collection.insertOne(doc);
	}
	
	public void modificar(Venta venta) {
		BasicDBObject query = new BasicDBObject();
		query.put("nroTicket", venta.getNroTicket());
		BasicDBObject newDoc = new BasicDBObject();
		String json = gson.toJson(venta);
		BSONObject bson = MongoUtil.jsonToBSONObject(json);
		newDoc.putAll(bson);
		BasicDBObject updater = new BasicDBObject();
		updater.put("$set", newDoc);
		collection.updateOne(query, updater);
	}
	
	public long eliminar(Venta venta) {
		String json = "{nroTicket: '"+venta.getNroTicket()+"'}";
		BSONObject bson = MongoUtil.jsonToBSONObject(json);
		DeleteResult result = collection.deleteOne((Bson) bson);
		return result.getDeletedCount();
	}
}