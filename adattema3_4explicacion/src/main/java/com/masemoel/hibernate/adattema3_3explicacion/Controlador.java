package com.masemoel.hibernate.adattema3_3explicacion;

import javax.swing.JOptionPane;

public class Controlador {
	ClienteDAOHibernate clidao = ClienteDAOHibernate.getInstance();
	PrestamoDAOHibernate presdao = PrestamoDAOHibernate.getInstance();
	VistaClientes vistacli = new VistaClientes();
	VistaPrestamos vistapres = new VistaPrestamos();
	
	public void insertarCli() {
		Cliente cli = vistacli.pideDatos();
		clidao.insert(cli);
		vistacli.mostrarClientes();
	}
	
	public void actualizarCli() {
		Cliente cli = null;
		vistacli.mostrarClientes();
		int id = vistacli.pideCodigo();
		cli = clidao.findByPk(id);
		if (cli == null) {
			System.out.println("No se ha encontrado un cliente con código "+id);
		} else {
			Cliente cli2 = vistacli.pideDatos();
			cli2.setIdCliente(id);
			clidao.update(cli2);
			vistacli.mostrarClientes();
		}
		vistacli.mostrarClientes();
	}
	
	public void eliminarCli() {
		Cliente cli = null;
		vistacli.mostrarClientes();
		int id = vistacli.pideCodigo();
		cli = clidao.findByPk(id);
		if (cli == null) {
			System.out.println("No se ha encontrado un cliente con código "+id);
		} else {
			String conf = JOptionPane.showInputDialog("¿Estás seguro de eliminar dicho cliente? 'S' / 'N'");
			if (conf.equalsIgnoreCase("s")) {
				clidao.delete(cli);
				vistacli.mostrarClientes();
			}
		}
	}
	
	public void muestraClientes() {
		vistacli.mostrarClientes();
	}
	
	public void muestraCliente() {
		Cliente cli = null;
		vistacli.mostrarClientes();
		int id = vistacli.pideCodigo();
		cli = clidao.findByPk(id);
		if (cli == null) {
			System.out.println("No se ha encontrado un cliente con código "+id);
		} else {
			vistacli.mostrarCliente(cli);
		}
	}
	
	public void insertarPres() {
		Cliente cli = null;
		int idcli = Integer.parseInt(JOptionPane.showInputDialog("ID del cliente"));
		cli = clidao.findByPk(idcli);
		if (cli == null) {
			System.out.println("No se ha encontrado un cliente con código "+idcli);
		} else {
			Prestamo pres = vistapres.pideDatos();
			cli.addPrestamo(pres);
			clidao.insert(cli);
			vistacli.mostrarClientes();
		}
	}
	
	public void actualizarPres() {
		Prestamo pres = null;
		vistacli.mostrarClientes();
		int id = vistacli.pideCodigo();
		pres = presdao.findByPk(id);
		if (pres == null) {
			System.out.println("No se ha encontrado un préstamo con código "+id);
		} else {
			Prestamo pres2 = vistapres.pideDatos();
			pres2.setIdPrestamo(id);
			pres2.setCliente(pres.getCliente());
			presdao.update(pres2);
			vistacli.mostrarCliente(pres2.getCliente());
		}
	}
	
	public void eliminarPres() {
		Prestamo pres = null;
		vistacli.mostrarClientes();
		int id = vistacli.pideCodigo();
		pres = presdao.findByPk(id);
		if (pres == null) {
			System.out.println("No se ha encontrado un préstamo con código "+id);
		} else {
			String conf = JOptionPane.showInputDialog("¿Estás seguro de eliminar dicho préstamo? 'S' / 'N'");
			if (conf.equalsIgnoreCase("s")) {
				Cliente cli = pres.getCliente();
				cli.removePrestamo(pres);
				presdao.delete(pres);
				vistacli.mostrarCliente(cli);
			}
		}
	}
	
	public void muestraPrestamos() {
		vistapres.mostrarPrestamos();
	}
	
	public void muestraPrestamo() {
		Prestamo pres = null;
		int id = vistacli.pideCodigo();
		pres = presdao.findByPk(id);
		if (pres == null) {
			System.out.println("No se ha encontrado un préstamo con código "+id);
		} else {
			vistapres.mostrarPrestamo(pres);
		}
	}
	
	public void finalizarPrograma() {
		try {
			presdao.closeDAO();
			clidao.closeDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Gracias. ¡Hasta pronto!");
	}
}