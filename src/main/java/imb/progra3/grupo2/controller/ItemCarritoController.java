package imb.progra3.grupo2.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo2.entity.ItemCarrito;
import imb.progra3.grupo2.service.IItemCarritoService;
import imb.progra3.grupo2.service.IProductoService;
import imb.progra3.grupo2.service.ICarritoService;
import imb.progra3.grupo2.util.APIResponse;
import imb.progra3.grupo2.util.ResponseUtil;

@RestController
@RequestMapping("/api/v1/item")
public class ItemCarritoController {

    @Autowired
    private IItemCarritoService itemCarritoService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ICarritoService carritoService;

    // Crear un ItemCarrito
    @PostMapping
    public ResponseEntity<APIResponse<ItemCarrito>> createItemCarrito(@RequestBody ItemCarrito itemCarrito) {
        try {
            // Validar carrito
            if (itemCarrito.getCarrito() == null || !carritoService.exists(itemCarrito.getCarrito().getId())) {
                return ResponseUtil.error(HttpStatus.BAD_REQUEST, "Carrito no válido");
            }

            // Validar producto
            if (itemCarrito.getProducto() == null || !productoService.exists(itemCarrito.getProducto().getId())) {
                return ResponseUtil.error(HttpStatus.BAD_REQUEST, "Producto no válido");
            }


            // Asignar carrito y producto al item
            itemCarrito.setCarrito(carritoService.getCarritoById(itemCarrito.getCarrito().getId()).orElseThrow(() ->
                new NoSuchElementException("Carrito no encontrado con ID: " + itemCarrito.getCarrito().getId())));

            itemCarrito.setProducto(
            	    productoService.getById(itemCarrito.getProducto().getId())
            	        .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con ID: " + itemCarrito.getProducto().getId()))
            	);


            // Guardar el item en la base de datos
            ItemCarrito savedItem = itemCarritoService.saveItemCarrito(itemCarrito);
            return ResponseUtil.created(savedItem);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseUtil.error(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el item del carrito: " + e.getMessage());
        }
    }

    // Obtener un ItemCarrito por ID
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ItemCarrito>> getItemCarritoById(@PathVariable Long id) {
        Optional<ItemCarrito> itemCarrito = itemCarritoService.getItemCarritoById(id);
        return itemCarrito.map(ResponseUtil::success)
                          .orElseGet(() -> ResponseUtil.notFound("ItemCarrito no encontrado con el ID: " + id));
    }

    // Obtener todos los items en un carrito
    @GetMapping("/carrito/{carritoId}")
    public ResponseEntity<APIResponse<List<ItemCarrito>>> getAllItemsInCarrito(@PathVariable Long carritoId) {
        List<ItemCarrito> items = itemCarritoService.getAllItemsInCarrito(carritoId);
        return ResponseUtil.success(items);
    }

    // Eliminar un ItemCarrito por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteItemCarrito(@PathVariable Long id) {
        try {
            itemCarritoService.deleteItemCarrito(id);
            return ResponseUtil.success("ItemCarrito eliminado con éxito.");
        } catch (NoSuchElementException e) {
            return ResponseUtil.notFound("ItemCarrito no encontrado con el ID: " + id);
        } catch (Exception e) {
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el item del carrito: " + e.getMessage());
        }
    }
}




