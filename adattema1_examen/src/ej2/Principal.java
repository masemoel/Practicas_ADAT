package ej2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Manuel José Moral Eliche
 * Acceso a datos - Examen tema 1 - Ejercicio 2
 */
public class Principal {
	public static void main(String[] args) {
		ObjectOutputStream serializador = null;
		Scanner in = new Scanner(System.in);
		
		List<Item_de_compra> listaItems = new ArrayList<Item_de_compra>();
		listaItems.add(new Item_de_compra(1, "Tomate", 0.99f, "Apis"));
		listaItems.add(new Item_de_compra(2, "Aceite de oliva", 4.49f, "Oleocampo"));
		listaItems.add(new Item_de_compra(3, "Chicle", 0.05f, "Clix"));
		
		try {
			serializador = new ObjectOutputStream(new FileOutputStream("items.dat"));
			serializador.writeObject(listaItems);
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
			deserializador = new ObjectInputStream(new FileInputStream("items.dat"));
			listaItems= (ArrayList<Item_de_compra>) deserializador.readObject();
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
		
		System.out.println("###################### MENÚ ########################");
		System.out.println("# 1. Añadir ítem a la lista de la compra.          #");
		System.out.println("# 2. Mostrar un ítem específico (mediante nombre). #");
		System.out.println("# 3. Modificar un ítem de la lista de la compra.   #");
		System.out.println("# 4. Mostrar todos los ítems de la compra.         #");
		System.out.println("# 0. Finalizar.                                    #");
		System.out.println("####################################################");
		int opcion = in.nextInt();
		while (opcion != 0) {
			int codigo;
			String articulo;
			float precio;
			String marca;
			switch(opcion) {
				case 1 :
					System.out.print("Introduce su código (debe ser único, y no repetido con los anteriores): ");
					codigo = in.nextInt();
					System.out.print("Introduce el nombre del artículo: ");
					articulo = in.next();
					System.out.print("Introduce su precio: ");
					precio = in.nextFloat();
					System.out.print("Introduce su marca: ");
					marca = in.next();
					listaItems.add(new Item_de_compra(codigo, articulo, precio, marca));
					System.out.println("¡Ítem añadido a la lista de la compra con éxito!");
					break;
				case 2:
					System.out.print("Introduce el nombre del ítem a mostrar: ");
					String busq = in.next();
					for (int i=0; i<listaItems.size(); i++) {
						if (listaItems.get(i).getArticulo().equals(busq)) {
						System.out.println(listaItems.get(i).toString());
						break;
						} else if ((listaItems.size() - 1) == i) {
							System.out.println(busq+" no se ha encontrado. Ejecuta la opción 4 y comprueba el nombre.");
						}
					}
					break;
				case 3:
					System.out.print("Introduce el nombre del ítem a modificar: ");
					String modif = in.next();
					for (int i=0; i<listaItems.size(); i++) {
						if (listaItems.get(i).getArticulo().equals(modif)) {
							System.out.println(listaItems.get(i).toString());
							System.out.print("\nIntroduce su nuevo código de artículo: ");
							codigo = in.nextInt();
							listaItems.get(i).setCodigo(codigo);
							System.out.print("Introduce su nuevo nombre de artículo: ");
							articulo = in.next();
							listaItems.get(i).setArticulo(articulo);
							System.out.print("Introduce su nuevo precio: ");
							precio = in.nextFloat();
							listaItems.get(i).setPrecio(precio);
							System.out.print("Introduce la marca del artículo: ");
							marca = in.next();
							listaItems.get(i).setMarca(marca);
							System.out.println("¡Modificación realizada con éxito!");
							break;
						} else if ((listaItems.size() - 1) == i) {
							System.out.println(modif+" no se ha encontrado. Ejecuta la opción 4 y comprueba el nombre.");
						}
					}
					break;
				case 4:
					for (int i=0; i<listaItems.size(); i++) {
						System.out.println(listaItems.get(i).toString());
					}
					break;
			}
			System.out.print("\nIntroduce ahora otra opción del menú: ");
			opcion = in.nextInt();
		}
		in.close();
	}
}