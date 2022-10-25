package adattema1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Manuel José Moral Eliche
 * Ejercicio 2.9 - Acceso a datos
 */
public class ejercicio2_9 {
	public static void main(String[] args) {
		try {
			File f=new File("soybinario.out");
			FileInputStream fis=new FileInputStream(f);
			DataInputStream dis=new DataInputStream(fis);
			int bytes = dis.read();
			char c;
			ArrayList<Character> lista_c = new ArrayList<>();
			while (bytes != -1) {
				c = (char) bytes;
				if (c == ' ') {
					lista_c.add(c);
				} else {
					for (char d = 'a'; d < 'z';d++ ) {
						if (c == d || Character.toUpperCase(d) == c) {
							lista_c.add(c);
						}
					}
				}
				bytes = dis.read();
			}
			dis.close();
			fis.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}