package imb.progra3.grupo2.repository;

import imb.progra3.grupo2.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // No necesitas definir findAllById aquí, JpaRepository ya lo proporciona
}

