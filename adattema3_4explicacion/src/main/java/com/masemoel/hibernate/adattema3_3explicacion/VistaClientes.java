package com.masemoel.hibernate.adattema3_3explicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class VistaClientes {
	VistaPrestamos vistapres;
	
	public void mostrarClientes() {
		ClienteDAOHibernate clidao = ClienteDAOHibernate.getInstance();
		List<Cliente> lista_cli = clidao.findAll();
		for (Cliente c: lista_cli) {
			mostrarCliente(c);
		}
	}
	
	public void mostrarCliente(Cliente c) {
		System.out.println(c);
	}
	
	public int pideCodigo() {
		int cod = -1;
		System.out.println("Introduzca el código");
		try {
			cod = Integer.parseInt(JOptionPane.showInputDialog("Código"));
		} catch (Exception e) {
			System.out.println("El código debe ser un número entero.");
			e.printStackTrace();
			return cod;
		}
		return cod;
	}
	
	public Cliente pideDatos() {
		Cliente cliente = new Cliente();
		int dni;
		String nombre, apellido, resp;
		boolean baja;
		try {
			dni = Integer.parseInt(JOptionPane.showInputDialog("DNI"));
			nombre = JOptionPane.showInputDialog("Nombre");
			apellido = JOptionPane.showInputDialog("Apellidos");
			resp = JOptionPane.showInputDialog("¿Está de baja? 'S' / 'N'");
			if (resp.equalsIgnoreCase("s")) {
				baja = true;
			} else {
				baja = false;
			}			
		} catch (Exception e) {
			System.out.println("Datos incorrectos.");
			e.printStackTrace();
			return cliente;
		}
		String f = JOptionPane.showInputDialog("Fecha de nacimiento (dd/MM/yyyy)");
		Date fechaNac = null;
		try {
			fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(f);
		} catch (Exception e) {
			System.out.println("Fecha incorrecta. Introdúcela con el formato dd/MM/yyyy");
			e.printStackTrace();
			return cliente;
		}
		cliente.setDni(dni);
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setBaja(baja);
		cliente.setFechaNacimiento(fechaNac);
		return cliente;
	}
}