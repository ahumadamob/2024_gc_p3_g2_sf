package imb.progra3.grupo2.repository;

import imb.progra3.grupo2.entity.Carrito;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    
    // Método para encontrar carritos habilitados
    List<Carrito> findByEnabledTrue();

    // Método para encontrar carritos deshabilitados
    List<Carrito> findByEnabledFalse();

    boolean existsByVentasIdAndEnabledTrue(Long ventasId);

}
