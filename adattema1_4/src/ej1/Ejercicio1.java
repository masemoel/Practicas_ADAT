package ej1;

import java.io.File;
import java.util.Scanner;

/*
 * Manuel José Moral Eliche
 * Ejercicio 4.1 - Acceso a datos
 */
public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Escribe el directorio: ");
		String userdir = in.next();
		System.out.print("Escribe la extensión a filtrar: ");
		String userext = in.next();
		String userdirp = System.getProperty(userdir);
		File f = new File(userdirp);
		String[] listado = f.list();
		in.close();
		if (listado == null || listado.length == 0) {
			System.out.println("No hay elementos dentro de la carpeta actual.");
			return;
		} else {
			for (int i=0;i<listado.length;i++) {
				if (listado[i].toString().endsWith(userext)) {
					System.out.println(listado[i]);
				}
			}
		}
	}
}