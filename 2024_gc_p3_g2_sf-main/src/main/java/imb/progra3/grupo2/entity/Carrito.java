package imb.progra3.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Carrito extends BaseEntity{
   
    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    //TODO: Producto ya se repite en el item y no debería estar aquí
    private Producto producto;    

    @ManyToOne
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
//cambios

}

