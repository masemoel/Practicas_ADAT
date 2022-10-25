package ciudad;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
		ObjectOutputStream serializador = null;
		
		List<Ciudad> listaCiudades = new ArrayList<Ciudad>();
		listaCiudades.add(new Ciudad(1, "Madrid"));
		listaCiudades.add(new Ciudad(2, "California"));
		listaCiudades.add(new Ciudad(3, "Sevilla"));
		
		try {
			serializador = new ObjectOutputStream(new FileOutputStream("ciudades.dat"));
			serializador.writeObject(listaCiudades);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (serializador != null) {
				try {
					serializador.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		ObjectInputStream deserializador = null;
		
		try {
			deserializador = new ObjectInputStream(new FileInputStream("ciudades.dat"));
			listaCiudades= (ArrayList<Ciudad>) deserializador.readObject();
			
			for (int i=0; i<listaCiudades.size(); i++) {
				//System.out.println(listaCiudades.get(i).getNombre());
				//System.out.println(listaCiudades.get(i).getCodigo());
				System.out.println(listaCiudades.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (deserializador != null) {
				try {
					deserializador.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}