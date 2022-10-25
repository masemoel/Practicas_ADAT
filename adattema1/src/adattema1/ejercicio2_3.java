package adattema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Manuel José Moral Eliche
 * Ejercicio 2.3 - Acceso a datos
 */
public class ejercicio2_3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Escribe el nombre del fichero: ");
			String fich = in.next();
			File f=new File(fich);
			System.out.print("Escribe la palabra a buscar en texto: ");
			String palabra = in.next();
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String s=br.readLine();
			while(s!=null){
				int intIndex = s.indexOf(palabra);
				if (intIndex != -1 ) {
					System.out.println(s);
				}
				s=br.readLine();
			}
			br.close();
			in.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}