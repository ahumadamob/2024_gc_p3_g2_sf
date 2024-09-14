package imb.progra3.grupo2.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import imb.progra3.grupo2.entity.Carrito;

import imb.progra3.grupo2.repository.CarritoRepository;

import imb.progra3.grupo2.service.ICarritoService;

public class CarritoServiceImpl implements ICarritoService {
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
	public List<Carrito> getAllCarritos() {
		 return carritoRepository.findAll();
	}

	@Override
	public void deleteCarrito(Long id) {
		carritoRepository.deleteById(id);
		
	}


   



  
}
