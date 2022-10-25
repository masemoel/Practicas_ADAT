package adattema1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * Manuel José Moral Eliche
 * Ejercicio 2.10 - Acceso a datos
 */
public class ejercicio2_10 {
	public static void main(String[] args) {
		try {
			File f=new File("homer.gif");
			FileInputStream fis=new FileInputStream(f);
			DataInputStream dis=new DataInputStream(fis);
			int bytes = dis.read();
			char c;
			int cont = 1;
			while (cont <= 3 && bytes != -1) {
				c = (char) bytes;
				if ((c == 'g' || c == 'i' || c == 'f' || c == 'G' || c == 'I' || c == 'F')) {
					System.out.println("El carácter número "+cont+" es "+c);
				} else {
					System.out.println("El carácter número "+cont+" no es g, i o f; el carácter leído es "+c);
				}
				cont++;
				bytes = dis.read();
			}
			fis.close();
			dis.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}