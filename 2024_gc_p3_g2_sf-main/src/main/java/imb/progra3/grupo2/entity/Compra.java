package imb.progra3.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Compra extends BaseEntity{

    

   
    @ManyToOne
    private Cliente cliente;

    
    @ManyToOne
    private Producto producto;

    
    // Getters y setters


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

   


}
