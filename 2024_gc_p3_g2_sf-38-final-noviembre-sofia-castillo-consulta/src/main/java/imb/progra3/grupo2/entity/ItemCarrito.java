package imb.progra3.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class ItemCarrito extends BaseEntity{

   
	//TODO: Crear validaciones acordes para estas propiedades
	@ManyToOne
    private Carrito carrito;

	@ManyToOne
    private Producto producto;

    private Integer cantidad;
    

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.cantidad = cantidad;
    }
}
