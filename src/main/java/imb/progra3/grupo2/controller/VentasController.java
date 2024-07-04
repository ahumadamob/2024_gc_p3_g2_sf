package imb.progra3.grupo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import imb.progra3.grupo2.entity.Ventas;
import imb.progra3.grupo2.service.IVentasService;



@RestController
@RequestMapping("/api/v1/ventas")
public class VentasController {

	@Autowired
    private IVentasService ventasService;
	
	
	@GetMapping
    public List<Ventas> getAllClientes() {
        return ventasService.getAll();
    }
	
	@GetMapping("/{id_Ventas}")		
    public ResponseEntity<Ventas> getVentaseById(@PathVariable("id_Venta") Long id_Venta) {
        Ventas ventas = ventasService.getById(id_Venta);
        
        if (ventas != null) {
            return new ResponseEntity<>(ventas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	 @PostMapping						
	    public ResponseEntity<Ventas> createVentas(@RequestBody Ventas ventas) {
	        Ventas createdVentas = ventasService.save(ventas);
	        return new ResponseEntity<>(createdVentas, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id_Ventas}")		
	    public ResponseEntity<Ventas> updateVentas(@PathVariable("id_Ventas") Long id_Venta, @RequestBody Ventas ventas) {
	        if (ventasService.exists(id_Venta)) {
	            ventas.setId_Venta(id_Venta);
	            Ventas updatedVentas = ventasService.save(ventas);
	            return new ResponseEntity<>(updatedVentas, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id_Venta}")		
	    public ResponseEntity<Void> deleteVentas(@PathVariable("id_Venta") Long id_Venta) {
	        if (ventasService.exists(id_Venta)) {
	            ventasService.delete(id_Venta);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	
	
	
	
	
	
	
}
