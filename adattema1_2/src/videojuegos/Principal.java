package videojuegos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		ObjectOutputStream serializador = null;
		Scanner in = new Scanner(System.in);
		
		// solución a los espacios con Scanner. Deshabilitar si saltan excepciones con Scanner
		in.useDelimiter("\n");
		
		List<Videojuegos> listaVideojuegos = new ArrayList<Videojuegos>();
		listaVideojuegos.add(new Videojuegos("Need for speed", "Coches", "PC", "Coches", "2001"));
		listaVideojuegos.add(new Videojuegos("FNAF", "Miedo", "PC", "Terror nocturno", "2014"));
		listaVideojuegos.add(new Videojuegos("COD", "Acción", "PS4", "Batallas", "2011"));
		
		try {
			serializador = new ObjectOutputStream(new FileOutputStream("personas.dat"));
			serializador.writeObject(listaVideojuegos);
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
			listaVideojuegos= (ArrayList<Videojuegos>) deserializador.readObject();
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
		
		System.out.println("Introduce el número del método que deseas ejecutar:");
		System.out.println("1. Añadir videojuego a la lista.");
		System.out.println("2. Mostar todos los videojuegos almacenados.");
		System.out.println("3. Modificar un videojuego de la lista.");
		System.out.println("0. Finalizar.");
		int opcion = in.nextInt();
		String nombre;
		String genero;
		String plataforma;
		String descripcion;
		String anyo;
		while (opcion != 0) {
			switch(opcion) {
			case 1:
				System.out.print("Introduce su nombre: ");
				nombre = in.next();
				System.out.print("Introduce su género: ");
				genero = in.next();
				System.out.print("Introduce su plataforma: ");
				plataforma = in.next();
				System.out.print("Introduce su descripción: ");
				descripcion = in.next();
				System.out.print("Introduce su año de lanzamiento: ");
				anyo = in.next();
				listaVideojuegos.add(new Videojuegos(nombre, genero, plataforma, descripcion, anyo));
				break;
			case 2:
				for (int i=0; i<listaVideojuegos.size(); i++) {
					System.out.println(listaVideojuegos.get(i).toString());
				}
				break;
			case 3:
				System.out.print("Introduce el nombre del videojuego a modificar: ");
				String modif = in.next();
				for (int i=0; i<listaVideojuegos.size(); i++) {
					if (listaVideojuegos.get(i).getNombre().equals(modif)) {
						System.out.print("Introduce su nuevo nombre: ");
						nombre = in.next();
						listaVideojuegos.get(i).setNombre(nombre);
						System.out.print("Introduce su nuevo género: ");
						genero = in.next();
						listaVideojuegos.get(i).setGenero(genero);
						System.out.print("Introduce su nuevo plataforma: ");
						plataforma = in.next();
						listaVideojuegos.get(i).setPlataforma(plataforma);
						System.out.print("Introduce su nuevo descripción: ");
						descripcion = in.next();
						listaVideojuegos.get(i).setDescripcion(descripcion);
						System.out.print("Introduce su nuevo año de lanzamiento: ");
						anyo = in.next();
						listaVideojuegos.get(i).setAnyo(anyo);
						i = listaVideojuegos.size();
						System.out.println("¡Modificación realizada con éxito!");
					} else if ((listaVideojuegos.size() - 1) == i) {
						System.out.println(modif+" no se ha encontrado. Ejecuta la opción 2 y comprueba el nombre.");
					}
				}
				break;
			}
			System.out.print("\nIntroduce ahora otra opción del menú: ");
			opcion = in.nextInt();
		}
		in.close();
	}
}