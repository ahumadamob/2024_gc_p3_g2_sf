package imb.progra3.grupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo2.entity.Cliente;
import imb.progra3.grupo2.service.IClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")		//Obtener todos los clientes		// http://localhost:8080/api/v1/cliente

public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAll();
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

    @PostMapping						//Crear un nuevo cliente           //http://localhost:8080/api/v1/cliente
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.save(cliente);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id_Cliente}")		//Actualizar un cliente existente	//http://localhost:8080/api/v1/cliente/25
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id_Cliente") Long id_Cliente, @RequestBody Cliente cliente) {
        if (clienteService.exists(id_Cliente)) {
            cliente.setId_Cliente(id_Cliente);
            Cliente updatedCliente = clienteService.save(cliente);
            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
}
