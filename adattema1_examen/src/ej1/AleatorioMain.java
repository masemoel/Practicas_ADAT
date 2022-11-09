package ej1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Manuel José Moral Eliche
 * Acceso a datos - Examen tema 1 - Ejercicio 1
 */
public class AleatorioMain {
	public static void main(String[] args) throws IOException {
		// Escritura del archivo aleatorio
		File fichero = new File("AleatorioEj1Examen.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		int numi[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		String cadenas[] = {"Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Once", "Doce", "Trece", "Catorce", "Quince", "Dieciséis", "Diecisiete", "Dieciocho", "Diecinueve", "Veinte"};
		float numsf[] = {0.0125f, 0.2f, 0.0345f, 0.5f, 0.0128f, 0.7f, 0.375f, 0.25f, 0.0128f, 0.256f, 0.0101f, 0.512f, 0.01024f, 0.29f, 0.2048f, 0.8f, 0.9f, 0.001f, 0.08765f, 0.999f};
		StringBuffer buffer = null;
		int n = cadenas.length;
		for (int i=0; i<n; i++) {
			buffer=new StringBuffer(cadenas[i]);
			buffer.setLength(17);
			file.writeChars(buffer.toString());
			file.writeInt(numi[i]);
			file.writeFloat(numsf[i]);
		}
		
		// Lectura del archivo aleatorio
		int nuumi, posicion=0, aleatorionum=0;
		float nuumf;
		char cadenaas[] = new char[17];
		while (aleatorionum==0) {
			aleatorionum = (int)(Math.random()*20+1); // Generar número aleatorio entre 1 y 20.
		}
		for (;;) {
			file.seek(posicion);
			for (int i = 0; i < cadenaas.length; i++) {
				cadenaas[i] = file.readChar();
			}
			String cadena = new String(cadenaas);
			nuumi = file.readInt();
			nuumf = file.readFloat();
			if (nuumi == aleatorionum) {
				System.out.println("Número entero: " + nuumi + ", cadena: " + cadena + ", número float: " + nuumf);
			}
			posicion = posicion + 42;
			if (file.getFilePointer() == file.length())
				break;
		}
		file.close();
	}
}