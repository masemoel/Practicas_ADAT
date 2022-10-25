package adattema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Manuel José Moral Eliche
 * Ejercicio 2.7 - Acceso a datos
 */
public class ejercicio2_7 {
	public static void main(String[] args) {
		try {
			File f=new File("java.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String s=br.readLine();
			while(s!=null){
				s = s.replace("import", "include");
				s = s.replace("println", "WriteLine");
				s = s.replace("String", "string");
				s = s.replace("main", "Main");
				s = s.replace(".charAt", ".CharAt");
				System.out.println(s);
				s = br.readLine();
			}
			fr.close();
			br.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}