package ej4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/*
 * Manuel José Moral Eliche
 * Ejercicio 4.4 - Acceso a datos
 */
public class Ejercicio4 {
	private static void copiaDirectorio(String origen, String destino) throws IOException {
		File[] contenido = new File(origen).listFiles();
		
		if(!new File(destino).exists()) {
			new File(destino).mkdir();
		}
		
		for (File file:contenido) {
			String nombre_archivo = file.getName();
			if (file.isFile()) {
				File archivo_destino = new File(destino+"\\"+nombre_archivo);
				Files.copy(file.toPath(), archivo_destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} else {
				String nuevo_directorio = (destino+"\\"+nombre_archivo);
				new File(nuevo_directorio).mkdir();
				copiaDirectorio(file.getPath(), nuevo_directorio);
			}
		}
	}
	
	public static void main(String[] args) {
		String directorio_origen = "C:\\\\Users\\\\Masemo\\eclipse-workspace\\adattema1_4";
		String directorio_destino = "C:\\\\Users\\Masemo\\Desktop";
		
		try {
			copiaDirectorio(directorio_origen, directorio_destino);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}