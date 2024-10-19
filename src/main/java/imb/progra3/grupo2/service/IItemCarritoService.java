package imb.progra3.grupo2.service;

import java.util.List;
import java.util.Optional;

import imb.progra3.grupo2.entity.ItemCarrito;

public interface IItemCarritoService {
    ItemCarrito saveItemCarrito(ItemCarrito itemCarrito); // Guardar un ItemCarrito
    Optional<ItemCarrito> getItemCarritoById(Long id);    // Obtener un ItemCarrito por ID
    List<ItemCarrito> getAllItemsInCarrito(Long carritoId); // Obtener todos los items de un carrito
    void deleteItemCarrito(Long id);                       // Eliminar un ItemCarrito por ID
}
