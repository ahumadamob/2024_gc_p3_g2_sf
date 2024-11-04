package imb.progra3.grupo2.repository;

import imb.progra3.grupo2.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {
    
    @Query("SELECT v.mediodePago.nombre AS nombre, SUM(v.total) AS totalVentas, COUNT(v) AS totalTransacciones " +
           "FROM Ventas v GROUP BY v.mediodePago")
    List<Object[]> findInformePorMetodoDePago();
}

