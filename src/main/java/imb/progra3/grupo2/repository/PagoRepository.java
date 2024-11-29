package imb.progra3.grupo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import imb.progra3.grupo2.entity.Pago;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    @Query("SELECT p FROM Pago p WHERE p.venta.cliente.id = :clienteId AND p.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<Pago> findByClienteIdAndFechaBetween(Long clienteId, LocalDate fechaInicio, LocalDate fechaFin);
    boolean existsByVentaId(Long ventaId);

    boolean existsByMedioDePagoId(Long medioDePagoId);
}
