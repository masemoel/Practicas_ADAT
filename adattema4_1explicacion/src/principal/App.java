package principal;

import javax.swing.JOptionPane;

import controladores.Controlador;

public class App {
	public static void main(String[] args) {
		Controlador c = Controlador.getInstance();
		int opcion = 1;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu()));
			switch (opcion) {
				case 1 -> c.traerProductos();
				case 2 -> c.traerProducto();
				case 3 -> c.agregarProducto();
				case 4 -> c.modificarProducto();
				case 5 -> c.eliminarProducto();
				case 6 -> c.traerVentas();
				case 7 -> c.traerVenta();
				case 8 -> c.agregarVenta();
				case 9 -> c.modificarVenta();
				case 10 -> c.eliminarVenta();
			}
		} while (opcion != 0);
		c.finalizar();
	}
	
	public static String menu() {
		String mensaje="";
		mensaje += "--- SISTEMA DE GESTIÓN DE VENTAS ---\n";
		mensaje += "1. Mostrar todos los productos.\n";
		mensaje += "2. Mostrar un producto específico.\n";
		mensaje += "3. Agregar un nuevo producto.\n";
		mensaje += "4. Modificar un producto.\n";
		mensaje += "5. Eliminar un producto.\n";
		mensaje += "6. Mostrar todas las ventas.\n";
		mensaje += "7. Mostrar una venta específica.\n";
		mensaje += "8. Agregar una nueva venta.\n";
		mensaje += "9. Modificar una venta.\n";
		mensaje += "10. Eliminar una venta.\n";
		mensaje += "0. Salir.\n";
		return mensaje;
	}
}