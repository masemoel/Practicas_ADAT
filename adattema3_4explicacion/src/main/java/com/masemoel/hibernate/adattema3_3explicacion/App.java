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
				controlador.muestraClientes();
				break;
			case 2:
				controlador.muestraCliente();
				break;
			case 3:
				controlador.insertarCli();
				break;
			case 4:
				controlador.actualizarCli();
				break;
			case 5:
				controlador.eliminarCli();
				break;
			case 6:
				controlador.muestraPrestamos();
				break;
			case 7:
				controlador.muestraPrestamo();
				break;
			case 8:
				controlador.insertarPres();
				break;
			case 9:
				controlador.actualizarPres();
				break;
			case 10:
				controlador.eliminarPres();
				break;
			case 0:
				controlador.finalizarPrograma();
			}
		} while (opcion != 0);
	}
	
	public static void menu() {
		System.out.println("--- GESTIÓN DE PRÉSTAMOS Y CLIENTES ----");
		System.out.println("1. Mostrar todos los clientes.");
		System.out.println("2. Mostrar un cliente específico.");
		System.out.println("3. Insertar un nuevo cliente");
		System.out.println("4. Modificar un cliente existente.");
		System.out.println("5. Eliminar un cliente.");
		System.out.println("6. Mostrar todos los préstamos.");
		System.out.println("7. Mostrar un préstamo específico.");
		System.out.println("8. Insertar un nuevo préstamo a un cliente.");
		System.out.println("9. Modificar un préstamo existente.");
		System.out.println("10. Eliminar un préstamo.");
		System.out.println("0. Salir.");
	}
}