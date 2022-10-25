package adattema1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * Manuel José Moral Eliche
 * Ejercicio 2.12 - Acceso a datos
 */
public class ejercicio2_12 {
	public static void main(String[] args) {
		try {
			FileInputStream fis1=new FileInputStream("homer.gif");
			DataInputStream dis1=new DataInputStream(fis1);
			
			FileInputStream fis2=new FileInputStream("soybinario.out");
			DataInputStream dis2=new DataInputStream(fis2);
			
			byte[] archivo1 = dis1.readAllBytes();
			byte[] archivo2 = dis2.readAllBytes();
			
			if (Arrays.equals(archivo1, archivo2)) {
				System.out.println("Los archivos tienen el mismo contenido.");
			} else {
				System.out.println("Los archivos no tienen el mismo contenido.");
			}
			
			fis1.close();
			fis2.close();
			dis1.close();
			dis2.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}