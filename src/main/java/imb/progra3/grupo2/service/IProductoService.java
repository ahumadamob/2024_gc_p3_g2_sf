package imb.progra3.grupo2.service;

import java.util.List;

import imb.progra3.grupo2.entity.Producto;

public interface IProductoService {
    List<Producto> getAll();
    Producto getById(Long id);
    Producto save(Producto producto);
    void delete(Long id);
    boolean exists(Long id);
	List<Producto> findAll();
	List<Producto> findByDone(boolean done);
	Producto findById(Long id);
}