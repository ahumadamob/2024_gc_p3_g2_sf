package imb.progra3.grupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo2.entity.Pago;
import imb.progra3.grupo2.service.IPagoService;
import imb.progra3.grupo2.util.APIResponse;
import imb.progra3.grupo2.util.ResponseUtil;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private IPagoService pagoService;

    @GetMapping("/historial/{clienteId}")
    public ResponseEntity<List<Pago>> obtenerHistorialPagos(
            @PathVariable Long clienteId,
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        List<Pago> pagos = pagoService.findByClienteIdAndFechaBetween(clienteId, fechaInicio, fechaFin);
        return ResponseEntity.ok(pagos);
    }
    
 // Endpoint para validar el pago
    @PostMapping("/validar")
    public ResponseEntity<APIResponse<Pago>> validarPago(@RequestBody Pago pago) {
        try {
            // Validación de monto mayor que 0
            if (pago.getMonto() <= 0) {
                return ResponseUtil.badRequest("El monto debe ser mayor que 0.");
            }

            // Validación de la fecha de pago no posterior a la fecha actual
            if (pago.getFecha().isAfter(LocalDate.now())) {
                return ResponseUtil.badRequest("La fecha de pago no puede ser posterior a la fecha actual.");
            }

            // Validación de que el id_Venta no sea nulo
            if (pago.getVenta() == null || pago.getVenta().getId() == null) {
                return ResponseUtil.badRequest("El id de la venta no puede ser nulo.");
            }

            // Validación de que la venta exista
            if (!pagoService.exists(pago.getVenta().getId())) {
                return ResponseUtil.badRequest("La venta asociada no existe.");
            }

            // Validación de que el id_MedioDePago no sea nulo
            if (pago.getMedioDePago() == null || pago.getMedioDePago().getId() == null) {
                return ResponseUtil.badRequest("El id del medio de pago no puede ser nulo.");
            }

            // Validación de que el medio de pago exista
            if (!pagoService.exists(pago.getMedioDePago().getId())) {
                return ResponseUtil.badRequest("El medio de pago asociado no existe.");
            }

            // Si pasa todas las validaciones, guardamos el pago
            Pago savedPago = pagoService.save(pago);

            // Devolvemos la respuesta exitosa con el pago guardado
            return ResponseUtil.created(savedPago);

        } catch (Exception e) {
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, "Error al procesar el pago: " + e.getMessage());
        }
    }
    
    
    
}
