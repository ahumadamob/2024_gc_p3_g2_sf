package imb.progra3.grupo2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.service.ICarritoService;



@RestController
@RequestMapping("/api/v1/carrito")
public class CarritoController {

	 @Autowired
	    private ICarritoService carritoService;

	    @PostMapping
	    public Carrito createCarrito(@RequestBody Carrito carrito) {
	        return carritoService.saveCarrito(carrito);
	    }

	    @GetMapping("/{id}")
	    public Carrito getCarritoById(@PathVariable("id") Long id) {
	        return carritoService.getCarritoById(id).orElse(null);
	    }

	    @GetMapping
	    public List<Carrito> getAllCarritos() {
	        return carritoService.getAllCarritos();
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCarrito(@PathVariable("id") Long id) {
	        carritoService.deleteCarrito(id);
	    }
}
