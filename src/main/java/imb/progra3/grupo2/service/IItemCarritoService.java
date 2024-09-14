package imb.progra3.grupo2.service;

import java.util.List;
import java.util.Optional;

import imb.progra3.grupo2.entity.ItemCarrito;

public interface IItemCarritoService {
	ItemCarrito saveItemCarrito(ItemCarrito itemCarrito);
    Optional<ItemCarrito> getItemCarritoById(Long id);
    List<ItemCarrito> getAllItemsInCarrito(Long carritoId);
    void deleteItemCarrito(Long id);

    List<ItemCarrito> verificarStock(Long carritoId);
}
