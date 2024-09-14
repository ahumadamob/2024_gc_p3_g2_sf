package imb.progra3.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemCarrito {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idItemCarrito;

	    private Integer cantidad;

	    private Long idProducto;

	    @ManyToOne
	    @JoinColumn(name = "carrito_id") // Nombre de la columna en ItemCarrito
	    private Carrito carrito;

	    // Getters y Setters
	    public Long getIdItemCarrito() {
	        return idItemCarrito;
	    }

	    public void setIdItemCarrito(Long idItemCarrito) {
	        this.idItemCarrito = idItemCarrito;
	    }

	    public Integer getCantidad() {
	        return cantidad;
	    }

	    public void setCantidad(Integer cantidad) {
	        this.cantidad = cantidad;
	    }

	    public Long getIdProducto() {
	        return idProducto;
	    }

	    public void setIdProducto(Long idProducto) {
	        this.idProducto = idProducto;
	    }

	    public Carrito getCarrito() {
	        return carrito;
	    }

	    public void setCarrito(Carrito carrito) {
	        this.carrito = carrito;
	    }
	}