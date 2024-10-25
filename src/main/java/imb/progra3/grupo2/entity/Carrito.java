package imb.progra3.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Carrito;
    private double precio;
    private boolean enabled;
    
    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_Producto")
    private Producto producto;
    

    @ManyToOne
    @JoinColumn(name = "id_Venta")
    private Ventas ventas;

    // Constructor vacío requerido por JPA
    public Carrito() {
    }

    // Constructor con parámetros
    public Carrito(double precio, Cliente cliente, Producto producto, Ventas ventas) {
        this.precio = precio;
        this.cliente = cliente;
        this.producto = producto;
        this.ventas = ventas;
    }

    // Getters y setters
    public Long getId_Carrito() {
        return id_Carrito;
    }

    public void setId_Carrito(Long id_Carrito) {
        this.id_Carrito = id_Carrito;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

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
    

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return "Carrito{" +
                "id_Carrito=" + id_Carrito +
                ", precio=" + precio +
                ", cliente=" + cliente +
                ", producto=" + producto +
                ", ventas=" + ventas +
                '}';
   
}

	
}