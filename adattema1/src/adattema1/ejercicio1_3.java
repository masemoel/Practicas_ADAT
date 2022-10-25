package adattema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Manuel José Moral Eliche
 * Ejercicio 1.3 - Acceso a datos
 */
public class ejercicio1_3 {
	public static void main(String[] args) {
		try {
			File f=new File("fichero.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String s=br.readLine();
			System.out.println(s.substring(0, s.length()/2));
			System.out.println(s.substring(s.length()/2, s.length()));
			fr.close();
			br.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}