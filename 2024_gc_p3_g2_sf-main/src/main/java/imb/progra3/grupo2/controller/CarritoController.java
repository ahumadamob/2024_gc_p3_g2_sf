package imb.progra3.grupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.service.ICarritoService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/carrito")
public class CarritoController {

    @Autowired
    private ICarritoService carritoService;

    // POST: Validar y guardar un carrito
    @PostMapping("/validar")
    public ResponseEntity<Map<String, Object>> validarCarrito(@RequestBody Carrito carrito) {
        validarCarritoInput(carrito); // Validaciones directas antes de llamar al servicio
        Carrito savedCarrito = carritoService.saveCarrito(carrito);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
            "status", "success",
            "data", savedCarrito
        ));
    }

    // GET: Obtener un carrito por ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCarritoById(@PathVariable Long id) {
        return carritoService.getCarritoById(id)
            .map(carrito -> ResponseEntity.ok(Map.of(
                "status", "success",
                "data", carrito
            )))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "status", "error",
                "message", "Carrito no encontrado con ID: " + id
            )));
    }

    // DELETE: Eliminar un carrito por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCarrito(@PathVariable Long id) {
        if (!carritoService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "status", "error",
                "message", "Carrito no encontrado con ID: " + id
            ));
        }
        carritoService.deleteCarrito(id);
        return ResponseEntity.ok(Map.of(
            "status", "success",
            "message", "Carrito eliminado exitosamente"
        ));
    }

    // GET: Obtener todos los carritos
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllCarritos() {
        List<Carrito> carritos = carritoService.getAllCarritos();
        return ResponseEntity.ok(Map.of(
            "status", "success",
            "data", carritos
        ));
    }

    // GET: Verificar stock de productos en el carrito de un cliente
    @GetMapping("/{clienteId}/verificar-stock")
    public ResponseEntity<Map<String, Object>> verificarStock(@PathVariable Long clienteId) {
        List<Producto> productosSinStock = carritoService.verificarStock(clienteId);
        if (productosSinStock.isEmpty()) {
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Todos los productos tienen suficiente stock."
            ));
        }
        return ResponseEntity.ok(Map.of(
            "status", "success",
            "data", productosSinStock
        ));
    }

    // Método privado para validar las entradas del carrito
    private void validarCarritoInput(Carrito carrito) {
        if (carrito.getCliente() == null || carrito.getCliente().getId() == null) {
            throw new IllegalArgumentException("Cliente no válido");
        }
        if (!carrito.isEnabled()) {
            throw new IllegalStateException("El carrito debe estar habilitado");
        }
        if (carrito.getVentas() == null || carrito.getVentas().getId() == null ||
            !carritoService.existsByVentasIdAndEnabledTrue(carrito.getVentas().getId())) {
            throw new IllegalStateException("La venta asociada no existe o no está activa");
        }
    }
}
