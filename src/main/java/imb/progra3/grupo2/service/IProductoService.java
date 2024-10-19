package imb.progra3.grupo2.service;

import java.util.List;
import java.util.Optional; // Asegúrate de importar Optional

import imb.progra3.grupo2.entity.ItemCarrito;
import imb.progra3.grupo2.entity.Producto;

public interface IProductoService {
    
    List<Producto> getAll();                     // Obtener todos los productos
    Optional<Producto> getById(Long id_Producto); // Cambiado a Optional
    Producto save(Producto producto);            // Guardar producto
    void delete(Long id_Producto);               // Eliminar producto
    boolean exists(Long id_Producto);            // Verificar si existe producto
    
    // Método para verificar el stock de una lista de items en el carrito
    List<Producto> verificarStock(List<ItemCarrito> items);
}
