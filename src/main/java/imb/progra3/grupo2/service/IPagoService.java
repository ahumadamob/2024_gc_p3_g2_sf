package imb.progra3.grupo2.service;

import imb.progra3.grupo2.entity.Pago;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IPagoService {

    // Métodos CRUD básicos
    List<Pago> findAll();
    Pago findById(Long id);
    boolean exists(Long id);
    Pago save(Pago pago);
    void delete(Long id);
    boolean existsByVentaId(Long ventaId);
    boolean existsByMedioDePagoId(Long medioDePagoId);

    // Método para obtener historial de pagos de un cliente en un rango de fechas específico
    //List<Pago> findByClienteIdAndFechaBetween(Long clienteId, LocalDate fechaInicio, LocalDate fechaFin);
	List<Pago> findByClienteIdAndFechaBetween(Long clienteId, LocalDate fechaInicio, LocalDate fechaFin);
}

//public interface IPagoService {





