package com.masemoel.hibernate.adattema3_3explicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQuery (name="Cliente.findByNombre", query="SELECT c FROM Cliente c WHERE c.nombre LIKE :name")
public class Cliente implements Serializable {
	@Id
	@GeneratedValue
	private int idCliente;
	
	private int dni;
	private String nombre, apellido;
	private Date fechaNacimiento;
	private boolean baja;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Prestamo> prestamos = new ArrayList<>();
	
	public Cliente() {
		
	}

	public Cliente(int idCliente, int dni, String nombre, String apellido, Date fechaNacimiento, boolean baja, List<Prestamo> prestamos) {
		this.idCliente = idCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.baja = baja;
		this.prestamos = prestamos;
	}

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	@Override
	public String toString() {
		return "Cliente [Id cliente=" + idCliente + ", DNI=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha de nacimiento=" + fechaNacimiento + ", baja=" + baja + " y " + prestamos + "]";
	}
	
	public void addPrestamo(Prestamo prestamo) {
		prestamos.add(prestamo);
		prestamo.setCliente(this);
	}
	
	public void removePrestamo(Prestamo prestamo) {
		if (prestamos != null) {
			prestamos.remove(prestamo);
			prestamo.setCliente(null);
		}
	}
}