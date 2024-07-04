package imb.progra3.grupo2.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.repository.ProductoRepository;
import imb.progra3.grupo2.service.IProductoService;


@Service
public class ProductoServiceImplJpa implements IProductoService {
	

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() {
		List<Producto> producto = productoRepository.findByDueDateNotNullOrderByDueDate();
		producto.addAll(productoRepository.findByDueDateNull());
		return producto;
	}

	@Override
	public Producto findById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void delete(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public boolean exists(Long id) {
		return id == null ? false : productoRepository.existsById(id);
	}

	@Override
	public List<Producto> findByDone(boolean done) {
		if(done) {
			List<Producto> producto = productoRepository.findByDueDateNotNullAndDoneTrueOrderByDueDate();
			producto.addAll(productoRepository.findByDueDateNullAndDoneTrue());
			return producto;
		}else {
			List<Producto> producto = productoRepository.findByDueDateNotNullAndDoneFalseOrderByDueDate();
			producto.addAll(productoRepository.findByDueDateNullAndDoneFalse());
			return producto;			
		}
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}