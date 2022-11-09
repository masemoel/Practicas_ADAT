package canciones;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinaryMain {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioCanciones.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		int anno[] = {2008, 2019, 2014, 2010, 2007};
		String titulo[] = {"Umbrella", "Despacito", "Happy", "Alejandro", "Pokerface"};
		String artista[] = {"Rihanna", "Luis Fonsi", "Phil", "Lady Gaga", "Lady Gaga"};
		float duracion[] = {4.00f, 3.47f, 4.34f, 5.49f, 4.47f};
		int esp[] = {0, 1, 0, 0, 0};
		StringBuffer buffer1 = null;
		StringBuffer buffer2 = null;
		int n = titulo.length;
		for (int i=0; i<n; i++) {
			file.writeInt(i+1);
			file.writeInt(anno[i]);
			buffer1=new StringBuffer(titulo[i]);
			buffer1.setLength(20);
			file.writeChars(buffer1.toString());
			buffer2=new StringBuffer(artista[i]);
			buffer2.setLength(20);
			file.writeChars(buffer2.toString());
			file.writeFloat(duracion[i]);
			file.writeInt(esp[i]);
		}
		file.close();
	}
}