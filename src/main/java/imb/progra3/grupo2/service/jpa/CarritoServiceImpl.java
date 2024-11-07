package imb.progra3.grupo2.service.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.entity.Cliente;
import imb.progra3.grupo2.entity.ItemCarrito;
import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.repository.CarritoRepository;
import imb.progra3.grupo2.repository.ClienteRepository;
import imb.progra3.grupo2.service.ICarritoService;
import imb.progra3.grupo2.service.IProductoService;

@Service
public class CarritoServiceImpl implements ICarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private IProductoService productoService;  // Inyección de productoService

    @Autowired
    private ClienteRepository clienteRepository;  // Repositorio para buscar al cliente

    @Override
    public Carrito saveCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public Optional<Carrito> getCarritoById(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public void deleteCarrito(Long id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public List<Carrito> getAllCarritos() {
        return carritoRepository.findAll();
    }
    
    @Override
    public List<Producto> verificarStock(Long clienteId) {
        // Obtener el carrito del cliente por su ID
        Carrito carrito = carritoRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Carrito no encontrado para el cliente"));

        List<Producto> productosSinStock = new ArrayList<>();

        // Iterar sobre los items en el carrito y verificar el stock de cada producto
        for (ItemCarrito item : carrito.getItems()) {
            Producto producto = item.getProducto();

            if (producto.getStock() < item.getCantidad()) {
                productosSinStock.add(producto);
            }
        }

        return productosSinStock;
    }

    @Override
    public boolean exists(Long id) {
        return carritoRepository.existsById(id);
    }
}
