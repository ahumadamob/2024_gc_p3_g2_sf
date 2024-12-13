package imb.progra3.grupo2.controller;

import imb.progra3.grupo2.entity.Ventas;
import imb.progra3.grupo2.service.IVentasService;
import imb.progra3.grupo2.util.APIResponse;
import imb.progra3.grupo2.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")

public class VentasController {

    @Autowired
    private IVentasService ventasService;

    @GetMapping("/informe/metodo-pago")
    public List<Map<String, Object>> getInformePorMetodoDePago() {
        List<Object[]> resultados = ventasService.findInformePorMetodoDePago();
        List<Map<String, Object>> informe = new ArrayList<>();

        for (Object[] resultado : resultados) {
            Map<String, Object> data = new HashMap<>();
            data.put("nombre", resultado[0]); // nombre del medio de pago
            data.put("totalVentas", resultado[1]); // suma total de ventas
            data.put("totalTransacciones", resultado[2]); // conteo de transacciones
            informe.add(data);
        }

        return informe;
    }
    
    
    
 // Crear o actualizar un carrito
    @PostMapping
    public ResponseEntity<APIResponse<Ventas>> createOrUpdateVentas(@RequestBody Ventas ventas) {
        try {
            // Validar que el cliente no sea nulo
        	if (ventas.getCliente() == null || ventas.getCliente().getId() == null) {
        	    return ResponseUtil.badRequest("Ventas no válido");
        	}


            Ventas savedVentas = ventasService.save(ventas);
            return ResponseUtil.created(savedVentas);
        } catch (Exception e) {
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear o actualizar el carrito: " + e.getMessage());
        }
    }
    
    
}


