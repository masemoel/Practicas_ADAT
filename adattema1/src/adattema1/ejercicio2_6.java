package adattema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/*
 * Manuel José Moral Eliche
 * Ejercicio 2.6 - Acceso a datos
 */
public class ejercicio2_6 {
	public static void main(String[] args) {
		try {
			String salida = "";
			File file = new File(JOptionPane.showInputDialog("Introduce el nombre del fichero:"));
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String texto = JOptionPane.showInputDialog("Introduce el texto a guardar en el fichero:");
			bufferedWriter.write(texto);
			fileWriter.close();
			bufferedWriter.close();
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			do {
				salida += s;
				s = br.readLine();
			} while(s != null);
			fr.close();
			br.close();
			JOptionPane.showMessageDialog(null, salida);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo especificado.");
		}
	}
}