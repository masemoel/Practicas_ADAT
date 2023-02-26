package explicacionMVC;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		// TODO: ¡no usar Scanner más allá de la pantalla principal!
		Scanner sc = new Scanner(System.in);
		ControladorJugador cj = new ControladorJugador();
		int opcion;
		do {
			menu();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				cj.mostrarJugadores();
				break;
			case 2:
				cj.mostrarJugador();
				break;
			case 3:
				cj.nuevoJugador();
				break;
			case 4:
				cj.actualizarJugador();
				break;
			case 5:
				cj.eliminarJugador();
				break;
			case 0:
				cj.acabarPrograma();
				sc.close();
				break;
			}
		} while (opcion != 0);
		System.out.println("");
	}
	
	public static void menu() {
		System.out.println("------ GESTIÓN DE JUGADORES ------");
		System.out.println("1. Mostrar todos los jugadores.");
		System.out.println("2. Mostrar un jugador específico.");
		System.out.println("3. Crear un nuevo jugador.");
		System.out.println("4. Actualizar los datos de jugador.");
		System.out.println("5. Eliminar un jugador.");
		System.out.println("0. Salir.");
	}
}