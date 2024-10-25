package imb.progra3.grupo2.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.repository.CarritoRepository;
import imb.progra3.grupo2.service.ICarritoService;

import java.util.List;

@Service
public class CarritoServiceImplJpa implements ICarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public List<Carrito> getAll() {
        return carritoRepository.findAll();
    }

    @Override
    public Carrito getById(Long id) {
        return carritoRepository.findById(id).orElse(null);
    }

    @Override
    public Carrito save(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public void delete(Long id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return id != null && carritoRepository.existsById(id);
    }

    @Override
    public List<Carrito> getAllEnabled() {
        return carritoRepository.findByEnabledTrue();
    }

    @Override
    public List<Carrito> getAllDisabled() {
        return carritoRepository.findByEnabledFalse();
    }
}
