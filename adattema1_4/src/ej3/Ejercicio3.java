package ej3;

import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.Arrays;
//import java.util.Scanner;

/*
 * Manuel José Moral Eliche
 * Ejercicio 4.3 - Acceso a datos
 */
public class Ejercicio3 {
	public static void main(String[] args) {
		// Petición al usuario de datos
		//Scanner in = new Scanner(System.in);
		//in.delimiter("\n");
		//System.out.print("Escribe el primer directorio: ");
		//String userdir1 = in.next();
		//System.out.print("Escribe el segundo directorio: ");
		//String userdir2 = in.next();
		//in.close();
		//File file1 = new File(userdir1);
		//File file2 = new File(userdir2);
		
		File file1 = new File("C:\\\\Users\\Masemo\\eclipse-adat\\adattema1_4");
		File file2 = new File("C:\\\\Users\\Masemo\\Desktop");
		int cont=0;
		if (file1.exists() && file2.exists()) {
			File[] archivosf1 = file1.listFiles();
			File[] archivosf2 = file2.listFiles();
			for (int i=0;i<archivosf1.length;i++) {
				if (archivosf1[i].isFile()) {
					for (int y=0;y<archivosf2.length;y++) {
						if (archivosf2[y].isFile()) {
							try {
								byte[] hash1 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(archivosf1[i].toPath()));
								byte[] hash2 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(archivosf2[y].toPath()));
								if (Arrays.equals(hash1, hash2)) {
									System.out.println("Los ficheros "+archivosf1[i]+" y "+archivosf2[y]+" tienen el mismo contenido.");
									cont++;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		if (cont>0) {
			System.out.println("\nLos directorios tenían "+cont+" ficheros iguales.");
		} else {
			System.out.println("Los directorios no tenían ficheros iguales.");
		}
	}
}