package imb.progra3.grupo2.dto;

import imb.progra3.grupo2.entity.Cliente;
import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.entity.Ventas;

public class CarritoRequestDTO {
	private Cliente cliente;
	private Producto producto;
	private Ventas ventas;
	private boolean enabled;
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Ventas getVentas() {
		return ventas;
	}
	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
