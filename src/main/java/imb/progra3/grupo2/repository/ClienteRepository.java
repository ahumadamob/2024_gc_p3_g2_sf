package imb.progra3.grupo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import imb.progra3.grupo2.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    // Aquí puedes agregar consultas personalizadas si es necesario
}
