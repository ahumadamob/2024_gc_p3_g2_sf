package imb.progra3.grupo2.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import imb.progra3.grupo2.entity.ItemCarrito;
import imb.progra3.grupo2.repository.ItemCarritoRepository;
import imb.progra3.grupo2.service.IItemCarritoService;

public class ItemCarritoServiceImpl implements IItemCarritoService  {
	 @Autowired
	    private ItemCarritoRepository itemCarritoRepository;

	@Override
	public ItemCarrito saveItemCarrito(ItemCarrito itemCarrito) {
		return itemCarritoRepository.save(itemCarrito);
	}

	@Override
	public Optional<ItemCarrito> getItemCarritoById(Long id) {
		 return itemCarritoRepository.findById(id);
	}

	@Override
	public List<ItemCarrito> getAllItemsInCarrito(Long carritoId) {
		return itemCarritoRepository.findByCarritoId(carritoId);
	}

	@Override
	public void deleteItemCarrito(Long id) {
		 itemCarritoRepository.deleteById(id);
		
	}

	@Override
	public List<ItemCarrito> verificarStock(Long carritoId) {
		List<ItemCarrito> itemsEnCarrito = itemCarritoRepository.findByCarritoId(carritoId);
        // Aquí deberías integrar la lógica real para consultar el stock
        return itemsEnCarrito.stream()
            .filter(item -> !esStockSuficiente(item.getIdProducto(), item.getCantidad()))
            .toList();
    }

    private boolean esStockSuficiente(Long productoId, Integer cantidadRequerida) {
        // Implementar lógica real de verificación de stock aquí
        // Este es solo un ejemplo
        return true; // Cambia esto a la lógica real
    }

}
