package vistas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import daos.PersonaDAO;
import modelos.Amigo;
import modelos.Persona;

public class VistaPersona {
	PersonaDAO perdao;
	
	public void mostrarPersonas() {
		PersonaDAO perdao = PersonaDAO.getInstance();
		String mensaje = "";
		List<Persona> lista_p = perdao.findAll();
		for (Persona p: lista_p) {
			mensaje = mensaje + p.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void mostrarPersona(Persona persona) {
		if (persona != null) {
			JOptionPane.showMessageDialog(null, persona);
		}
	}
	
	public String pideDNI() {
		String dni = JOptionPane.showInputDialog("Introduce el DNI de la persona:");
		return dni;
	}
	
	public Persona pideDatosPer() {
		Persona per = new Persona();
		String nombre, apellidos;
		int edad;
		List<String> aficciones = new ArrayList<>();
		perdao = PersonaDAO.getInstance();
		String anom, afic;
		int aedad;
		Amigo amigo;
		List<Amigo> amigos = new ArrayList<Amigo>();
		int resp = 0;
		try {
			nombre = JOptionPane.showInputDialog("Introduce su nombre:");
			apellidos = JOptionPane.showInputDialog("Introduce sus apellidos:");
			edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce su edad:"));
			do {
				afic = JOptionPane.showInputDialog("Introduce una aficción:");
				aficciones.add(afic);
				resp = JOptionPane.showConfirmDialog(null, "¿Deseas añadir otra aficción?");
			} while(resp == 0);
			resp = 0;
			do {
				anom = JOptionPane.showInputDialog("Introduce el nombre de su amigo:");
				aedad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la edad de su amigo:"));
				amigo = new Amigo(anom, aedad);
				amigos.add(amigo);
				resp = JOptionPane.showConfirmDialog(null, "¿Deseas añadir otro amigo?");
			} while(resp == 0);
			per.setNombre(nombre);
			per.setApellidos(apellidos);
			per.setEdad(edad);
			per.setAficciones(aficciones);
			per.setAmigos(amigos);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos.");
			return per;
		}
		
		return per;
	}
}