package com.masemoel.hibernate.adattema3_3explicacion;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		int opcion = -1;
		do {
			menu();
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Introduce una opción del menú"));
			switch (opcion) {
			case 1:
				controlador.muestraAutores();
				break;
			case 2:
				controlador.muestraAutor();
				break;
			case 3:
				controlador.insertarAu();
				break;
			case 4:
				controlador.actualizarAu();
				break;
			case 5:
				controlador.eliminarAu();
				break;
			case 6:
				controlador.muestraLibros();
				break;
			case 7:
				controlador.muestraLibro();
				break;
			case 8:
				controlador.insertarLi();
				break;
			case 9:
				controlador.actualizarLi();
				break;
			case 10:
				controlador.eliminarLi();
				break;
			case 0:
				controlador.finalizarPrograma();
			}
		} while (opcion != 0);
	}
	
	public static void menu() {
		System.out.println("------ GESTIÓN DE BIBLIOTECA ------");
		System.out.println("1. Mostrar todos los autores.");
		System.out.println("2. Mostrar un autor específico.");
		System.out.println("3. Insertar un nuevo autor");
		System.out.println("4. Modificar un autor existente.");
		System.out.println("5. Eliminar un autor.");
		System.out.println("6. Mostrar todos los libros.");
		System.out.println("7. Mostrar un libro específico.");
		System.out.println("8. Insertar un nuevo libro a un autor.");
		System.out.println("9. Modificar un libro existente.");
		System.out.println("10. Eliminar un libro.");
		System.out.println("0. Salir.");
	}
}