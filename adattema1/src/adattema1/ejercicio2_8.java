package adattema1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * Manuel José Moral Eliche
 * Ejercicio 2.8 - Acceso a datos
 */
public class ejercicio2_8 {
	public static void main(String[] args) {
		try {
			boolean fin = false;
			File f=new File("soybinario.out");
			FileInputStream fis=new FileInputStream(f);
			DataInputStream dis=new DataInputStream(fis);
			char c=dis.readChar();
			String s = "";
			while(!fin){
				c = dis.readChar();
				s = String.valueOf(s);
				if (s.matches("[a-zA-Z]")) {
					System.out.println(s+" ");
				}
			}
			fis.close();
			dis.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.\n"+e);
		}
	}
}