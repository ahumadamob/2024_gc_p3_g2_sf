package imb.progra3.grupo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import imb.progra3.grupo2.entity.MedioDePago;

import java.util.Optional;

public interface MedioDePagoRepository extends JpaRepository<MedioDePago, Long> {
    
    // Método para encontrar un medio de pago por su nombre
    Optional<MedioDePago> findByNombre(String nombre);

    // Método para encontrar un medio de pago por su tipo
    Optional<MedioDePago> findByTipo(String tipo);

    // Método para verificar si un medio de pago existe por nombre
    boolean existsByNombre(String nombre);
}






