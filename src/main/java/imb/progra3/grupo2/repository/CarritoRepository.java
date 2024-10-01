package imb.progra3.grupo2.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.progra3.grupo2.entity.Carrito;
import imb.progra3.grupo2.entity.Cliente;

public interface CarritoRepository extends JpaRepository<Carrito, Long>{
	// Método para encontrar el carrito por la entidad Cliente
    Optional<Carrito> findByCliente(Cliente cliente);
}
