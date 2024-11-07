package imb.progra3.grupo2.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.service.ICarritoService;
import imb.progra3.grupo2.util.APIResponse;
import imb.progra3.grupo2.util.ResponseUtil;

@RestController
@RequestMapping("/api/v1/carrito")
public class CarritoController {

    @Autowired
    private ICarritoService carritoService;

    // Crear o actualizar un carrito
    @PostMapping
    public ResponseEntity<APIResponse<Carrito>> createOrUpdateCarrito(@RequestBody Carrito carrito) {
        try {
            // Validar que el cliente no sea nulo
        	if (carrito.getCliente() == null || carrito.getCliente().getId() == null) {
        	    return ResponseUtil.badRequest("Cliente no válido");
        	}


            Carrito savedCarrito = carritoService.saveCarrito(carrito);
            return ResponseUtil.created(savedCarrito);
        } catch (Exception e) {
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear o actualizar el carrito: " + e.getMessage());
        }
    }

    // Obtener un carrito por ID
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Carrito>> getCarritoById(@PathVariable Long id) {
        Optional<Carrito> carrito = carritoService.getCarritoById(id);
        return carrito.map(ResponseUtil::success)
                      .orElseGet(() -> ResponseUtil.notFound("Carrito no encontrado"));
    }

    // Eliminar un carrito por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteCarrito(@PathVariable Long id) {
        try {
            carritoService.deleteCarrito(id);
            return ResponseUtil.success("Carrito eliminado con éxito");
        } catch (NoSuchElementException e) {
            return ResponseUtil.notFound("Carrito no encontrado");
        }
    }

    // Obtener todos los carritos
    @GetMapping
    public ResponseEntity<APIResponse<List<Carrito>>> getAllCarritos() {
        List<Carrito> carritos = carritoService.getAllCarritos();
        return ResponseUtil.success(carritos);
    }
    
    @GetMapping("/{clienteId}/verificar-stock")
    public ResponseEntity<APIResponse<List<Producto>>> verificarStock(@PathVariable Long clienteId) {
        try {
            // Obtiene los productos que no tienen suficiente stock
            List<Producto> productosSinStock = carritoService.verificarStock(clienteId);

            // Si no hay productos sin stock, devuelve un mensaje indicando que todo está bien
            if (productosSinStock.isEmpty()) {
                return ResponseUtil.success("Todos los productos tienen suficiente stock.");
            } else {
                // Devuelve los productos que no tienen suficiente stock
                return ResponseUtil.success(productosSinStock);
            }
        } catch (NoSuchElementException e) {
            // Si no se encuentra el carrito para el cliente, devuelve un mensaje de error
            return ResponseUtil.notFound("Carrito no encontrado para el cliente con ID: " + clienteId);
        } catch (IllegalStateException e) {
            // Captura errores de negocio como falta de stock o inconsistencias
            return ResponseUtil.error(HttpStatus.BAD_REQUEST, "Problema con el stock: " + e.getMessage());
        } catch (Exception e) {
            // Captura cualquier otro tipo de error inesperado
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, "Error al verificar stock: " + e.getMessage());
        }
    }


}

