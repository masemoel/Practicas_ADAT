package modelos;

import java.util.List;

public class Venta {
	private String nroTicket, formaPago;
	private double precioTotal = 0;
	private List<DetalleVenta> detalleVentas;
	
	public Venta() {
		
	}

	public Venta(String nroTicket, String formaPago, double precioTotal, List<DetalleVenta> detalleVentas) {
		this.nroTicket = nroTicket;
		this.formaPago = formaPago;
		this.precioTotal = precioTotal;
		this.detalleVentas = detalleVentas;
	}

	public String getNroTicket() {
		return nroTicket;
	}
	public void setNroTicket(String nroTicket) {
		this.nroTicket = nroTicket;
	}

	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public List<DetalleVenta> getDetalleVentas() {
		return detalleVentas;
	}
	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

	@Override
	public String toString() {
		return "Venta [número ticket=" + nroTicket + ", forma de pago=" + formaPago + ", precio total=" + precioTotal + " y " + detalleVentas + "]";
	}
}