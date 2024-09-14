package imb.progra3.grupo2.service;


import java.util.List;
import java.util.Optional;

import imb.progra3.grupo2.entity.Carrito;



public interface ICarritoService {
	Carrito saveCarrito(Carrito carrito);
    Optional<Carrito> getCarritoById(Long id);
    List<Carrito> getAllCarritos();
    void deleteCarrito(Long id);
}
