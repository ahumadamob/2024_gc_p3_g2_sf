package imb.progra3.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Compra extends BaseEntity{

    

   
    @ManyToOne
    @JoinColumn(name = "cliente_id")  // Nombre de la columna en la base de datos para Cliente
    private Cliente cliente;

    
    @ManyToOne
    @JoinColumn(name = "producto_id")  // Nombre de la columna en la base de datos para Producto
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
