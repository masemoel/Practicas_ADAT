package adattema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Manuel José Moral Eliche
 * Ejercicio 1.2 - Acceso a datos
 */
public class ejercicio1_2 {
	public static void main(String[] args) {
		try {
			File f=new File("texto.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String s="";
			br.readLine();
			while(s!=null){
				System.out.println(s);
				s=br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}