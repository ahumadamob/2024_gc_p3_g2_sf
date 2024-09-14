package imb.progra3.grupo2.service;

import java.util.List;

import imb.progra3.grupo2.entity.ItemCarrito;
import imb.progra3.grupo2.entity.Producto;

public interface IProductoService {
    
	public List<Producto> getAll();
    public Producto getById(Long id_Producto);
    public Producto save(Producto producto);
    public void delete(Long id_Producto);
    public boolean exists(Long id_Producto);
    List<Producto> verificarStock(List<ItemCarrito> items);
}
