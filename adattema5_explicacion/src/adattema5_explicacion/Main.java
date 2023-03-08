package adattema5_explicacion;

import java.math.BigDecimal;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Main {
	public static void main(String[] args) {
		ODB odb = ODBFactory.open("C:\\Users\\Masemoel\\Desktop\\neodatis.test");
		Jugadores j1= new Jugadores ("María", "voleibol", "Madrid", 14);
		Jugadores j2= new Jugadores ("Miguel", "tenis", "Madrid", 15);
		
		odb.store(j1);
		odb.store(j2);
		
		Objects<Jugadores> jugadores = odb.getObjects(Jugadores.class);
		mostrarDatos(jugadores);
		// Consulta 1: jugadores que juegan a tenis
		IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("deporte", "tenis"));
		query.orderByDesc("nombre,edad");
		jugadores = odb.getObjects(query);
		mostrarDatos(jugadores);
		// Consulta 2: jugadores con 14 años
		ICriterion criterio = Where.equal("edad",14);
		query = new CriteriaQuery(Jugadores.class, criterio);
		query.orderByDesc("nombre,edad");
		jugadores = odb.getObjects(query);
		// Consulta 3: jugadores que empiezan por Mi
		criterio = Where.equal("nombre","Mi%");
		query = new CriteriaQuery(Jugadores.class, criterio);
		query.orderByDesc("nombre,edad");
		jugadores = odb.getObjects(query);
		mostrarDatos(jugadores);
		// Consulta 4: jugadores con 14 años y viven en Madrid
		criterio = new And().add(Where.equal("nombre","M%")).add(Where.equal("ciudad", "Madrid"));
		query = new CriteriaQuery(Jugadores.class, criterio);
		query.orderByDesc("nombre,edad");
		jugadores = odb.getObjects(query);
		mostrarDatos(jugadores);
		// Modificación: Miguel ahora juega a la petanca
		IQuery query_mod = new CriteriaQuery(Jugadores.class, Where.equal("nombre", "Miguel"));
		jugadores = odb.getObjects(query_mod);
		Jugadores jug = (Jugadores) odb.getObjects(query_mod).getFirst();
		jug.setDeporte("petanca");
		odb.store(jug);
		mostrarDatos(jugadores);
		// Eliminación: María se retira
		IQuery query_elim = new CriteriaQuery(Jugadores.class, Where.equal("nombre", "María"));
		jugadores = odb.getObjects(query_elim);
		Jugadores jug2 = (Jugadores) odb.getObjects(query_elim).getFirst();
		odb.delete(jug2);
		mostrarDatos(jugadores);
		// Destrucción masiva
		jugadores = odb.getObjects(Jugadores.class);
		for (Jugadores j: jugadores) {
			odb.delete(j);
		}
		jugadores = odb.getObjects(Jugadores.class);
		mostrarDatos(jugadores);
		odb.close();
	}
	
	public static void mostrarDatos(Objects<Jugadores> objects) {
		System.out.println(objects.size()+" jugadores");
		int i = 1;
		while (objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println(i+":\t "+jug.getNombre()+" - "+jug.getDeporte()+" - "+jug.getCiudad()+" - "+jug.getEdad());
			i++;
		}
	}
}