package canciones;

import java.io.File;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class BinToXML {
	public static void main(String[] args) throws Exception {
		File fichero = new File("AleatorioCanciones.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		
		int id, anno, esp, posicion=0;
		float duracion;
		char titulo[] = new char[20], aux1;
		char artista[] = new char[20], aux2;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null,"Canciones",null);
			document.setXmlVersion("1.0");
			
			for (;;) {
				file.seek(posicion);
				id=file.readInt();
				for(int i=0; i<titulo.length; i++) {
					aux1 = file.readChar();
					titulo[i]=aux1;
				}
				String tituloS=new String(titulo);
				for(int i=0; i<artista.length; i++) {
					aux2 = file.readChar();
					artista[i]=aux2;
				}
				String artistaS=new String(artista);
				duracion=file.readFloat();
				anno=file.readInt();
				esp=file.readInt();
				if (id>0) {
					Element raiz = document.createElement("cancion");
					document.getDocumentElement().appendChild(raiz);
					CrearElemento("id", Integer.toString(id), raiz, document);
					CrearElemento("titulo", tituloS.trim(), raiz, document);
					CrearElemento("artista", artistaS.trim(), raiz, document);
					CrearElemento("duracion", Float.toString(duracion), raiz, document);
					CrearElemento("anno", Integer.toString(anno), raiz, document);
					if (esp==1) {
						CrearElemento("Española", "Sí", raiz, document);
					} else {
						CrearElemento("Española", "No", raiz, document);
					}
				}
				posicion=posicion+96;
				if (file.getFilePointer() == file.length()) break;
			}
			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("Canciones.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		file.close();
	}
	
	private static void CrearElemento(String datoCancion, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoCancion);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
}