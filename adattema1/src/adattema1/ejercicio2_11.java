package adattema1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * Manuel José Moral Eliche
 * Ejercicio 2.11 - Acceso a datos
 */
public class ejercicio2_11 {
	public static void main(String[] args) {
		try {
			File f=new File("soybinario.out");
			FileInputStream fis=new FileInputStream(f);
			DataInputStream dis=new DataInputStream(fis);
			byte[] array;
			dis.read(array);
			char c;
			for (int i=0;i<array.length;i++) {
				c = (char) array[i];
				for (char letra='a';letra<='z';letra++) {
					if (letra == c) {
						System.out.print(c);
					}
				}
				for (char letra = 'A';letra<='Z';letra++) {
					if (letra == c) {
						System.out.print(c);
					}
				}
			}
			fis.close();
			dis.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}