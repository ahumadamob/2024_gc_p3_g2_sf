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
//cambios nevos
    @Override 
    public Carrito saveCarrito(Carrito carrito) {
         if (carrito.getCliente() == null || carrito.getCliente().getId() == null) {
            throw new IllegalArgumentException("Cliente no válido");
        }
        if (!carrito.isEnabled()) {
            throw new IllegalStateException("El carrito debe estar habilitado");
        }
        if (carrito.getVentas() == null || carrito.getVentas().getId() == null || 
            !carritoRepository.existsByVentasIdAndEnabledTrue(carrito.getVentas().getId())) {
            throw new IllegalStateException("La venta asociada no existe o no está activa");
        }
        return carritoRepository.save(carrito);
    }

	@Override
	public Optional<Carrito> getCarritoById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteCarrito(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Carrito> getAllCarritos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> verificarStock(Long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Carrito> getAllEnabled() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carrito> getAllDisabled() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrito getByClienteId(Long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsByVentasIdAndEnabledTrue(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
    
    // Other methods remain unchanged...
}
