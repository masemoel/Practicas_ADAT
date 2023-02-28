package vistas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import daos.ProductoDAO;
import daos.VentaDAO;
import modelos.DetalleVenta;
import modelos.Producto;
import modelos.Venta;

public class VistaVenta {
	ProductoDAO prodao;
	
	public void mostrarVentas() {
		VentaDAO vendao = VentaDAO.getInstance();
		String mensaje = "";
		List<Venta> lista_ven = vendao.findAll();
		for (Venta v: lista_ven) {
			mensaje = mensaje + v.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void mostrarVenta (Venta venta) {
		if (venta != null) {
			JOptionPane.showMessageDialog(null, venta);
		}
	}
	
	public String pideNroTicket() {
		String nroTicket = JOptionPane.showInputDialog("Introduce el número de ticket de la venta:");
		return nroTicket;
	}
	
	public Venta pideDatosVen() {
		Venta ven = new Venta();
		String 	formaPago;
		double precioTotal = 0;
		DetalleVenta dv;
		List<DetalleVenta> lista_det = new ArrayList<DetalleVenta>();
		prodao = ProductoDAO.getInstance();
		int cod;
		Producto producto;
		int cantidad;
		double subTotal;
		String resp;
		try {
			do {
				cod = Integer.parseInt(JOptionPane.showInputDialog("Introduce el código del producto:"));
				producto = prodao.findByPk(cod);
				cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad:"));
				subTotal = cantidad * producto.getPrecio();
				precioTotal = precioTotal + subTotal;
				dv = new DetalleVenta();
				dv.setProducto(producto);
				dv.setCantidad(cantidad);
				dv.setSubTotal(subTotal);
				lista_det.add(dv);
				resp = JOptionPane.showInputDialog("¿Deseas añadir otro producto? 'S'/'N'");
			} while(resp.equalsIgnoreCase("s"));
			formaPago = JOptionPane.showInputDialog("Introduce la forma de pago:");
			ven.setFormaPago(formaPago);
			ven.setPrecioTotal(precioTotal);
			ven.setDetalleVentas(lista_det);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos.");
			return ven;
		}
		
		return ven;
	}
}