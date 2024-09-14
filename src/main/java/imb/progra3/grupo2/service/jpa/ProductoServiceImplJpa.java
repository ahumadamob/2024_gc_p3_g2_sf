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
public class ProductoServiceImplJpa implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getById(Long id_Producto) {
        Optional<Producto> productoOptional = productoRepository.findById(id_Producto);
        return productoOptional.orElse(null);
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
        List<Producto> productosSinStock = new ArrayList<>();
        for (ItemCarrito item : items) {
            Optional<Producto> productoOpt = productoRepository.findById(item.getIdProducto());
            if (productoOpt.isPresent()) {
                Producto producto = productoOpt.get();
                if (producto.getStock() < item.getCantidad()) {
                    productosSinStock.add(producto);
                }
            }
        }
        return productosSinStock;
    }
}
