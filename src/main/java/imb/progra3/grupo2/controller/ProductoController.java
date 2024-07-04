package imb.progra3.grupo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.service.IProductoService;
import imb.progra3.grupo2.util.APIResponse;
import imb.progra3.grupo2.util.ResponseUtil;

@RestController
@RequestMapping(path="/api/v1/producto")//http://localhost:8080/api/v1/producto
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	
	
	@GetMapping
	public ResponseEntity<APIResponse<List<Producto>>> getAllproducto() {
		List<Producto> producto = productoService.findAll();
		return 	producto.isEmpty()? ResponseUtil.notFound("No se encontraron productos") :
				ResponseUtil.success(producto);		
	}
	
	@GetMapping("/done")							//http://localhost:8080/api/v1/producto/done
	public ResponseEntity<APIResponse<List<Producto>>> getAllProductoDone() {
		return this._getProductoByDone(true);	
	}
	
	@GetMapping("/undone")							//http://localhost:8080/api/v1/producto/undone
	public ResponseEntity<APIResponse<List<Producto>>> getAllProductoUndone() {
		return this._getProductoByDone(false);	
	}	
	
	private ResponseEntity<APIResponse<List<Producto>>> _getProductoByDone(boolean done) {
		List<Producto> producto = productoService.findByDone(done);
		return 	producto.isEmpty()? ResponseUtil.notFound("No se encontraron productos") :
				ResponseUtil.success(producto);		
	}	
	
	@GetMapping("{id}")					//http://localhost:8080/api/v1/producto/30
	public ResponseEntity<APIResponse<Producto>> getProductoById(@PathVariable("id") Long id){
		return 	productoService.exists(id)? ResponseUtil.success(productoService.findById(id)):
				ResponseUtil.notFound("No se encontró los productos con id {0}", id);
	}
	
	@PostMapping
	public ResponseEntity<APIResponse<Producto>> createProducto(@RequestBody Producto producto){
		return 	productoService.exists(producto.getId())? ResponseUtil.badRequest("Ya existe un producto con id {0}", producto.getId()):
				ResponseUtil.success(productoService.save(producto));
	}
	
	@PutMapping
	public ResponseEntity<APIResponse<Producto>> updateProducto(@RequestBody Producto producto){
		return 	productoService.exists(producto.getId())? ResponseUtil.success(productoService.save(producto)):
				ResponseUtil.badRequest("No existe un producto con id {0}", producto.getId());
	}
	
	@PatchMapping("/done/{id}")
	private ResponseEntity<APIResponse<Producto>> setProductoAsDone(@PathVariable("id") Long id){
		return this._setProductoDone(id, true);
	}
	
	@PatchMapping("/undone/{id}")
	private ResponseEntity<APIResponse<Producto>> setProductoAsUndone(@PathVariable("id") Long id){
		return this._setProductoDone(id, false);
	}	
	
	private ResponseEntity<APIResponse<Producto>> _setProductoDone(Long id, boolean done){
		if(productoService.exists(id)) {
			Producto producto = productoService.findById(id);
			producto.setDone(done);
			productoService.save(producto);
			return ResponseUtil.success(producto);
		}else {
			return ResponseUtil.badRequest("No existe un producto con id {0}", id);
		}
	}

	
	
	@DeleteMapping("{id}")
	public ResponseEntity<APIResponse<Producto>> deleteProducto(@PathVariable("id") Long id){
		if(productoService.exists(id)) {
			productoService.delete(id);
			return ResponseUtil.successDeleted("Se eliminó el producto con el id {0}", id);
		}else {
			return ResponseUtil.badRequest("No se encontró el producto con el id {0}", id);
		}		
	}
	
 
}