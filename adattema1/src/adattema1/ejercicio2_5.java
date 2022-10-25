package adattema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* * Manuel José Moral Eliche
 * Ejercicio 2.5 - Acceso a datos
 */
public class ejercicio2_5 {
	public static void main(String[] args) {
		try {
			File f=new File("fichero.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String s=br.readLine();
			while(s!=null){
				System.out.println(s.replace(" ", ""));
				s=br.readLine();
			}
			fr.close();
			br.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}