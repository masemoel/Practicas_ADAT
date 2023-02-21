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
				controlador.muestraVentas();
				break;
			case 2:
				controlador.muestraVenta();
				break;
			case 3:
				controlador.insertarVen();
				break;
			case 4:
				controlador.actualizarVen();
				break;
			case 5:
				controlador.eliminarVen();
				break;
			case 6:
				controlador.muestraProductos();
				break;
			case 7:
				controlador.muestraProducto();
				break;
			case 8:
				controlador.insertarPro();
				break;
			case 9:
				controlador.actualizarPro();
				break;
			case 10:
				controlador.eliminarPro();
				break;
			case 0:
				controlador.finalizarPrograma();
			}
		} while (opcion != 0);
	}
	
	public static void menu() {
		System.out.println("------ GESTIÓN DE TIENDA ------");
		System.out.println("1. Mostrar todas las ventas.");
		System.out.println("2. Mostrar una venta específica.");
		System.out.println("3. Insertar una nueva venta.");
		System.out.println("4. Modificar una venta existente.");
		System.out.println("5. Eliminar una venta.");
		System.out.println("6. Mostrar todos los productos.");
		System.out.println("7. Mostrar un producto específico.");
		System.out.println("8. Insertar un nuevo producto a una venta.");
		System.out.println("9. Modificar un producto existente.");
		System.out.println("10. Eliminar un producto.");
		System.out.println("0. Salir.");
	}
}