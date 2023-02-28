package controladores;

import javax.swing.JOptionPane;

import daos.MongoUtil;
import daos.ProductoDAO;
import daos.VentaDAO;
import modelos.Producto;
import modelos.Venta;
import vistas.VistaProducto;
import vistas.VistaVenta;

public class Controlador {
	private static Controlador instance = null;
	private static ProductoDAO prodao =  null;
	private static VentaDAO vendao = null;
	private VistaProducto vistapro;
	private VistaVenta vistaven;
	
	protected Controlador() {
		prodao = ProductoDAO.getInstance();
		vendao = VentaDAO.getInstance();
		vistapro = new VistaProducto();
		vistaven = new VistaVenta();
	}
	
	public static Controlador getInstance() {
		if (instance == null) {
			instance = new Controlador();
		}
		return instance;
	}
	
	public void traerProductos() {
		vistapro.mostrarProductos();
	}
	
	public void traerProducto() {
		int codigo = -1;
		codigo = vistapro.pideCodigo();
		if (codigo != -1) {
			Producto producto = prodao.findByPk(codigo);
			vistapro.mostrarProducto(producto);
		}
	}
	
	public void agregarProducto() {
		int cod = vistapro.pideCodigo();
		Producto producto = prodao.findByPk(cod);
		if (producto != null) {
			JOptionPane.showMessageDialog(null, "El producto con código "+cod+" ya existe.");
		} else {
			Producto pro2 = vistapro.pideDatosPro();
			pro2.setCodigo(cod);
			prodao.agregar(pro2);
			vistapro.mostrarProductos();
		}
	}
	
	public void modificarProducto() {
		int cod = vistapro.pideCodigo();
		Producto producto = prodao.findByPk(cod);
		if (producto == null) {
			JOptionPane.showMessageDialog(null, "El producto con código "+cod+" no existe.");
		} else {
			Producto pro2 = vistapro.pideDatosPro();
			if (pro2 != null) {
				pro2.setCodigo(cod);
				prodao.modificar(pro2);
				vistapro.mostrarProductos();
			}
		}
	}
	
	public void eliminarProducto() {
		int cod = vistapro.pideCodigo();
		Producto producto = prodao.findByPk(cod);
		if (producto == null) {
			JOptionPane.showMessageDialog(null, "El producto con código "+cod+" no existe.");
		} else {
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?");
			if (respuesta == 0) {
				prodao.eliminar(producto);
			}
			vistapro.mostrarProductos();
		}
	}
	
	public void traerVentas() {
		vistaven.mostrarVentas();
	}
	
	public void traerVenta() {
		String nroTicket = vistaven.pideNroTicket();
		Venta venta = vendao.findByPk(nroTicket);
		if (venta != null) {
			vistaven.mostrarVenta(venta);
		}
	}
	
	public void agregarVenta() {
		String nroTicket = vistaven.pideNroTicket();
		Venta venta = vendao.findByPk(nroTicket);
		if (venta != null) {
			JOptionPane.showMessageDialog(null, "La venta con nº de ticket "+nroTicket+" ya existe.");
		} else {
			Venta ven2 = vistaven.pideDatosVen();
			ven2.setNroTicket(nroTicket);
			vendao.agregar(ven2);
			vistaven.mostrarVentas();
		}
	}
	
	public void modificarVenta() {
		String nroTicket = vistaven.pideNroTicket();
		Venta venta = vendao.findByPk(nroTicket);
		if (venta == null) {
			JOptionPane.showMessageDialog(null, "La venta con nº de ticket "+nroTicket+" no existe.");
		} else {
			Venta ven2 = vistaven.pideDatosVen();
			if (ven2 != null) {
				ven2.setNroTicket(nroTicket);;
				vendao.modificar(ven2);
				vistaven.mostrarVentas();
			}
		}
	}
	
	public void eliminarVenta() {
		String nroTicket = vistaven.pideNroTicket();
		Venta venta = vendao.findByPk(nroTicket);
		if (venta == null) {
			JOptionPane.showMessageDialog(null, "La venta con nº de ticket "+nroTicket+" no existe.");
		} else {
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar esta venta?");
			if (respuesta == 0) {
				vendao.eliminar(venta);
			}
			vistaven.mostrarVentas();
		}
	}
	
	public void finalizar() {
		JOptionPane.showMessageDialog(null, "Gracias. ¡Hasta pronto!");
		MongoUtil.cerrar();
	}
}