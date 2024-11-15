package imb.progra3.grupo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import imb.progra3.grupo2.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    // Aquí puedes agregar métodos personalizados si necesitas realizar operaciones específicas para la entidad Cliente
	public List<Cliente> findByEnabledTrue();
	public List<Cliente> findByEnabledFalse();
	
	
}