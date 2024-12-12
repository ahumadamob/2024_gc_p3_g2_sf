package imb.progra3.grupo2.service.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.ItemCarrito;
import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.repository.ProductoRepository;
import imb.progra3.grupo2.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getById(Long id_Producto) {
        return productoRepository.findById(id_Producto);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void delete(Long id_Producto) {
        productoRepository.deleteById(id_Producto);
    }

    @Override
    public boolean exists(Long id_Producto) {
        return productoRepository.existsById(id_Producto);
    }

    
    @Override
    public List<Producto> verificarStock(List<ItemCarrito> items) {
        List<Producto> productosConStock = new ArrayList<>();

        for (ItemCarrito item : items) {
            // Verifica que el item tenga un producto asociado
            if (item.getProducto() != null) {
                // Obtén el ID del producto desde el item
                //Long productoId = item.getProducto().getId(); // Asegúrate de que getId() esté correctamente implementado

                // Busca el producto por ID usando productoRepository
                //Optional<Producto> productoOpt = productoRepository.findById(productoId);
                
            	/*if (productoOpt.isPresent()) {
                    Producto productoConStock = productoOpt.get();

                    // Verifica que el stock sea suficiente
                    if (productoConStock.getStock() >= item.getCantidad()) {
                        productosConStock.add(productoConStock);
                    }
                } else {
                    // Aquí puedes manejar el caso donde el producto no se encuentra, si es necesario
                    // Por ejemplo, podrías lanzar una excepción o registrar un mensaje.
                }*/
            } else {
                // Manejo del caso donde el item no tiene un producto asociado
                // Podrías lanzar una excepción o registrar un mensaje.
            }
        }

        return productosConStock;
    }


}
