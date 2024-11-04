package imb.progra3.grupo2.service;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.service.ICarritoService;
import java.util.List;

public interface ICarritoService {
    List<Carrito> getAll();
    Carrito getById(Long id);
    Carrito save(Carrito carrito);
    void delete(Long id);
    boolean exists(Long id);
	List<Carrito> getAllDisabled();
	List<Carrito> getAllEnabled();
}