package explicacionMVC;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class PideDatosJugador {
	public int pideCodigo() {
		Scanner sc = new Scanner(System.in);
		int codigo;
		System.out.print("Introduzca el código del jugador: ");
		codigo = sc.nextInt();
		sc.close();
		return codigo;
	}
	
	public Jugador pideOtrosDatosJugador(int codigo) {
		Jugador j = null;
		String nombre = JOptionPane.showInputDialog("Nombre");
		String procedencia = JOptionPane.showInputDialog("Procedencia");
		String altura = JOptionPane.showInputDialog("Altura");
		int peso = Integer.parseInt(JOptionPane.showInputDialog("Peso"));
		String posicion = JOptionPane.showInputDialog("Posición");
		String nombre_equipo = JOptionPane.showInputDialog("Nombre del equipo");
		j = new Jugador(codigo, nombre, nombre_equipo, procedencia, altura, posicion, peso);
		return j;
	}
}