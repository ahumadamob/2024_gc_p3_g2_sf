package imb.progra3.grupo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import imb.progra3.grupo2.entity.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long>{


   // List<Producto> findByDueDateNotNullOrderByDueDate();    
   // List<Producto> findByDueDateNull();
   // List<Producto> findByDueDateNotNullAndDoneTrueOrderByDueDate();
  //  List<Producto> findByDueDateNullAndDoneTrue();
    //List<Producto> findByDueDateNotNullAndDoneFalseOrderByDueDate();
   //List<Producto> findByDueDateNullAndDoneFalse();    
	List<Producto> findByNombre(String nombre); //  busca por nombre
    List<Producto> findByCategoria(String categoria); 
}
