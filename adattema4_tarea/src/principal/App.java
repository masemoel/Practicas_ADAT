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
				case 1 -> c.traerPersonas();
				case 2 -> c.traerPersona();
				case 3 -> c.agregarPersona();
				case 4 -> c.modificarPersona();
				case 5 -> c.eliminarPersona();
				case 0 -> c.finalizar();
				default -> JOptionPane.showMessageDialog(null, "Introduce una opción del 1 al 5.");
			}
		} while (opcion != 0);
	}
	
	public static String menu() {
		String mensaje="";
		mensaje += "--- SISTEMA DE GESTIÓN DE PERSONAS ---\n";
		mensaje += "1. Mostrar todas las personas.\n";
		mensaje += "2. Mostrar una persona específica.\n";
		mensaje += "3. Agregar una nueva persona.\n";
		mensaje += "4. Modificar una persona.\n";
		mensaje += "5. Eliminar una persona.\n";
		mensaje += "0. Salir.\n";
		return mensaje;
	}
}