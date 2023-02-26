package explicacionMVC;

import java.util.List;

public class VistaJugador {
	public void verJugador(Jugador j) {
		System.out.println("Datos del jugador: "+j);
	}
	
	public void verTodosJugadores(List<Jugador> jugadores) {
		for (Jugador jugador: jugadores) {
			System.out.println("Datos del jugador: "+jugador);
		}
	}
}