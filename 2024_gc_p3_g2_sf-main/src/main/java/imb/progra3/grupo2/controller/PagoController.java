package imb.progra3.grupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo2.entity.Pago;
import imb.progra3.grupo2.service.IPagoService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pagos")
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
}
