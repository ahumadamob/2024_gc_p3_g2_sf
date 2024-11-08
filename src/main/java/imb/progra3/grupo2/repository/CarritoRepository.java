package imb.progra3.grupo2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.progra3.grupo2.entity.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    // Método para encontrar el carrito por el id del cliente
    Optional<Carrito> findByClienteId(Long clienteId);
}
