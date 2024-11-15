package imb.progra3.grupo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.progra3.grupo2.entity.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
	
 // Aquí puedes agregar métodos personalizados si necesitas realizar operaciones específicas para la entidad Carrito
	public List<Carrito> findByEnabledTrue();
   	public List<Carrito> findByEnabledFalse();
}