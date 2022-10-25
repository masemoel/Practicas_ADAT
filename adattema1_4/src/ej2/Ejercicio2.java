package ej2;

import java.io.File;
import java.text.SimpleDateFormat;

/*
 * Manuel José Moral Eliche
 * Ejercicio 4.2 - Acceso a datos
 */
public class Ejercicio2 {
	public static void main(String[] args) {
		String sCarAct = System.getProperty("user.dir");
		File f = new File(sCarAct);
		File[] archivos = f.listFiles();
		if (archivos == null || archivos.length == 0) {
			System.out.println("No hay elementos dentro de la carpeta actual.");
			return;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			for (int i=0;i<archivos.length;i++) {
				System.out.println(archivos[i]);
				File archivo = archivos[i];
				System.out.print(String.format("%s (%s) - %d - %s", 
						archivo.getName(), archivo.isDirectory() ? "Carpeta" : "Archivo", 
						archivo.length(), sdf.format(archivo.lastModified())));
				System.out.print(" Permisos: ");
				if (archivo.canRead()) {
					System.out.print("r");
				} else {
					System.out.print("-");
				}
				if (archivo.canWrite()) {
					System.out.print("w");
				} else {
					System.out.print("-");
				}
				if (archivo.canExecute()) {
					System.out.print("x");
				} else {
					System.out.print("-");
				}
				System.out.println("");
			}
		}
	}
}