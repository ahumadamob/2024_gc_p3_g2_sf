package imb.progra3.grupo2.service;

import java.util.List;
import java.util.Optional;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.entity.Producto;

public interface ICarritoService {
    // Guarda un carrito
    Carrito saveCarrito(Carrito carrito);

    // Obtiene un carrito por su ID
    Optional<Carrito> getCarritoById(Long id);

    // Elimina un carrito por su ID
    void deleteCarrito(Long id);

    // Obtiene todos los carritos
    List<Carrito> getAllCarritos();
    
    // Verifica el stock de los productos en el carrito de un cliente
    List<Producto> verificarStock(Long clienteId);
    
    // Verifica si un carrito existe
    boolean exists(Long id);
}