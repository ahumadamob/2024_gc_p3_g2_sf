package imb.progra3.grupo2.controller;

import imb.progra3.grupo2.entity.ItemCarrito;
import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.service.IProductoService;
import imb.progra3.grupo2.util.APIResponse;
import imb.progra3.grupo2.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    // Crear o actualizar un Producto
    @PostMapping
    public ResponseEntity<APIResponse<Producto>> saveProducto(@RequestBody Producto producto) {
        if (producto.getNombre() == null || producto.getPrecio() == null) {
            return ResponseUtil.error(HttpStatus.BAD_REQUEST, "Nombre y precio son obligatorios.");
        }
        Producto savedProducto = productoService.save(producto);
        return ResponseUtil.created(savedProducto);
    }

    // Obtener un Producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Producto>> getProductoById(@PathVariable Long id) {
        Optional<Producto> optionalProducto = productoService.getById(id);
        if (optionalProducto.isPresent()) {
            return ResponseUtil.success(optionalProducto.get());
        } else {
            return ResponseUtil.notFound("Producto no encontrado con el ID: " + id);
        }
    }

    // Obtener todos los Productos
    @GetMapping
    public ResponseEntity<APIResponse<List<Producto>>> getAllProductos() {
        List<Producto> productos = productoService.getAll();
        return ResponseUtil.success(productos);
    }

    // Eliminar un Producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteProducto(@PathVariable Long id) {
        if (productoService.exists(id)) {
            productoService.delete(id);
            return ResponseUtil.success("Producto eliminado con éxito.");
        } else {
            return ResponseUtil.notFound("Producto no encontrado con el ID: " + id);
        }
    }

    // Verificar stock de productos en una lista de items del carrito
    @PostMapping("/verificar-stock")
    public ResponseEntity<APIResponse<List<Producto>>> verificarStock(@RequestBody List<ItemCarrito> items) {
        List<Producto> productosSinStock = productoService.verificarStock(items);
        return ResponseUtil.success(productosSinStock);
    }
}

