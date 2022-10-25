package adattema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Manuel José Moral Eliche
 * Ejercicio 2.1 - Acceso a datos
 */
public class ejercicio2_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			File f=new File("texto.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String s=br.readLine();
			int x=1;
			while(s!=null){
				System.out.println(s);
				s=br.readLine();
				if (x == 23) {
					System.out.println("\n Pulse ENTER para seguir leyendo.");
					in.nextLine();
					x = 0;
				}
				x++;
			}
			br.close();
			in.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}