package imb.progra3.grupo2.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.progra3.grupo2.entity.ItemCarrito;

public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long> {
	 List<ItemCarrito> findByCarritoId(Long carritoId);
}