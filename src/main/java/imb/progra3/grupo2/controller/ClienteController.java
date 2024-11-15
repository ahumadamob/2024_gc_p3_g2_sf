package imb.progra3.grupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo2.entity.Cliente;
import imb.progra3.grupo2.service.IClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")                              
public class ClienteController {
	
    @Autowired
    private IClienteService clienteService;

    // Metodos del controlador
    
    @GetMapping(path="/cliente")                         //http://localhost:8080/api/v1/cliente
    public List<Cliente> showAllCliente() {
        return clienteService.getAll();
    }

 
 
    
	@GetMapping(path="disabledcliente")					// http://localhost:8080/api/v1/disabledcliente
	public List<Cliente> showDisabledCliente(){
		return clienteService.getAllDisabled();
	}
	
	@GetMapping(path="enabledcliente")					// http://localhost:8080/api/v1/enabledcliente
	public List<Cliente> showEnabledCliente(){
		return clienteService.getAllEnabled();
	}
    
     
}