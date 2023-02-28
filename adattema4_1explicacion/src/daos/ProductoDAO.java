package daos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.bson.BSON;
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

import modelos.Producto;

public class ProductoDAO {
	private static ProductoDAO instance = null;
	private MongoDatabase db;
	private MongoCollection<Document> collection;
	private Gson gson;
	
	protected ProductoDAO() {
		gson = new Gson();
		db = MongoUtil.getDatabase();
		collection = db.getCollection("producto");
	}
	
	public static ProductoDAO getInstance() {
		if (instance == null) {
			instance = new ProductoDAO();
		}
		return instance;
	}
	
	public Producto deserializar(String json) {
		return gson.fromJson(json, Producto.class);
	}
	
	public List<Producto> findAll() {
		List<Producto> lista = new ArrayList<Producto>();
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
	
	public Producto findByPk(int codigo) {
		Producto producto = null;
		String json = "{codigo: "+codigo+"}";
		BSONObject bson = (BSONObject) com.mongodb.util.JSON.parse(json);
		FindIterable<Document> traido = (collection.find((Bson) bson));
		if (traido == null) {
			JOptionPane.showInputDialog("No se ha encontrado ningun producto con código "+codigo);
		} else {
			MongoCursor<Document> cursor = traido.iterator();
			if (cursor.hasNext()) {
				producto = deserializar(cursor.next().toJson());
				cursor.close();
			}
		}
		return producto;
	}
	
	public void agregar(Producto producto) {
		String json = gson.toJson(producto);
		Document doc = Document.parse(json);
		collection.insertOne(doc);
	}
	
	public void modificar(Producto producto) {
		BasicDBObject query = new BasicDBObject();
		query.put("codigo", producto.getCodigo());
		BasicDBObject newDoc = new BasicDBObject();
		String json = gson.toJson(producto);
		BSONObject bson = MongoUtil.jsonToBSONObject(json);
		newDoc.putAll(bson);
		BasicDBObject updater = new BasicDBObject();
		updater.put("$set", newDoc);
		collection.updateOne(query, updater);
	}
	
	public long eliminar(Producto producto) {
		String json = "{codigo: "+producto.getCodigo()+"}";
		BSONObject bson = MongoUtil.jsonToBSONObject(json);
		DeleteResult result = collection.deleteOne((Bson) bson);
		return result.getDeletedCount();
	}
}