package agenda;

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
		in.useDelimiter("\n");
		
		List<Persona> agendaPersonas = new ArrayList<Persona>();
		agendaPersonas.add(new Persona("Fulanito", "fulanito@gmail.com", "2004", "12345678K"));
		agendaPersonas.add(new Persona("Anónimo", "anonymous@gmail.com", "1995", "76945189Y"));
		agendaPersonas.add(new Persona("Superman", "suuuperman@gmail.com", "2001", "95123648X"));
		
		try {
			serializador = new ObjectOutputStream(new FileOutputStream("personas.dat"));
			serializador.writeObject(agendaPersonas);
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
			agendaPersonas= (ArrayList<Persona>) deserializador.readObject();
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
		System.out.println("1. Añadir persona a la agenda.");
		System.out.println("2. Mostar toda la agenda de personas.");
		System.out.println("3. Buscar entre la agenda de personas por su DNI.");
		System.out.println("0. Finalizar.");
		int opcion = in.nextInt();
		while (opcion != 0) {
			switch(opcion) {
			case 1:
				System.out.print("Introduce su nombre: ");
				String nombre = in.next();
				System.out.print("Introduce su correo electrónico: ");
				String mail = in.next();
				System.out.print("Introduce su año de nacimiento: ");
				String anyo = in.next();
				System.out.print("Introduce su DNI: ");
				String dni = in.next();
				agendaPersonas.add(new Persona(nombre, mail, anyo, dni));
				break;
			case 2:
				for (int i=0; i<agendaPersonas.size(); i++) {
					System.out.println(agendaPersonas.get(i).toString());
				}
				break;
			case 3:
				System.out.print("Introduce el DNI de la persona a buscar: ");
				String busqueda = in.next();
				for (int i=0; i<agendaPersonas.size(); i++) {
					if (agendaPersonas.get(i).getDNI().equals(busqueda)) {
						System.out.println(agendaPersonas.get(i).toString());
						i = agendaPersonas.size();
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