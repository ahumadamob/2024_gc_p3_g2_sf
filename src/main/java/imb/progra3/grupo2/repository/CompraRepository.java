package imb.progra3.grupo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import imb.progra3.grupo2.entity.Compra;
import imb.progra3.grupo2.entity.Producto;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    @Query("SELECT c.producto FROM Compra c WHERE c.cliente.id_Cliente = :id_Cliente")
    List<Producto> findProductosRecomendados(@Param("id_Cliente") Long id_Cliente);
}
