package controladores;

import javax.swing.JOptionPane;

import daos.MongoUtil;
import daos.PersonaDAO;
import modelos.Persona;
import vistas.VistaPersona;

public class Controlador {
	private static Controlador instance = null;
	private static PersonaDAO perdao =  null;
	private VistaPersona vistaper;
	
	protected Controlador() {
		perdao = PersonaDAO.getInstance();
		vistaper = new VistaPersona();
	}
	
	public static Controlador getInstance() {
		if (instance == null) {
			instance = new Controlador();
		}
		return instance;
	}
	
	public void traerPersonas() {
		vistaper.mostrarPersonas();
	}
	
	public void traerPersona() {
		String dni = vistaper.pideDNI();
		if (dni != "" || dni != null) {
			Persona persona = perdao.findByPk(dni);
			vistaper.mostrarPersona(persona);
		}
	}
	
	public void agregarPersona() {
		String dni = vistaper.pideDNI();
		Persona persona = perdao.findByPk(dni);
		if (persona != null) {
			JOptionPane.showMessageDialog(null, "La persona con DNI "+dni+" ya existe.");
		} else {
			Persona per2 = vistaper.pideDatosPer();
			per2.setDni(dni);
			perdao.agregar(per2);
			vistaper.mostrarPersonas();
		}
	}
	
	public void modificarPersona() {
		String dni = vistaper.pideDNI();
		Persona persona = perdao.findByPk(dni);
		if (persona == null) {
			JOptionPane.showMessageDialog(null, "La persona con DNI "+dni+" no existe.");
		} else {
			Persona per2 = vistaper.pideDatosPer();
			if (per2 != null) {
				per2.setDni(dni);
				perdao.modificar(per2);
				vistaper.mostrarPersonas();
			}
		}
	}
	
	public void eliminarPersona() {
		String dni = vistaper.pideDNI();
		Persona persona = perdao.findByPk(dni);
		if (persona == null) {
			JOptionPane.showMessageDialog(null, "La persona con DNI "+dni+" no existe.");
		} else {
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?");
			if (respuesta == 0) {
				perdao.eliminar(persona);
			}
			vistaper.mostrarPersonas();
		}
	}
	
	public void finalizar() {
		JOptionPane.showMessageDialog(null, "Gracias. ¡Hasta pronto!");
		MongoUtil.cerrar();
	}
}