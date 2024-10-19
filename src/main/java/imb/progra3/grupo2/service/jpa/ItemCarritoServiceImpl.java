package imb.progra3.grupo2.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.ItemCarrito;
import imb.progra3.grupo2.repository.ItemCarritoRepository;
import imb.progra3.grupo2.service.IItemCarritoService;

@Service
public class ItemCarritoServiceImpl implements IItemCarritoService {
    
    @Autowired
    private ItemCarritoRepository itemCarritoRepository;

    @Override
    public ItemCarrito saveItemCarrito(ItemCarrito itemCarrito) {
        // Asegúrate de que el Producto relacionado esté guardado antes de guardar el ItemCarrito
        if (itemCarrito.getProducto() == null || itemCarrito.getProducto().getId_producto() == null) {
            throw new IllegalArgumentException("El Producto debe estar guardado antes de crear un ItemCarrito.");
        }
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
}


