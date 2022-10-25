package adattema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Manuel José Moral Eliche
 * Ejercicio 2.4 - Acceso a datos
 */
public class ejercicio2_4 {
	public static void main(String[] args) {
		int largo = 0;
		int ancho = 0;
		try {
			File f=new File("rectangulo.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String s=br.readLine();
			
			while(s!=null){
				if (largo == 0) {
					ancho = s.length();
				}
				s=br.readLine();
				largo++;
			}
			br.close();
			fr.close();
			System.out.println("El rectángulo tiene "+largo+" de largo y "+ancho+" de ancho.");
		} catch (IOException e) {
			ancho = 0;
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}