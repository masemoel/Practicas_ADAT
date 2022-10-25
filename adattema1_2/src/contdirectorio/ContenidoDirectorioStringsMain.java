package contdirectorio;

import java.io.File;
import java.text.SimpleDateFormat;

public class ContenidoDirectorioStringsMain {
	public static void main(String[] args) {
		String sCarAct = System.getProperty("user.dir");
		File f = new File(sCarAct);
		String[] listado = f.list();
		if (listado == null || listado.length == 0) {
			System.out.println("No hay elementos dentro de la carpeta actual.");
			return;
		} else {
			for (int i=0;i<listado.length;i++) {
				System.out.println(listado[i]);
			}
		}
		
		File[] archivos = f.listFiles();
		if (archivos == null || archivos.length == 0) {
			System.out.println("No hay elementos dentro de la carpeta actual.");
			return;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			for (int i=0;i<archivos.length;i++) {
				System.out.println(archivos[i]);
				File archivo = archivos[i];
				System.out.println(String.format("%s (%s) - %d - %s",
			                archivo.getName(),
			                archivo.isDirectory() ? "Carpeta" : "Archivo",
			                archivo.length(),
			                sdf.format(archivo.lastModified())
			                ));
			}
		}
	}
}