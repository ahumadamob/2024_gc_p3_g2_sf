package imb.progra3.grupo2.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.repository.CarritoRepository;
import imb.progra3.grupo2.service.ICarritoService;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImplJpa implements ICarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

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
        // Implementación pendiente. Aquí puedes usar lógica para verificar el stock.
        throw new UnsupportedOperationException("Método no implementado aún.");
    }

    @Override
    public boolean exists(Long id) {
        return id != null && carritoRepository.existsById(id);
    }

    @Override
    public List<Carrito> getAllEnabled() {
        // Llama al repositorio para obtener los carritos habilitados
        return carritoRepository.findByEnabledTrue();
    }

    @Override
    public List<Carrito> getAllDisabled() {
        // Llama al repositorio para obtener los carritos deshabilitados
        return carritoRepository.findByEnabledFalse();
    }
    
    @Override
    public Carrito getByClienteId(Long clienteId) {
        return carritoRepository.findByClienteId(clienteId)
                .orElse(null); // Asegúrate de que `findByClienteId` esté implementado en el repositorio
    }

  
    
}

