package imb.progra3.grupo2.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Carrito extends BaseEntity{

   

   
    @ManyToOne
    private Cliente cliente;

    
    @OneToMany
    private List<ItemCarrito> items = new ArrayList<>();
    

    private boolean enabled;

    // Otros campos, getters y setters

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // Getters y Setters
  

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }

    // Métodos para manejar la relación bidireccional
    public void addItem(ItemCarrito item) {
        items.add(item);
        item.setCarrito(this);
    }

    public void removeItem(ItemCarrito item) {
        items.remove(item);
        item.setCarrito(null);
    }
    
    

    

    // Método para agregar un producto al carrito
    public void agregarProducto(Producto producto, Integer cantidad) {
        // Verifica si el producto ya existe en el carrito
        for (ItemCarrito item : items) {
            if (item.getProducto().equals(producto)) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        ItemCarrito item = new ItemCarrito();
        item.setProducto(producto);
        item.setCantidad(cantidad);
        this.addItem(item);
    }

    // Método para calcular el total del carrito
    public Double calcularTotal() {
        return items.stream()
                    .mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidad())
                    .sum();
    }
}

	
