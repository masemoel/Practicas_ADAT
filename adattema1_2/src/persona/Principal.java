package persona;

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
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		listaPersonas.add(new Persona("Fulanito", "fulanito@gmail.com", "2004"));
		listaPersonas.add(new Persona("Anónimo", "anonymous@gmail.com", "1995"));
		listaPersonas.add(new Persona("Superman", "suuuuuuperman@gmail.com", "2000"));
		
		try {
			serializador = new ObjectOutputStream(new FileOutputStream("personas.dat"));
			serializador.writeObject(listaPersonas);
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
			deserializador = new ObjectInputStream(new FileInputStream("personas.dat"));
			listaPersonas= (ArrayList<Persona>) deserializador.readObject();
			
			for (int i=0; i<listaPersonas.size(); i++) {
				System.out.println(listaPersonas.get(i).toString());
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