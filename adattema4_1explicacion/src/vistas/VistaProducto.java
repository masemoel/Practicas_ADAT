package vistas;

import java.util.List;

import javax.swing.JOptionPane;

import daos.ProductoDAO;
import modelos.Producto;

public class VistaProducto {
	public void mostrarProductos() {
		ProductoDAO prodao = ProductoDAO.getInstance();
		String mensaje = "";
		List<Producto> lista_pro = prodao.findAll();
		for(Producto p: lista_pro) {
			mensaje = mensaje + p.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void mostrarProducto(Producto producto) {
		if (producto != null) {
			JOptionPane.showMessageDialog(null, producto);
		}
	}
	
	public int pideCodigo() {
		int codigo = -1;
		try {
			codigo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el código del producto:"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El código debe ser un número entero.");
			return codigo;
		}
		return codigo;
	}
	
	public Producto pideDatosPro() {
		Producto pro = new Producto();
		String tipoProducto, descripcion, laboratorio;
		double precio;
		try {
			tipoProducto = JOptionPane.showInputDialog("Introduce el tipo de producto:");
			descripcion = JOptionPane.showInputDialog("Introduce la descripción del producto:");
			laboratorio = JOptionPane.showInputDialog("Introduce el laboratorio del producto:");
			precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del producto (x.xx):"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos.");
			return pro;
		}
		pro.setTipoProducto(tipoProducto);
		pro.setDescripcion(descripcion);
		pro.setLaboratorio(laboratorio);
		pro.setPrecio(precio);
		return pro;
	}
}