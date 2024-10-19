package imb.progra3.grupo2.service.jpa;

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
        try {
            // Busca el cliente por su ID
            Cliente cliente = clienteRepository.findById(clienteId)
                    .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado con ID: " + clienteId));

            // Busca el carrito asociado a ese cliente
            Optional<Carrito> carrito = carritoRepository.findByCliente(cliente);

            if (carrito.isPresent()) {
                List<ItemCarrito> items = carrito.get().getItems();  // Obtiene los productos del carrito
                if (items.isEmpty()) {
                    throw new NoSuchElementException("El carrito está vacío.");
                }
                return productoService.verificarStock(items);  // Llama al servicio de producto para verificar stock
            }

            // Si no se encuentra el carrito, lanzar una excepción
            throw new NoSuchElementException("Carrito no encontrado para el cliente con ID: " + clienteId);
        } catch (Exception e) {
            // Manejo de log aquí (si estás usando un logger)
            throw new RuntimeException("Error al verificar el stock: " + e.getMessage());
        }
    }

    @Override
    public boolean exists(Long id) {
        return carritoRepository.existsById(id);
    }
}
