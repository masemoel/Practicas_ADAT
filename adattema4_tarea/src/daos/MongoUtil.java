package daos;

import org.bson.BSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {
	private static MongoClient mongoClient = null;
	private static MongoDatabase database = null;
	private static final long PORT = 27017;
	private static final String DATABASE = "personas";
	
	private static void iniciaOperacion() throws Exception {
		if (mongoClient == null) {
			mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:"+PORT));
			database = mongoClient.getDatabase(DATABASE);
		}
	}
	
	public static MongoDatabase getDatabase() {
		try {
			iniciaOperacion();
		} catch (Exception e) {
			System.out.println("E: No se puedo conectar con MongoDB...");
			e.printStackTrace();
		}
		return database;
	}
	
	public static BSONObject jsonToBSONObject(String json) {
		return (BSONObject) com.mongodb.util.JSON.parse(json);
	}
	
	public static void cerrar() {
		mongoClient.close();
	}
}