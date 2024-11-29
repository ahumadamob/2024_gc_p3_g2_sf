package imb.progra3.grupo2.service.jpa;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.Pago;
import imb.progra3.grupo2.repository.PagoRepository;
import imb.progra3.grupo2.service.IPagoService;

@Service
public class PagoServiceImplJpa implements IPagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago findById(Long id) {
        // Verificar si el ID es válido antes de buscar
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        return pagoRepository.findById(id).orElse(null);
    }

    @Override
    public boolean exists(Long id) {
        if (id == null) {
            return false;  // Mejor manejar ID nulo antes de llamar al repositorio
        }
        return pagoRepository.existsById(id);
    }

    @Override
    public Pago save(Pago pago) {
        // Validar los datos del Pago antes de guardarlo
        if (pago == null) {
            throw new IllegalArgumentException("El pago no puede ser nulo");
        }
        if (pago.getVenta() == null || pago.getMedioDePago() == null) {
            throw new IllegalArgumentException("El pago debe tener una venta y un medio de pago asociados");
        }
        return pagoRepository.save(pago);
    }

    @Override
    public void delete(Long id) {
        // Verificar si el ID es válido y si el pago existe antes de eliminar
        if (id == null || !pagoRepository.existsById(id)) {
            throw new IllegalArgumentException("El pago con ID " + id + " no existe o el ID es nulo");
        }
        pagoRepository.deleteById(id);
    }

	//@Override
	//public List<Pago> findByClienteIdAndFechaBetween(Long clienteId, Date fechaInicio, Date fechaFin) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@Override
	public List<Pago> findByClienteIdAndFechaBetween(Long clienteId, LocalDate fechaInicio, LocalDate fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsByVentaId(Long ventaId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsByMedioDePagoId(Long medioDePagoId) {
		// TODO Auto-generated method stub
		return false;
	}
}
