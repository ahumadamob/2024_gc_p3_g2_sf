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


import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.service.IProductoService;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {
	 @Autowired
	    private IProductoService productoService;

	    @GetMapping
	    public List<Producto> getAllClientes() {
	        return productoService.getAll();
	    }

	    @GetMapping("/{id_Producto}")		//Obtener un Producto por ID			
	    public ResponseEntity<Producto> getProductoById(@PathVariable("id_Producto") Long id_Producto) {
	    	Producto producto = productoService.getById(id_Producto);
	        if (producto != null) {
	            return new ResponseEntity<>(producto, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping						//Crear un nuevo Producto          
	    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
	    	Producto createdProducto = productoService.save(producto);
	        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id_Producto}")		//Actualizar un Producto existente	
	    public ResponseEntity<Producto> updateProductoe(@PathVariable("id_Producto") Long id_Producto, @RequestBody Producto producto) {
	        if (productoService.exists(id_Producto)) {
	        	producto.setId_producto(id_Producto);
	        	Producto updatedProducto = productoService.save(producto);
	            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id_Cliente}")		//Eliminar un Producto por ID			
	    public ResponseEntity<Void> deleteProducto(@PathVariable("id_Producto") Long id_Producto) {
	        if (productoService.exists(id_Producto)) {
	        	productoService.delete(id_Producto);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

}
