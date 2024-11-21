
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.entity.Cliente;
import imb.progra3.grupo2.entity.ItemCarrito;
import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.service.ICarritoService;
import imb.progra3.grupo2.service.IClienteService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/cliente")				//Obtener todos los clientes		// http://localhost:8080/api/v1/cliente
    public class ClienteController {

        @Autowired
        private IClienteService clienteService;
        @Autowired
        private ICarritoService carritoService;  // Inyección del servicio CarritoService

        @GetMapping
        public ResponseEntity<List<Cliente>> getAllClientes() {
            try {
                List<Cliente> clientes = clienteService.getAll();
                if (clientes.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(clientes, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    
 

    @GetMapping("/{id_Cliente}")		//Obtener un cliente por ID			//http://localhost:8080/api/v1/cliente/25
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id_Cliente") Long id_Cliente) {
        Cliente cliente = clienteService.getById(id_Cliente);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

  
    @PostMapping       //Crear un nuevo cliente           //http://localhost:8080/api/v1/cliente
    public ResponseEntity<Cliente> createCliente(@RequestBody @Validated Cliente cliente) {
        try {
            Cliente createdCliente = clienteService.save(cliente);
            return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            // Manejar violaciones de integridad de datos (ej. cliente ya existe)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
	@GetMapping(path="disabledcliente")					// http://localhost:8080/api/v1/disabledcliente
	public List<Cliente> showDisabledCliente(){
		return clienteService.getAllDisabled();
	}
	
	@GetMapping(path="enabledcliente")					// http://localhost:8080/api/v1/enabledcliente
	public List<Cliente> showEnabledCliente(){
		return clienteService.getAllEnabled();
	}
    
     
    @PutMapping("/{id_Cliente}")		//Actualizar un cliente existente	//http://localhost:8080/api/v1/cliente/25
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id_Cliente") Long id_Cliente, @RequestBody Cliente cliente) {
    	if (clienteService.exists(cliente.getId())) {  // Cambia a cliente.getId() si el método existe() usa el ID heredado
    	    cliente.setId(id_Cliente);  // Asegúrate de que el método setId() esté en Cliente
    	    Cliente updatedCliente = clienteService.save(cliente);
    	    return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    	} else {
    	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Opcional: manejar el caso en que el cliente no exista
    	}

        
    }

    @DeleteMapping("/{id_Cliente}")		//Eliminar un cliente por ID			//http://localhost:8080/api/v1/cliente/1
    public ResponseEntity<Void> deleteCliente(@PathVariable("id_Cliente") Long id_Cliente) {
        if (clienteService.exists(id_Cliente)) {
            clienteService.delete(id_Cliente);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/{clienteId}/total")
    public ResponseEntity<?> calcularTotalCarrito(@PathVariable Long clienteId) {
        try {
            // Obtener carrito del cliente
            Carrito carrito = carritoService.getByClienteId(clienteId);
            
            // Verificar si el carrito existe
            if (carrito == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontró un carrito para el cliente con ID: " + clienteId);
            }

            // Lógica para calcular el total con descuentos (puedes agregar la lógica aquí)
            double total = calcularTotalConDescuentos(carrito); // Método para calcular el total
            return ResponseEntity.ok(total);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Hubo un error al calcular el total del carrito.");
        }
    }

    // Método para calcular el total con descuentos (ejemplo básico de cálculo de total)
    private double calcularTotalConDescuentos(Carrito carrito) {
        double total = 0.0;

        // Recorre los items del carrito y calcula el total
        for (ItemCarrito item : carrito.getItems()) {
            double precioProducto = item.getProducto().getPrecio(); // Obtener precio del producto
            total += precioProducto * item.getCantidad(); // Multiplicar por la cantidad
        }

        // Aquí puedes agregar lógica para aplicar descuentos si es necesario

        return total;
    }

}
