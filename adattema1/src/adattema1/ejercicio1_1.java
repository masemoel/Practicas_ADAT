package adattema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Manuel José Moral Eliche
 * Ejercicio 1.1 - Acceso a datos
 */
public class ejercicio1_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Escribe el nombre del fichero a ejecutar: ");
			String fich = in.next();
			File f=new File(fich);
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String s=br.readLine();
			while(s!=null){
				System.out.println(s);
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