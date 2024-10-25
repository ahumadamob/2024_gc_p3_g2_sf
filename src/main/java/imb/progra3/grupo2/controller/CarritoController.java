package imb.progra3.grupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.service.ICarritoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carritos")
public class CarritoController {

    @Autowired
    private ICarritoService service;

    // GET /api/v1/carritos - Obtener todos los carritos
    @GetMapping
    public List<Carrito> getAllCarritos() {
        return service.getAll();
    }

    // GET /api/v1/carritos/{id} - Obtener un carrito por ID
    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getCarritoById(@PathVariable Long id) {
        Carrito carrito = service.getById(id);
        if (carrito != null) {
            return ResponseEntity.ok(carrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/v1/carritos - Crear un nuevo carrito
    @PostMapping ("/api/v1/carritos/post")
    public ResponseEntity<Carrito> createCarrito(@RequestBody Carrito carrito) {
        Carrito newCarrito = service.save(carrito);
        return ResponseEntity.status(201).body(newCarrito); // Código 201 para recurso creado
    }

    // PUT /api/v1/carritos/{id} - Actualizar un carrito existente
    @PutMapping("/{id}")
    public ResponseEntity<Carrito> updateCarrito(@PathVariable Long id, @RequestBody Carrito carritoDetails) {
        if (!service.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        Carrito existingCarrito = service.getById(id);

        // Actualizar los campos del carrito con los detalles recibidos
        existingCarrito.setPrecio(carritoDetails.getPrecio());
        existingCarrito.setEnabled(carritoDetails.isEnabled());
        existingCarrito.setCliente(carritoDetails.getCliente()); // Relaciones
        existingCarrito.setProducto(carritoDetails.getProducto()); 
        existingCarrito.setVentas(carritoDetails.getVentas());

        Carrito updatedCarrito = service.save(existingCarrito);
        return ResponseEntity.ok(updatedCarrito);
    }

    // DELETE /api/v1/carritos/{id} - Eliminar un carrito por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrito(@PathVariable Long id) {
        if (!service.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}