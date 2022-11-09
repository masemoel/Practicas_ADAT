package ej2;

import java.io.Serializable;

/*
 * Manuel José Moral Eliche
 * Acceso a datos - Examen tema 1 - Ejercicio 2
 */
public class Item_de_compra implements Serializable {
	// Variables
	private int codigo;
	private String articulo;
	private float precio;
	private String marca;
	
	// Constructor
	public Item_de_compra(int codigo, String articulo, float precio, String marca) {
		setCodigo(codigo);
		setArticulo(articulo);
		setPrecio(precio);
		setMarca(marca);
	}
	
	// Getters y setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	// Métodos generales
	@Override
	public String toString() {
		return "Ítem [código=" + codigo + ", artículo=" + articulo + ", precio=" + precio + ", marca=" + marca + "]";
	}
}